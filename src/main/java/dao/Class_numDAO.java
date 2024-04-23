package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Class_num;

public class Class_numDAO extends DAO {

	public List<Class_num> search(String scd) throws Exception {
		List<Class_num> class_num=new ArrayList<>();

		Connection con=getConnection();
		
		
		PreparedStatement st=con.prepareStatement(
			"select * from class_num where school_cd = ?");
		st.setString(1, scd);
		ResultSet rs=st.executeQuery();
		while (rs.next()) {
			Class_num p=new Class_num();
			p.setSchool_cd(rs.getString("school_cd"));
			p.setClass_num(rs.getString("class_num"));
			class_num.add(p);
		}
		
		st.close();
		con.close();

		return class_num;
		
	}
	
	public List<Class_num> searchclass_num(String c_num) throws Exception {
		List<Class_num> class_num=new ArrayList<>();

		Connection con=getConnection();
		
		
		PreparedStatement st=con.prepareStatement(
			"select * from class_num where class_num = ?");
		st.setString(1, c_num);
		ResultSet rs=st.executeQuery();
		while (rs.next()) {
			Class_num c = new Class_num();
			c.setSchool_cd(rs.getString("school_cd"));
			c.setClass_num(rs.getString("class_num"));
			class_num.add(c);
		}
		
		st.close();
		con.close();

		return class_num;
		
	}
	
	public int insert(String school_cd,String class_num) throws Exception {
		Connection con=getConnection();

		PreparedStatement st=con.prepareStatement(
			"insert into class_num values(?, ?)");
		st.setString(1, school_cd);
		st.setString(2, class_num);
		int line=st.executeUpdate();

		st.close();
		con.close();
		return line;
	}
}