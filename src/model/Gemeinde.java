package model;

//import java.util.ArrayList;

public class Gemeinde {
	private int gid;
	private String plz;
	private String gname;

	public Gemeinde(int gId, String plz, String gName) {
		this.gid = gId;
		this.plz = plz;
		this.gname = gName;
	}

	//create empty "Gemeinde" template
	public Gemeinde() {
		this.gid = -1;
		this.plz = null;
		this.gname = null;
	}
	
	public void reset () {
		this.gid = -1;
		this.plz = null;
		this.gname = null;
	}
	
	public int getgId() {
		return gid;
	}

	public void setgId(int gId) {
		this.gid = gId;
	}

	public String getPlz() {
		return plz;
	}

	public void setPlz(String plz) {
		this.plz = plz;
	}

	public String getgName() {
		return gname;
	}

	public void setgName(String gName) {
		this.gname = gName;
	}

	@Override
	public String toString() {
		return getgName();
	}
}
