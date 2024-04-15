package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Student;

public class StudentDAO extends DAO {

	public List<Student> listsearch(int ent_year, String class_num, boolean is_attend, String scd) throws Exception {
		List<Student> student=new ArrayList<>();

		Connection con=getConnection();
		
		if(class_num == "" || ent_year == 0) {
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
			
		} else {
			PreparedStatement st=con.prepareStatement(
				"select * from student where ent_year like ? and class_num like ? and is_attend = ? and school_cd = ?");
			st.setInt(1, ent_year);
			st.setString(2, class_num);
			st.setBoolean(3, is_attend);
			st.setString(4, scd);
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
		
		
	}	
	
	
	public List<Student> changesearch(String class_num) throws Exception {
		List<Student> student=new ArrayList<>();

		Connection con=getConnection();
		
		
		PreparedStatement st=con.prepareStatement(
			"select * from student where class_num like ?");
		st.setString(1, "%"+class_num+"%");
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
}
