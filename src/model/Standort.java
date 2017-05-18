package model;

public class Standort {
	private int stid;
	private String lagebeschreibung;
	private String befestigung;
	private double laenge;
	private double breite;
	private int gemeinde;
	
	public Standort(int stid, String lagebeschreibung, String befestigung, double laenge, double breite, int gemeinde) {
		this.stid = stid;
		this.lagebeschreibung = lagebeschreibung;
		this.befestigung = befestigung;
		this.laenge = laenge;
		this.breite = breite;
		this.gemeinde = gemeinde;
	}
	
	public Standort() {
		this.stid = -1;
		this.lagebeschreibung = null;
		this.befestigung = null;
		this.laenge = -1;
		this.breite = -1;
		this.gemeinde = -1;
	}

	public void reset() {
		this.stid = -1;
		this.lagebeschreibung = null;
		this.befestigung = null;
		this.laenge = -1;
		this.breite = -1;
		this.gemeinde = -1;
	}

	public int getStid() {
		return stid;
	}

	public void setStid(int stid) {
		this.stid = stid;
	}

	public String getLagebeschreibung() {
		return lagebeschreibung;
	}

	public void setLagebeschreibung(String lagebeschreibung) {
		this.lagebeschreibung = lagebeschreibung;
	}

	public String getBefestigung() {
		return befestigung;
	}

	public void setBefestigung(String befestigung) {
		this.befestigung = befestigung;
	}

	public double getLaenge() {
		return laenge;
	}

	public void setLaenge(double laenge) {
		this.laenge = laenge;
	}

	public double getBreite() {
		return breite;
	}

	public void setBreite(double breite) {
		this.breite = breite;
	}

	public int getGemeinde() {
		return gemeinde;
	}

	public void setGemeinde(int gemeinde) {
		this.gemeinde = gemeinde;
	}
	
	@Override
	public String toString() {
		return stid + " - "+lagebeschreibung + ", Befestigung: "+befestigung+ ", Laenge: "+ laenge+", Breite: "+ breite;
	}
	
}
