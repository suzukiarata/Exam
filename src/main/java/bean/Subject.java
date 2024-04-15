package bean;

public class Subject implements java.io.Serializable {

	// Beanで使用する変数（フィールド名）を宣言
	private String school_cd;
	private String cd;
	private String name;
	

	// データを取得するメソッドを定義
	public String getSchool_cd() {
		return school_cd;
	}
	public String getCd() {
		return cd;
	}
	public String getName() {
		return name;
	}
	
	// データを設定するメソッドを定義
	public void setSchool_cd(String school_cd) {
		this.school_cd=school_cd;
	}
	public void setCd(String cd) {
		this.cd=cd;
	}
	public void setName(String name) {
		this.name=name;
	}
}