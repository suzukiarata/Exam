package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Test;

public class TestDAO extends DAO {

	public List<Test> search(Test score)
	throws Exception {
		List<Test> test=new ArrayList<>();

		Connection con=getConnection();
		PreparedStatement st;
		st=con.prepareStatement(
				"select * from test inner join student on test.student_no = student.no and test.class_num = student.class_num where ent_year = ? and test.class_num = ? and subject_cd = ? and test.no = ?");
		st.setInt(1, score.getEnt_year());
		st.setString(2, score.getClass_num());
		st.setString(3, score.getSubject_cd());
		st.setInt(4, score.getNo());
		ResultSet rs=st.executeQuery();
		
		while (rs.next()) {
			Test t = new Test();
			t.setEnt_year(rs.getInt("ent_year"));
			t.setName(rs.getString("name"));
			t.setStudent_no(rs.getString("student_no"));
			t.setSchool_cd(rs.getString("school_cd"));
			t.setSubject_cd(rs.getString("subject_cd"));
			t.setNo(rs.getInt("no"));
			t.setPoint(rs.getInt("point"));
			t.setClass_num(rs.getString("test.class_num"));
			test.add(t);
		}
		
		st.close();
		con.close();
		return test;
	}

	
	public int registrationpoint(Test test,int point) throws Exception {

		Connection con=getConnection();
		
		
		PreparedStatement st=con.prepareStatement(
			"update test set point = ? where student_no = ? and subject_cd = ? and no = ?");
		st.setInt(1, point);
		st.setString(2, test.getStudent_no());
		st.setString(3, test.getSubject_cd());
		st.setInt(4, test.getNo());
		int line=st.executeUpdate();
		st.close();
		con.close();

		return line;
	}
	
	
}