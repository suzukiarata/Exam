package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
	
	public int insert(School school) throws Exception {
		Connection con=getConnection();

		PreparedStatement st=con.prepareStatement(
			"insert into school values(?,?)");
		st.setString(1, school.getSchool_cd());
		st.setString(2, school.getName());
		int line=st.executeUpdate();

		st.close();
		con.close();
		return line;
	}
	
	public List<School> searchsch(String cd)
			throws Exception {
					List<School> school=new ArrayList<>();

					Connection con=getConnection();
					
					PreparedStatement st;
					st=con.prepareStatement(
							"select * from school where cd = ?");
					st.setString(1, cd);
					ResultSet rs=st.executeQuery();
					
					while (rs.next()) {
						School s = new School();
						s.setSchool_cd(rs.getString("cd"));
						s.setName(rs.getString("name"));
						school.add(s);
					}
					
					st.close();
					con.close();
					return school;
				}
}