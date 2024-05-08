package bean;

public class Class_num implements java.io.Serializable {

	// Beanで使用する変数（フィールド名）を宣言
	private String school_cd;
	private String class_num;

	// データを取得するメソッドを定義
	public String getClass_num() {
		return class_num;
	}
	public String getSchool_cd() {
		return school_cd;
	}

	

	// データを設定するメソッドを定義
	public void setClass_num(String class_num) {
		this.class_num=class_num;
	}
	public void setSchool_cd(String school_cd) {
		this.school_cd=school_cd;
	}
	
}
