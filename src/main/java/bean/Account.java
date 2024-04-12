package bean;

public class Account implements java.io.Serializable {
	
	private int id;
	private String loginname;
	private String password;
	private String school_cd;
	
	public int getId() {
		return id;
	}
	public String getLoginname() {
		return loginname;
	}
	public String getPassword() {
		return password;
	}
	public String getSchool_cd() {
		return school_cd;
	}
	public void setId(int id) {
		this.id=id;
	}
	public void setLoginname(String loginname) {
		this.loginname=loginname;
	}
	public void setPassword(String password) {
		this.password=password;
	}
	public void setSchool_cd(String school_cd) {
		this.school_cd=school_cd;
	}
}