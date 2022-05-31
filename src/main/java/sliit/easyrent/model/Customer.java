package sliit.easyrent.model;

public class Customer {
	int cid;
	String cname;
	String cnic;
	String cphone;
	String caddress;
	
	
	public Customer() {
		super();
	}


	public Customer(String cname, String cnic, String cphone, String caddress) {
		super();
		this.cname = cname;
		this.cnic = cnic;
		this.cphone = cphone;
		this.caddress = caddress;
	}
	
	
	public Customer(int cid, String cname, String cnic, String cphone, String caddress) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.cnic = cnic;
		this.cphone = cphone;
		this.caddress = caddress;
	}


	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCnic() {
		return cnic;
	}
	public void setCnic(String cnic) {
		this.cnic = cnic;
	}
	public String getCphone() {
		return cphone;
	}
	public void setCphone(String cphone) {
		this.cphone = cphone;
	}
	public String getCaddress() {
		return caddress;
	}
	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}
	
}

