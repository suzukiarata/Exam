package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.School;

public class SchoolDAO extends DAO {
	public School search(String school_cd)
	throws Exception {
		School school=new School();

		Connection con=getConnection();
		
		PreparedStatement st;
		st=con.prepareStatement(
				"select * from school where cd = ?");
		st.setString(1, school_cd);
		ResultSet rs=st.executeQuery();
		
		while (rs.next()) {
			school.setSchool_cd(rs.getString("cd"));
			school.setName(rs.getString("name"));
		}
		
		st.close();
		con.close();
		return school;
	}
}