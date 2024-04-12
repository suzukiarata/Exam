package studentaccount;

import bean.Account;
import dao.AccountDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class LoginAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {

		HttpSession session=request.getSession();

		String id=request.getParameter("id");
		String password=request.getParameter("password");

		AccountDAO dao=new AccountDAO();
		Account account=dao.search(id, password);
		
		if (account!=null) {
			session.setAttribute("account", account);
			return "../home/Home.action";
		}
		
		return "login-error.jsp";
	}
}