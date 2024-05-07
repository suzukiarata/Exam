package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Student;
import bean.Test;

public class StudentDAO extends DAO {

	//初回のDAO
	public List<Student> firstsearch(String scd) throws Exception {
		List<Student> student=new ArrayList<>();

		Connection con=getConnection();
		PreparedStatement st=con.prepareStatement(
			"select * from student where school_cd = ?");
		st.setString(1, scd);
		ResultSet rs=st.executeQuery();
		while (rs.next()) {
			Student p=new Student();
			p.setNo(rs.getString("no"));
			p.setName(rs.getString("name"));
			p.setEnt_year(rs.getInt("ent_year"));
			p.setClass_num(rs.getString("class_num"));
			p.setIs_attend(rs.getBoolean("is_attend"));
			p.setSchool_cd(rs.getString("school_cd"));
			student.add(p);
		}
		
		st.close();
		con.close();

		return student;
	}
	
	//入学年度のみ
	public List<Student> yearsearch(int ent_year,String scd) throws Exception {
		List<Student> student=new ArrayList<>();

		Connection con=getConnection();
		PreparedStatement st=con.prepareStatement(
			"select * from student where school_cd = ? and ent_year = ?");
		st.setString(1, scd);
		st.setInt(2, ent_year);
		ResultSet rs=st.executeQuery();
		while (rs.next()) {
			Student p=new Student();
			p.setNo(rs.getString("no"));
			p.setName(rs.getString("name"));
			p.setEnt_year(rs.getInt("ent_year"));
			p.setClass_num(rs.getString("class_num"));
			p.setIs_attend(rs.getBoolean("is_attend"));
			p.setSchool_cd(rs.getString("school_cd"));
			student.add(p);
		}
		
		st.close();
		con.close();

		return student;
	}
	
	//在学中のみ
	public List<Student> attendsearch(boolean is_attend,String scd) throws Exception {
		List<Student> student=new ArrayList<>();

		Connection con=getConnection();
		PreparedStatement st=con.prepareStatement(
			"select * from student where school_cd = ? and is_attend = ?");
		st.setString(1, scd);
		st.setBoolean(2, is_attend);
		ResultSet rs=st.executeQuery();
		while (rs.next()) {
			Student p=new Student();
			p.setNo(rs.getString("no"));
			p.setName(rs.getString("name"));
			p.setEnt_year(rs.getInt("ent_year"));
			p.setClass_num(rs.getString("class_num"));
			p.setIs_attend(rs.getBoolean("is_attend"));
			p.setSchool_cd(rs.getString("school_cd"));
			student.add(p);
		}
		
		st.close();
		con.close();

		return student;
	}
	
	//入学年度とクラス
	public List<Student> yearclasssearch(int ent_year,String class_num,String scd) throws Exception {
		List<Student> student=new ArrayList<>();

		Connection con=getConnection();
		PreparedStatement st=con.prepareStatement(
			"select * from student where school_cd = ? and ent_year = ? and class_num = ?");
		st.setString(1, scd);
		st.setInt(2, ent_year);
		st.setString(3,class_num);
		ResultSet rs=st.executeQuery();
		while (rs.next()) {
			Student p=new Student();
			p.setNo(rs.getString("no"));
			p.setName(rs.getString("name"));
			p.setEnt_year(rs.getInt("ent_year"));
			p.setClass_num(rs.getString("class_num"));
			p.setIs_attend(rs.getBoolean("is_attend"));
			p.setSchool_cd(rs.getString("school_cd"));
			student.add(p);
		}
		
		st.close();
		con.close();

		return student;
	}
	
	//入学年度と在学中
	public List<Student> yearattendsearch(int ent_year,boolean is_attend,String scd) throws Exception {
		List<Student> student=new ArrayList<>();

		Connection con=getConnection();
		PreparedStatement st=con.prepareStatement(
			"select * from student where school_cd = ? and ent_year = ? and is_attend = ?");
		st.setString(1, scd);
		st.setInt(2, ent_year);
		st.setBoolean(3,is_attend);
		ResultSet rs=st.executeQuery();
		while (rs.next()) {
			Student p=new Student();
			p.setNo(rs.getString("no"));
			p.setName(rs.getString("name"));
			p.setEnt_year(rs.getInt("ent_year"));
			p.setClass_num(rs.getString("class_num"));
			p.setIs_attend(rs.getBoolean("is_attend"));
			p.setSchool_cd(rs.getString("school_cd"));
			student.add(p);
		}
		
		st.close();
		con.close();

		return student;
	}
	
