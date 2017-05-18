package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListDataListener;
import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;


import controller.StudentsSearchController;
import controller.StudentSelectController;


import model.NotenModel;
import model.StudentModel;


public class TableView extends JPanel  {
	
	protected final float leftRatio = 0.3f;
	protected final int heightTextField = 30;
	protected final int margin = 10;
	
	protected JTextField matrikelnr;
	protected JList studentsList;
	protected JTable notenTable;
	protected JLabel titel;
	
	public TableView(StudentModel studentModel, NotenModel notenModel) {

		setLayout(null);		
			
		titel = new JLabel("Matrikelnummer:");
		titel.setHorizontalTextPosition(JLabel.CENTER);		
		add(titel);
		
		matrikelnr = new JTextField(){
			@Override
			protected void processKeyEvent(KeyEvent e) {
				char c = e.getKeyChar();
				if(Character.isDigit(c) || c=='\b')
					super.processKeyEvent(e);
				else
					e.consume();
			}
		};
		matrikelnr.addKeyListener(new StudentsSearchController());
		add(matrikelnr);
		
		
		studentsList = new JList(studentModel);
		studentsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		studentsList.addListSelectionListener(new StudentSelectController());
		add(studentsList);
		
		notenTable = new JTable(notenModel){
			int i=0;
			
			@Override
			public void tableChanged(TableModelEvent e) {
				Container parent = getParent();
				if (parent != null) {
					parent.repaint(); //redraw the TableView after changes in the TableModel
				}
				super.tableChanged(e);
			}

		};
		add(notenTable);		
	}

	public void setSizes(){
		Dimension parent = getParent().getSize();
		Object parentObj = getParent();
		titel.setBounds(margin, 0,(int)(parent.width*leftRatio -2*margin), heightTextField);
		matrikelnr.setBounds(margin, heightTextField+margin,(int)(parent.width*leftRatio)-2*margin, heightTextField);
		studentsList.setBounds(margin, heightTextField*2+2*margin, (int)(parent.width*leftRatio)-2*margin, parent.height-2*heightTextField-3*margin);
		notenTable.setBounds((int)(parent.width*leftRatio), margin, parent.width-(int)(parent.width*leftRatio)-margin, parent.height-2*margin);
		int rowHeight = (parent.height-2*margin)/notenTable.getRowCount();
		notenTable.setRowHeight(rowHeight>0?rowHeight:1);
	}
	
	@Override
	public void paint(Graphics g) {
		setSizes();
		super.paint(g);
	}
	
}
