package sliit.easyrent.model;

public class RentOrder {
	int rid;
	String rcustname;
	String rcustphone;
	String rvehiplateNo;
	String rvehimodel;
	String rdrivername;
	String rdriverphone;
	int rdays;
	int rkilometers;
	float rtotal;
	
	public RentOrder() {
		super();
	}

	public RentOrder(String rcustname, String rcustphone, String rvehiplateNo, String rvehimodel, String rdrivername,
			String rdriverphone, int rdays, int rkilometers, float rtotal) {
		super();
		this.rcustname = rcustname;
		this.rcustphone = rcustphone;
		this.rvehiplateNo = rvehiplateNo;
		this.rvehimodel = rvehimodel;
		this.rdrivername = rdrivername;
		this.rdriverphone = rdriverphone;
		this.rdays = rdays;
		this.rkilometers = rkilometers;
		this.rtotal = rtotal;
	}

	public RentOrder(int rid, String rcustname, String rcustphone, String rvehiplateNo, String rvehimodel,
			String rdrivername, String rdriverphone, int rdays, int rkilometers, float rtotal) {
		super();
		this.rid = rid;
		this.rcustname = rcustname;
		this.rcustphone = rcustphone;
		this.rvehiplateNo = rvehiplateNo;
		this.rvehimodel = rvehimodel;
		this.rdrivername = rdrivername;
		this.rdriverphone = rdriverphone;
		this.rdays = rdays;
		this.rkilometers = rkilometers;
		this.rtotal = rtotal;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getRcustname() {
		return rcustname;
	}

	public void setRcustname(String rcustname) {
		this.rcustname = rcustname;
	}

	public String getRcustphone() {
		return rcustphone;
	}

	public void setRcustphone(String rcustphone) {
		this.rcustphone = rcustphone;
	}

	public String getRvehiplateNo() {
		return rvehiplateNo;
	}

	public void setRvehiplateNo(String rvehiplateNo) {
		this.rvehiplateNo = rvehiplateNo;
	}

	public String getRvehimodel() {
		return rvehimodel;
	}

	public void setRvehimodel(String rvehimodel) {
		this.rvehimodel = rvehimodel;
	}

	public String getRdrivername() {
		return rdrivername;
	}

	public void setRdrivername(String rdrivername) {
		this.rdrivername = rdrivername;
	}

	public String getRdriverphone() {
		return rdriverphone;
	}

	public void setRdriverphone(String rdriverphone) {
		this.rdriverphone = rdriverphone;
	}

	public int getRdays() {
		return rdays;
	}

	public void setRdays(int rdays) {
		this.rdays = rdays;
	}

	public int getRkilometers() {
		return rkilometers;
	}

	public void setRkilometers(int rkilometers) {
		this.rkilometers = rkilometers;
	}

	public float getRtotal() {
		return rtotal;
	}

	public void setRtotal(float rtotal) {
		this.rtotal = rtotal;
	}
	
	
	
}
