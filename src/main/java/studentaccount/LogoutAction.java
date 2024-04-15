package studentaccount;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class LogoutAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {

		HttpSession session=request.getSession();

		if (session.getAttribute("account")!=null) {
			session.removeAttribute("account");
			return "logout-in.jsp";
		}
		
		return "logout-error.jsp";
	}
}
