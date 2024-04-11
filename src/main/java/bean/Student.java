package bean;

public class Student implements java.io.Serializable {

	// Beanで使用する変数（フィールド名）を宣言
	private String no;
	private String name;
	private int ent_year;
	private String class_num;
	private boolean is_attend;
	private String school_cd;

	// データを取得するメソッドを定義
	public String getNo() {
		return no;
	}
	public String getName() {
		return name;
	}
	public int getEnt_Year() {
		return ent_year;
	}
	public String getClass_Num() {
		return class_num;
	}
	public boolean getIs_Attend() {
		return is_attend;
	}
	public String getSchool_Cd() {
		return school_cd;
	}
	

	// データを設定するメソッドを定義
	public void setNo(String no) {
		this.no=no;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setEnt_Year(int ent_year) {
		this.ent_year=ent_year;
	}
	public void setClass_Num(String class_num) {
		this.class_num=class_num;
	}
	public void setIs_Attend(boolean is_attend) {
		this.is_attend=is_attend;
	}
	public void setSchool_Cd(String school_cd) {
		this.school_cd=school_cd;
	}
	
	
}
