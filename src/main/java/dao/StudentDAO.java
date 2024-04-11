package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Student;

public class StudentDAO extends DAO {

	public List<Student> listsearch(int ent_year, String class_num, boolean is_attend) throws Exception {
		List<Student> list=new ArrayList<>();

		Connection con=getConnection();
		
		if(ent_year == 0) {
			PreparedStatement st=con.prepareStatement(
				"select * from student");
			ResultSet rs=st.executeQuery();
			while (rs.next()) {
				Student p=new Student();
				p.setNo(rs.getString("no"));
				p.setName(rs.getString("name"));
				p.setEnt_year(rs.getInt("ent_year"));
				p.setClass_num(rs.getString("class_num"));
				p.setIs_attend(rs.getBoolean("is_attend"));
				p.setSchool_cd(rs.getString("school_cd"));
				list.add(p);
			}
			st.close();
			con.close();

			return list;
			
		} else {
			PreparedStatement st=con.prepareStatement(
				"select * from student where ent_year like ? and class_num like ? and is_attend = ? ");
			st.setInt(1, ent_year);
			st.setString(2, "%" + class_num +"%" );
			st.setBoolean(3, is_attend);
			ResultSet rs=st.executeQuery();
			while (rs.next()) {
				Student p=new Student();
				p.setNo(rs.getString("no"));
				p.setName(rs.getString("name"));
				p.setEnt_year(rs.getInt("ent_year"));
				p.setClass_num(rs.getString("class_num"));
				p.setIs_attend(rs.getBoolean("is_attend"));
				p.setSchool_cd(rs.getString("school_cd"));
				list.add(p);
			}
			st.close();
			con.close();

			return list;
		}
		
		
	}	
	
	
	public List<Student> changesearch(String class_num) throws Exception {
		List<Student> list=new ArrayList<>();

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
			list.add(p);
		}
		st.close();
		con.close();

		return list;
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
}