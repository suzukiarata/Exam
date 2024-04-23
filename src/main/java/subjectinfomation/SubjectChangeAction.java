package subjectinfomation;

import bean.Subject;
import dao.SubjectDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class SubjectChangeAction extends Action{
	public String execute(
		HttpServletRequest request, HttpServletResponse response	
	) throws Exception {
		
		HttpSession session=request.getSession();
		
		String cd=request.getParameter("subject_cd");
		
		
		SubjectDAO dao=new SubjectDAO();
		Subject changesubject=dao.changeserch(cd);
		
		session.setAttribute("changeaction", changesubject);
		
		return "subjectinfomationchange.jsp";
	}
}
