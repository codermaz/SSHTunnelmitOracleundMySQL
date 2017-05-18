package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListDataListener;


public class StudentModel extends AbstractListModel{

	protected Connection connection;
	protected PreparedStatement stmtStud;
	protected ArrayList<Student> students;
	
	public StudentModel(Connection conn) {
		students = new ArrayList<Student>();
		connection = conn;
		String sqlstr = "SELECT MatrNr, Name, to_char(Studienbeginn, 'yyyy') StdBegJahr, " +
						"to_char(Studienbeginn, 'mm') StdBegMonat " +
						"FROM Studenten WHERE MatrNr LIKE ?";
		try {
			stmtStud = conn.prepareStatement(sqlstr);
			refreshStudents("");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void refreshStudents(String matr){
		try {
			students.clear();
			stmtStud.setString(1, matr+"%");
			ResultSet rs = stmtStud.executeQuery();
			Student s;
			while (rs.next()){
				s = new Student();
				s.setMatrNr(Integer.parseInt(rs.getString("MatrNr")));
				s.setName(rs.getString("Name"));
				s.setStartsemester(Integer.parseInt(rs.getString("StdBegJahr")==null?"0":rs.getString("StdBegJahr"))*10);
				if (Integer.parseInt(rs.getString("StdBegMonat")==null?"0":rs.getString("StdBegMonat")) > 6) 
					s.setStartsemester(s.getStartsemester()+5);
				students.add(s);
			}
			//View benachrichtigen
			this.fireContentsChanged(this, 0, getSize()-1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Object getElementAt(int index) {
		return students.get(index);
	}

	@Override
	public int getSize() {
		return students.size();
	}

}