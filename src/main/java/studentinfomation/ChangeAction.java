package studentinfomation;

import bean.Student;
import dao.StudentDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class ChangeAction extends Action{
	public String execute(
		HttpServletRequest request, HttpServletResponse response	
	) throws Exception {
		
		HttpSession session=request.getSession();
		
		String no=request.getParameter("no");
		
		
		StudentDAO dao=new StudentDAO();
		Student changestudent=dao.changesearch(no);
		
		session.setAttribute("changelist", changestudent);
		
		return "studentinfomationchange.jsp";
	}
}
