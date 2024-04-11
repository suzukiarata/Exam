package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Student;

public class StudentDAO extends DAO {

	public List<Student> search(String keyword) throws Exception {
		List<Student> list=new ArrayList<>();

		Connection con=getConnection();

		PreparedStatement st=con.prepareStatement(
			"select * from student where name like ?");
		st.setString(1, "%"+keyword+"%");
		ResultSet rs=st.executeQuery();

		while (rs.next()) {
			Student p=new Student();
			p.setNo(rs.getString("no"));
			p.setName(rs.getString("name"));
			p.setEnt_Year(rs.getInt("ent_year"));
			p.setClass_Num(rs.getString("class_num"));
			p.setIs_Attend(rs.getBoolean("is_attend"));
			p.setSchool_Cd(rs.getString("school_cd"));
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
		st.setInt(3, student.getEnt_Year());
		st.setString(4, student.getClass_Num());
		st.setBoolean(5, student.getIs_Attend());
		st.setString(6, student.getSchool_Cd());
		int line=st.executeUpdate();

		st.close();
		con.close();
		return line;
	}
}