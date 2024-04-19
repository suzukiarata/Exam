package bean;

public class Test implements java.io.Serializable {
	
	private String student_no;
	private String subject_cd;
	private String school_cd;
	private int no;
	private String[] nos;
	private int point;
	private String[] points;
	private String class_num;
	private String name;
	private int ent_year;
	private boolean flag=false;
	private String subject_name;
	
	public String getStudent_no() {
		return student_no;
	}
	public String getSubject_cd() {
		return subject_cd;
	}
	public String getSchool_cd() {
		return school_cd;
	}
	public int getNo() {
		return no;
	}
	public String[] getNos() {
		return nos;
	}
	public int getPoint() {
		return point;
	}
	public String[] getPoints() {
		return points;
	}
	public String getClass_num() {
		return class_num;
	}
	public String getName() {
		return name;
	}
	public int getEnt_year() {
		return ent_year;
	}
	public boolean getFlag() {
		return flag;
	}
	public String getSubject_name() {
		return subject_name;
	}
	
	public void setStudent_no(String student_no) {
		this.student_no=student_no;
	}
	public void setSubject_cd(String subject_cd) {
		this.subject_cd=subject_cd;
	}
	public void setSchool_cd(String school_cd) {
		this.school_cd=school_cd;
	}
	public void setNo(int no) {
		this.no=no;
	}
	public void setNos(String[] nos) {
		this.nos=nos;
	}
	public void setPoint(int point) {
		this.point=point;
	}
	public void setPoints(String[] points) {
		this.points=points;
	}
	public void setClass_num(String class_num) {
		this.class_num=class_num;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setEnt_year(int ent_year) {
		this.ent_year=ent_year;
	}
	public void setFlag(boolean flag) {
		this.flag=flag;
	}
	public void setSubject_name(String subject_name) {
		this.subject_name=subject_name;
	}

}