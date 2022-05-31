package sliit.easyrent.model;

public class Vehicle {
	int vid;
	String vplateno;
	String vmodel;
	String vyear;
	String vcostperkm;
	String vcostperday;
	String vtype;
	
	public Vehicle() {
		super();
	}

	public Vehicle(String vplateno, String vmodel, String vyear, String vcostperkm, String vcostperday, String vtype) {
		super();
		this.vplateno = vplateno;
		this.vmodel = vmodel;
		this.vyear = vyear;
		this.vcostperkm = vcostperkm;
		this.vcostperday = vcostperday;
		this.vtype = vtype;
	}

	public Vehicle(int vid, String vplateno, String vmodel, String vyear, String vcostperkm, String vcostperday,
			String vtype) {
		super();
		this.vid = vid;
		this.vplateno = vplateno;
		this.vmodel = vmodel;
		this.vyear = vyear;
		this.vcostperkm = vcostperkm;
		this.vcostperday = vcostperday;
		this.vtype = vtype;
	}

	public int getVid() {
		return vid;
	}

	public void setVid(int vid) {
		this.vid = vid;
	}

	public String getVplateno() {
		return vplateno;
	}

	public void setVplateno(String vplateno) {
		this.vplateno = vplateno;
	}

	public String getVmodel() {
		return vmodel;
	}

	public void setVmodel(String vmodel) {
		this.vmodel = vmodel;
	}

	public String getVyear() {
		return vyear;
	}

	public void setVyear(String vyear) {
		this.vyear = vyear;
	}

	public String getVcostperkm() {
		return vcostperkm;
	}

	public void setVcostperkm(String vcostperkm) {
		this.vcostperkm = vcostperkm;
	}

	public String getVcostperday() {
		return vcostperday;
	}

	public void setVcostperday(String vcostperday) {
		this.vcostperday = vcostperday;
	}

	public String getVtype() {
		return vtype;
	}

	public void setVtype(String vtype) {
		this.vtype = vtype;
	}
	
	
	
	
	
	
}

