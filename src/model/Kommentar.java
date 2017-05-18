package model;

import java.sql.Date;

public class Kommentar {
	private int kid;
	private String autor;
	private Date datum;
	private String text;
	private int standort;

	public Kommentar(int kId, String autor, Date datum, String text, int standort) {
		this.kid = kId;
		this.autor = autor;
		this.datum = datum;
		this.text = text;
		this.standort = standort;
	}
	// leere Konstruktor
	public Kommentar() {
		this.kid = -1;
		this.autor = null;
		this.datum = null;
		this.text = null;
		this.standort = -1;
	}
	
	public void reset() {
		this.kid = -1;
		this.autor = null;
		this.datum = null;
		this.text = null;
		this.standort = -1;	
	}
	public int getkId() {
		return kid;
	}
	public void setkId(int kId) {
		this.kid = kId;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public Date getDatum() {
		return datum;
	}
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getStandort() {
		return standort;
	}
	public void setStandort(int standort) {
		this.standort = standort;
	}
	
	@Override
	public String toString() {
		return autor+": "+ text + ", " + datum.toString();
	}
	


}
