package bean;

public class Teacher implements java.io.Serializable {

	// Beanで使用する変数（フィールド名）を宣言
	private String id;
	private String password;
	private String name;
	private String school_cd;
	
	

	// データを取得するメソッドを定義
	public String getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}
	public String getName() {
		return name;
	}
	public String getSchool_cd() {
		return school_cd;
	
	}
	// データを設定するメソッドを定義
	public void setId(String id) {
		this.id=id;
	}
	public void setPassword(String password) {
		this.password=password;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setSchool_cd(String school_cd) {
		this.school_cd=school_cd;
	}
}