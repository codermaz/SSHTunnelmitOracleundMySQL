package model;

public class Note {
	private String Kursname;
	private int Notenwert;
	private int Versuch;
	private int Semester;

	public Note(String kursname, int notenwert, int versuch, int semester) {
		Kursname = kursname;
		Notenwert = notenwert;
		Versuch = versuch;
		Semester = semester;
	}

	public Note() {
	}

	public String getKursname() {
		return Kursname;
	}

	public void setKursname(String kursname) {
		Kursname = kursname;
	}

	public int getNotenwert() {
		return Notenwert;
	}

	public void setNotenwert(int notenwert) {
		Notenwert = notenwert;
	}

	public int getVersuch() {
		return Versuch;
	}

	public void setVersuch(int versuch) {
		Versuch = versuch;
	}

	public int getSemester() {
		return Semester;
	}

	public void setSemester(int semester) {
		Semester = semester;
	}
}
