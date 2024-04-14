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
	
}
