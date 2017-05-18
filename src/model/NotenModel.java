package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class NotenModel extends AbstractTableModel {
	
	protected Connection connection;
	protected PreparedStatement stmtNoten;
	protected Student student;
	public final int semNum = 8;
	
	public NotenModel(Connection conn, Student stud){
		connection = conn;
		student=stud;
		
		String sqlstr = "SELECT Kurzname, Note, Versuch, Semester "+
						"FROM nimmt_teil, Kurse "+
						"WHERE nimmt_teil.KursNr = Kurse.KursNr "+
						"AND MatrNr = ? "+
						"AND Note is not null "+
						"ORDER BY StdSem, Kurse.KursNr, Versuch";
		try {
			stmtNoten = conn.prepareStatement(sqlstr);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int getColumnCount() {
		if (student!=null)
			return semNum+1;
		else
			return semNum+1;
	}

	@Override
	public int getRowCount() {
		if (student!=null)
			return student.getNoten().size()+1;
		else
			return 1;
	}

	@Override
	public Object getValueAt(int x, int y) {
		
		if(y==0 && x==0)
			return "";
		
		if (student != null){
			int start = student.getStartsemester();
			if (x == 0){
				y++;
			
				if((start+y * 5)%10==0)
					return "S " + ((start + y * 5)/10);
				else
					return "W " + ((start + (y-1) * 5)/10)+"/"+(((start + (y-1) * 5)/10+1)%100);	
			}
			else{
				
				Note n = student.getNoten().get(x-1);
				if(y==0)
					return n.getKursname();

				if(n.getSemester()==((y-1)*5+start))
					return String.format("%2.1f (%d)", n.getNotenwert()/10.0, n.getVersuch());
				return "";
			}
		}
		else
			return "";
	}
	
	public void refreshNoten(Student student){		
		this.student = student;	
		
		if(student!=null){		
			student.setNoten(new ArrayList());
			try {
				stmtNoten.setInt(1, student.getMatrNr());
				ResultSet rs = stmtNoten.executeQuery();
				while (rs.next()) {
					boolean completeNote = true;
					Note n = new Note();
					n.setKursname(rs.getString("Kursname"));
					completeNote = completeNote && (n.getKursname() != null);
					n.setNotenwert(rs.getInt("Note"));
					completeNote = completeNote && !rs.wasNull();
					n.setSemester(rs.getInt("Semester"));
					completeNote = completeNote && !rs.wasNull();
					n.setVersuch(rs.getInt("Versuch"));
					completeNote = completeNote && !rs.wasNull();
					if (completeNote)
						student.addNote(n);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		fireTableStructureChanged();
	}
}