	//全部
	public List<Student> allsearch(int ent_year,String class_num,boolean is_attend,String scd) throws Exception {
		List<Student> student=new ArrayList<>();

		Connection con=getConnection();
		PreparedStatement st=con.prepareStatement(
			"select * from student where school_cd = ? and ent_year = ? and class_num = ? and is_attend = ?");
		st.setString(1, scd);
		st.setInt(2, ent_year);
		st.setString(3, class_num);
		st.setBoolean(4,is_attend);
		ResultSet rs=st.executeQuery();
		while (rs.next()) {
			Student p=new Student();
			p.setNo(rs.getString("no"));
			p.setName(rs.getString("name"));
			p.setEnt_year(rs.getInt("ent_year"));
			p.setClass_num(rs.getString("class_num"));
			p.setIs_attend(rs.getBoolean("is_attend"));
			p.setSchool_cd(rs.getString("school_cd"));
			student.add(p);
		}
		
		st.close();
		con.close();

		return student;
	}
	
	
	
	public Student changesearch(String no) throws Exception {
		Student student=null;

		Connection con=getConnection();
		
		
		PreparedStatement st=con.prepareStatement(
			"select * from student where no =  ?");
		st.setString(1, no);
		ResultSet rs=st.executeQuery();
		while (rs.next()) {
			student=new Student();
			student.setNo(rs.getString("no"));
			student.setName(rs.getString("name"));
			student.setEnt_year(rs.getInt("ent_year"));
			student.setClass_num(rs.getString("class_num"));
			student.setIs_attend(rs.getBoolean("is_attend"));
			student.setSchool_cd(rs.getString("school_cd"));
		}
		st.close();
		con.close();

		return student;
	}		
	
		


	public int insert(Student student) throws Exception {
		Connection con=getConnection();

		PreparedStatement st=con.prepareStatement(
			"insert into student values(?, ?, ?, ?, ?, ?)");
		st.setString(1, student.getNo());
		st.setString(2, student.getName());
		st.setInt(3, student.getEnt_year());
		st.setString(4, student.getClass_num());
		st.setBoolean(5, student.getIs_attend());
		st.setString(6, student.getSchool_cd());
		int line=st.executeUpdate();

		st.close();
		con.close();
		return line;
	}
	
	public List<Student> searchno(String no) throws Exception {
		List<Student> student=new ArrayList<>();

		Connection con=getConnection();
		
		
		PreparedStatement st=con.prepareStatement(
			"select no from student where no = ?");
		st.setString(1, no);
		ResultSet rs=st.executeQuery();
		while (rs.next()) {
			Student p=new Student();
			p.setNo(rs.getString("no"));
			student.add(p);
		}
		
		
		st.close();
		con.close();

		return student;
	}
	
	public List<Student> searchent() throws Exception {
		List<Student> student=new ArrayList<>();

		Connection con=getConnection();
		
		
		PreparedStatement st=con.prepareStatement(
			"select distinct ent_year from student order by ent_year asc");
		ResultSet rs=st.executeQuery();
		while (rs.next()) {
			Student p=new Student();
			p.setEnt_year(rs.getInt("ent_year"));
			student.add(p);
		}
		
		
		st.close();
		con.close();

		return student;
	}
	
	public List<Student> searchtestent() throws Exception {
		List<Student> student=new ArrayList<>();

		Connection con=getConnection();
		
		PreparedStatement st=con.prepareStatement(
			"select distinct ent_year from student where ent_year in(select ent_year from test inner join student on test.student_no = student.no) order by ent_year asc");
		ResultSet rs=st.executeQuery();
		while (rs.next()) {
			Student p=new Student();
			p.setEnt_year(rs.getInt("ent_year"));
			student.add(p);
		}
		
		
		st.close();
		con.close();

		return student;
	}
	
	public int changestudent(Student student) throws Exception {

		Connection con=getConnection();
		
		
		PreparedStatement st=con.prepareStatement(
			"update student set no=?,name=?,ent_year=?,class_num=?,is_attend=?,school_cd=? where no=?");
		st.setString(1, student.getNo());
		st.setString(2, student.getName());
		st.setInt(3, student.getEnt_year());
		st.setString(4, student.getClass_num());
		st.setBoolean(5, student.getIs_attend());
		st.setString(6, student.getSchool_cd());
		st.setString(7, student.getNo());
		int line=st.executeUpdate();
		st.close();
		con.close();

		return line;
	}	
	public List<Test> searchtest(int ent_year, String class_num, String subject_cd, int no) throws Exception {
		List<Test> test=new ArrayList<>();

		Connection con=getConnection();
		
		PreparedStatement st=con.prepareStatement(
			"select * from student where ent_year = ? and class_num = ?");
		st.setInt(1, ent_year);
		st.setString(2, class_num);
		ResultSet rs=st.executeQuery();
		while (rs.next()) {
			Test p=new Test();
			p.setEnt_year(ent_year);
			p.setClass_num(class_num);
			p.setSubject_cd(subject_cd);
			p.setStudent_no(rs.getString("no"));
			p.setName(rs.getString("name"));
			p.setNo(no);
			p.setSchool_cd(rs.getString("school_cd"));
			test.add(p);
		}
		
		
		st.close();
		con.close();

		return test;
	}
}
