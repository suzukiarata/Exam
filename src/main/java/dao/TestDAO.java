package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Test;

public class TestDAO extends DAO {

	public List<Test> search(int ent_year, String class_num, String subject_cd, int no)
	throws Exception {
		List<Test> test=new ArrayList<>();

		Connection con=getConnection();
		PreparedStatement st;
		st=con.prepareStatement(
				"select * from student left outer join test on student.no =  test.student_no where student.ent_year = ? and student.class_num = ?");
		st.setInt(1, ent_year);
		st.setString(2, class_num);
		ResultSet rs=st.executeQuery();
		
		while (rs.next()) {
			Test t = new Test();
			t.setSubject_cd(rs.getString("subject_cd"));
			if (t.getSubject_cd() == null) {
				t.setEnt_year(rs.getInt("ent_year"));
				t.setName(rs.getString("student.name"));
				t.setStudent_no(rs.getString("student.no"));
				t.setSchool_cd(rs.getString("school_cd"));
				t.setSubject_cd(subject_cd);
				t.setNo(no);
				t.setClass_num(rs.getString("class_num"));
				test.add(t);
			} else {
				t.setNo(rs.getInt("test.no"));
				
				if (t.getNo() == no) {
						t.setEnt_year(rs.getInt("ent_year"));
						t.setName(rs.getString("student.name"));
						t.setStudent_no(rs.getString("student_no"));
						t.setSchool_cd(rs.getString("school_cd"));
						t.setPoint(rs.getInt("point"));
						t.setClass_num(rs.getString("class_num"));
						test.add(t);
				}
			}
		}
		
		st.close();
		con.close();
		return test;
	}
	
	
	public int registrationpoint(Test test,int point) throws Exception {

		Connection con=getConnection();
		
		if (test.getPoint() != 0) {
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
		} else {
			PreparedStatement st=con.prepareStatement(
					"insert into test values(?,?,?,?,?,?)");
				st.setString(1, test.getStudent_no());
				st.setString(2, test.getSubject_cd());
				st.setString(3, test.getSchool_cd());
				st.setInt(4, test.getNo());
				st.setInt(5, point);
				st.setString(6, test.getClass_num());
				int line=st.executeUpdate();
				st.close();
				con.close();
				return line;
		}
	}
}