package subjectinfomation;

import java.util.List;

import bean.Subject;
import dao.SubjectDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class SubjectInfomationDeleteAction  extends Action{
	public String execute(
			HttpServletRequest request, HttpServletResponse response	
		) throws Exception {
			
			HttpSession session=request.getSession();
			
			String subject_cd=request.getParameter("subject_cd");
			
			
			SubjectDAO subjectdao=new SubjectDAO();
			List<Subject> subject=subjectdao.searchcd(subject_cd);


			session.setAttribute("subjectdelete", subject);
			
			return "subjectinfomationdelete.jsp";
		}
}
