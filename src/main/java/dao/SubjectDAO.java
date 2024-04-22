package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Subject;

public class SubjectDAO extends DAO {

	public List<Subject> search(String school_cd)
	throws Exception {
		List<Subject> subject=new ArrayList<>();

		Connection con=getConnection();
		
		PreparedStatement st;
		st=con.prepareStatement(
				"select * from subject where school_cd = ?");
		st.setString(1, school_cd);
		ResultSet rs=st.executeQuery();
		
		while (rs.next()) {
			Subject s = new Subject();
			s.setSchool_cd(rs.getString("school_cd"));
			s.setCd(rs.getString("cd"));
			s.setName(rs.getString("name"));
			subject.add(s);
		}
		
		st.close();
		con.close();
		return subject;
	}
	
	public int insert(Subject subject) throws Exception {
		Connection con=getConnection();

		PreparedStatement st=con.prepareStatement(
			"insert into subject values(?, ?, ?)");
		st.setString(1, subject.getSchool_cd());
		st.setString(2, subject.getCd());
		st.setString(3, subject.getName());
		int line=st.executeUpdate();

		st.close();
		con.close();
		return line;
	}
	public List<Subject> searchcd(String cd)
			throws Exception {
				List<Subject> subject=new ArrayList<>();

				Connection con=getConnection();
				
				PreparedStatement st;
				st=con.prepareStatement(
						"select * from subject where cd = ?");
				st.setString(1, cd);
				ResultSet rs=st.executeQuery();
				
				while (rs.next()) {
					Subject s = new Subject();
					s.setSchool_cd(rs.getString("school_cd"));
					s.setCd(rs.getString("cd"));
					s.setName(rs.getString("name"));
					subject.add(s);
				}
				
				st.close();
				con.close();
				return subject;
	}
	
	public int delete(String cd) throws Exception {
		Connection con=getConnection();

		PreparedStatement st=con.prepareStatement(
			"delete from subject where cd=?");
		st.setString(1, cd);
		int line=st.executeUpdate();

		st.close();
		con.close();
		return line;
	}
	
}