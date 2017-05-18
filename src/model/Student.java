package model;

import java.util.ArrayList;

public class Student {
	private String Name;
	private int MatrNr;
	private int Startsemester;
	private ArrayList <Note> Noten;

	public Student(String name, int matrNr) {
		Name = name;
		MatrNr = matrNr;
		Noten = new ArrayList <Note> ();
	}

	//create empty student template
	public Student() {
		MatrNr = -1;
		Startsemester = -1;
		Noten = new ArrayList <Note> ();
	}
	
	public void reset () {
		MatrNr = -1;
		Startsemester = -1;
		Name = null;
		Noten.clear();
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getMatrNr() {
		return MatrNr;
	}

	public void setMatrNr(int matrNr) {
		MatrNr = matrNr;
	}

	public int getStartsemester() {
		return Startsemester;
	}

	public void setStartsemester(int startsemester) {
		Startsemester = startsemester;
	}

	public ArrayList<Note> getNoten() {
		return Noten;
	}
	
	public void addNote(Note n) {
		Noten.add(n);
	}
	
	@Override
	public String toString() {
		return getName();
	}
	
	public void setNoten(ArrayList<Note> noten) {
		Noten = noten;
	}
}
