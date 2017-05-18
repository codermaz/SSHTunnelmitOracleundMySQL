package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextField;

import model.NotenModel;
import model.StudentModel;

public class StudentsSearchController implements KeyListener {

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
		JTextField textField = (JTextField)e.getSource();
		String matrikelno = textField.getText();

		JList studentsList = (JList)textField.getParent().getComponent(2);
		((StudentModel)studentsList.getModel()).refreshStudents(matrikelno);
		studentsList.clearSelection();
		JTable notenTable = (JTable)studentsList.getParent().getComponent(3);
		((NotenModel)notenTable.getModel()).refreshNoten(null);
	}

	@Override
	public void keyTyped(KeyEvent arg0) {		
	}
	
}
