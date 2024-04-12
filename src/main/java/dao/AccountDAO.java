package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Account;

public class AccountDAO extends DAO {

	public Account serch(String loginname,String password)
	throws Exception {
		Account account=null;

		Connection con=getConnection();
		
		PreparedStatement st;
		st=con.prepareStatement(
				"select * from account where loginname=? and password=?");
		st.setString(1, loginname);
		st.setString(2, password);
		ResultSet rs=st.executeQuery();
		
		while (rs.next()) {
			account=new Account();
			account.setId(rs.getInt("id"));
			account.setLoginname(rs.getString("loginname"));
			account.setPassword(rs.getString("password"));
			account.setSchool_cd(rs.getString("school_cd"));
		}
		
		st.close();
		con.close();
		return account;
	}
}