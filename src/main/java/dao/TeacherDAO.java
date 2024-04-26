package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Teacher;

public class TeacherDAO extends DAO {
	
	public int insert(Teacher teacher) throws Exception {
		Connection con=getConnection();

		PreparedStatement st=con.prepareStatement(
			"insert into teacher values(?,?,?,?)");
		st.setString(1, teacher.getId());
		st.setString(2, teacher.getPassword());
		st.setString(3, teacher.getName());
		st.setString(4, teacher.getSchool_cd());
		int line=st.executeUpdate();

		st.close();
		con.close();
		return line;
	}
	
	public List<Teacher> search(String id)
			throws Exception {
				List<Teacher> teacher=new ArrayList<>();

				Connection con=getConnection();
				
				PreparedStatement st;
				st=con.prepareStatement(
						"select * from teacher where id = ?");
				st.setString(1, id);
				ResultSet rs=st.executeQuery();
				
				while (rs.next()) {
					Teacher s = new Teacher();
					s.setSchool_cd(rs.getString("school_cd"));
					s.setId(rs.getString("id"));
					s.setName(rs.getString("name"));
					s.setPassword(rs.getString("password"));
					teacher.add(s);
				}
				
				st.close();
				con.close();
				return teacher;
			}
	
}