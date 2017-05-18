package controller;

import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.NotenModel;
import model.Student;

public class StudentSelectController implements ListSelectionListener{

	@Override
	public void valueChanged(ListSelectionEvent list) {
		if(list.getValueIsAdjusting())
			return;
		JList studentsList = (JList)list.getSource();
		JTable notenTable = (JTable)studentsList.getParent().getComponent(3);
		Student selected = null;
		
		int index = studentsList.getSelectedIndex();
		if (index!=-1)	
			selected = (Student)studentsList.getModel().getElementAt(index);
		((NotenModel)notenTable.getModel()).refreshNoten(selected);
	}
}
