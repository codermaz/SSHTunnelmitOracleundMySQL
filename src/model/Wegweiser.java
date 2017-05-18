package model;

public class Wegweiser {
	private int wid;
	private String zustand;
	private String richtung;
	private String fernziel;
	private double kmfern;
	private String nahziel;
	private double kmnah;
	private String pfeilrichtung;
	private String typ;
	private int standort;
	private int route;
	
	public Wegweiser(int wid, String zustand, String richtung, String fernziel, double kmfern, String nahziel,
			double kmnah, String pfeilrichtung, String typ, int standort, int route) {
		this.wid = wid;
		this.zustand = zustand;
		this.richtung = richtung;
		this.fernziel = fernziel;
		this.kmfern = kmfern;
		this.nahziel = nahziel;
		this.kmnah = kmnah;
		this.pfeilrichtung = pfeilrichtung;
		this.typ = typ;
		this.standort = standort;
		this.route = route;
	}

	public Wegweiser() {
		this.wid = -1;
		this.zustand = null;
		this.richtung = null;
		this.fernziel = null;
		this.kmfern = -1;
		this.nahziel = null;
		this.kmnah = -1;
		this.pfeilrichtung = null;
		this.typ = null;
		this.standort = -1;
		this.route = -1;
	}

	public void reset() {
		this.wid = -1;
		this.zustand = null;
		this.richtung = null;
		this.fernziel = null;
		this.kmfern = -1;
		this.nahziel = null;
		this.kmnah = -1;
		this.pfeilrichtung = null;
		this.typ = null;
		this.standort = -1;
		this.route = -1;
	}

	public int getWid() {
		return wid;
	}

	public void setWid(int wid) {
		this.wid = wid;
	}

	public String getZustand() {
		return zustand;
	}

	public void setZustand(String zustand) {
		this.zustand = zustand;
	}

	public String getRichtung() {
		return richtung;
	}

	public void setRichtung(String richtung) {
		this.richtung = richtung;
	}

	public String getFernziel() {
		return fernziel;
	}

	public void setFernziel(String fernziel) {
		this.fernziel = fernziel;
	}

	public double getKmfern() {
		return kmfern;
	}

	public void setKmfern(double kmfern) {
		this.kmfern = kmfern;
	}

	public String getNahziel() {
		return nahziel;
	}

	public void setNahziel(String nahziel) {
		this.nahziel = nahziel;
	}

	public double getKmnah() {
		return kmnah;
	}

	public void setKmnah(double kmnah) {
		this.kmnah = kmnah;
	}

	public String getPfeilrichtung() {
		return pfeilrichtung;
	}

	public void setPfeilrichtung(String pfeilrichtung) {
		this.pfeilrichtung = pfeilrichtung;
	}

	public String getTyp() {
		return typ;
	}

	public void setTyp(String typ) {
		this.typ = typ;
	}

	public int getStandort() {
		return standort;
	}

	public void setStandort(int standort) {
		this.standort = standort;
	}

	public int getRoute() {
		return route;
	}

	public void setRoute(int route) {
		this.route = route;
	}

	@Override
	public String toString() {
		return "id: "+ wid+ " - "+zustand+", "+typ;
	}
	
}
