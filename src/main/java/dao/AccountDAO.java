package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Account;

public class AccountDAO extends DAO {

	public Account search(String id,String password)
	throws Exception {
		Account account=null;

		Connection con=getConnection();
		
		PreparedStatement st;
		st=con.prepareStatement(
				"select * from teacher where id=? and password=?");
		st.setString(1, id);
		st.setString(2, password);
		ResultSet rs=st.executeQuery();
		
		while (rs.next()) {
			account=new Account();
			account.setId(rs.getString("id"));
			account.setPassword(rs.getString("password"));
			account.setLoginname(rs.getString("name"));
			account.setSchool_cd(rs.getString("school_cd"));
		}
		
		st.close();
		con.close();
		return account;
	}
}