package sliit.easyrent.model;

public class Employee {

	int eid;
	String ename;
	String eusername;
	String epassword;
	String ephone;
	String eposition;
	
	public Employee() {
		super();
	}

	public Employee(String ename, String eusername, String epassword, String ephone, String eposition) {
		super();
		this.ename = ename;
		this.eusername = eusername;
		this.epassword = epassword;
		this.ephone = ephone;
		this.eposition = eposition;
	}

	public Employee(int eid, String ename, String eusername, String epassword, String ephone, String eposition) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.eusername = eusername;
		this.epassword = epassword;
		this.ephone = ephone;
		this.eposition = eposition;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEusername() {
		return eusername;
	}

	public void setEusername(String eusername) {
		this.eusername = eusername;
	}

	public String getEpassword() {
		return epassword;
	}

	public void setEpassword(String epassword) {
		this.epassword = epassword;
	}

	public String getEphone() {
		return ephone;
	}

	public void setEphone(String ephone) {
		this.ephone = ephone;
	}

	public String getEposition() {
		return eposition;
	}

	public void setEposition(String eposition) {
		this.eposition = eposition;
	}
	
	
	
	
}
