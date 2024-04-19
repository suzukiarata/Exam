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
				"select * from student right outer join test on student.no = test.student_no right join subject on test.subject_cd = subject_cd where student.ent_year = ? and student.class_num = ? and cd = ? and test.no = ?");
		st.setInt(1, ent_year);
		st.setString(2, class_num);
		st.setString(3, subject_cd);
		st.setInt(4, no);
		ResultSet rs=st.executeQuery();
		
		while (rs.next()) {
			Test t = new Test();
			t.setSubject_cd(rs.getString("subject_cd"));
			t.setEnt_year(rs.getInt("ent_year"));
			t.setName(rs.getString("student.name"));
			t.setStudent_no(rs.getString("student.no"));
			t.setSchool_cd(rs.getString("student.school_cd"));
			t.setClass_num(rs.getString("student.class_num"));
			t.setPoint(rs.getInt("point"));
			t.setNo(rs.getInt("test.no"));
			if (t.getSubject_cd() == rs.getString("cd")) {
				t.setFlag(true);
				test.add(t);
			}
		}
		st.close();
		con.close();
		return test;
	}
	
	
	public int registrationpoint(Test test,int point) throws Exception {

		Connection con=getConnection();
		
		if (test.getFlag() == true) {
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
	
	public List<Test> subjectsearch(int ent_year, String class_num, String subject_cd)
			throws Exception {
				List<Test> test=new ArrayList<>();

				Connection con=getConnection();
				PreparedStatement st;
				st=con.prepareStatement(
						"select s.no,s.name,s.ent_year,s.class_num,s.school_cd,t.subject_cd,string_agg(t.no,',')as nos,string_agg(point,',')as points from student s inner join test t on s.no =  t.student_no "
						+ "where s.ent_year = ? and s.class_num = ? and t.subject_cd = ? group by s.no,t.subject_cd");
				st.setInt(1, ent_year);
				st.setString(2, class_num);
				st.setString(3, subject_cd);
				ResultSet rs=st.executeQuery();
				
				while (rs.next()) {
					Test t = new Test();
					t.setEnt_year(rs.getInt("ent_year"));
					t.setName(rs.getString("student.name"));
					t.setStudent_no(rs.getString("student.no"));
					t.setSchool_cd(rs.getString("school_cd"));
					t.setSubject_cd(rs.getString("subject_cd"));
					t.setNos(rs.getString("nos").split(","));
					t.setClass_num(rs.getString("class_num"));
					t.setPoints(rs.getString("points").split(","));
					test.add(t);	
				}
				st.close();
				con.close();
				return test;
	}
	public List<Test> studentsearch(String student_cd)
			throws Exception {
				List<Test> test=new ArrayList<>();

				Connection con=getConnection();
				PreparedStatement st;
				st=con.prepareStatement(
						"select s.no,s.name,s.ent_year,s.class_num,s.school_cd,t.subject_cd,sub.name,t.no,t.point from student s inner join test t on s.no =  t.student_no inner join subject sub on t.subject_cd = sub.cd where s.no = ?");
				st.setString(1, student_cd);
				ResultSet rs=st.executeQuery();
				
				while (rs.next()) {
					Test t = new Test();
					t.setEnt_year(rs.getInt("ent_year"));
					t.setName(rs.getString("student.name"));
					t.setStudent_no(rs.getString("student.no"));
					t.setSchool_cd(rs.getString("school_cd"));
					t.setSubject_cd(rs.getString("subject_cd"));
					t.setNo(rs.getInt("no"));
					t.setSubject_name(rs.getString("subject.name"));
					t.setClass_num(rs.getString("class_num"));
					t.setPoint(rs.getInt("point"));
					test.add(t);
				}
				st.close();
				con.close();
				return test;
			}
}