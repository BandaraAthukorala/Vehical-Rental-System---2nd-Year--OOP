package sliit.easyrent.model;

public class Driver {
	int did;
	String dname;
	String dnic;
	String dphone;
	String daddress;
	
	public Driver() {
		super();
	}
	
	public Driver(String dname, String dnic, String dphone, String daddress) {
		super();
		this.dname = dname;
		this.dnic = dnic;
		this.dphone = dphone;
		this.daddress = daddress;
	}
	
	public Driver(int did, String dname, String dnic, String dphone, String daddress) {
		super();
		this.did = did;
		this.dname = dname;
		this.dnic = dnic;
		this.dphone = dphone;
		this.daddress = daddress;
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getDnic() {
		return dnic;
	}

	public void setDnic(String dnic) {
		this.dnic = dnic;
	}

	public String getDphone() {
		return dphone;
	}

	public void setDphone(String dphone) {
		this.dphone = dphone;
	}

	public String getDaddress() {
		return daddress;
	}

	public void setDaddress(String daddress) {
		this.daddress = daddress;
	}
	
	
	
}
