package subjectinfomation;

import dao.SubjectDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class SubjectInfomationChangeAction extends Action{
	public String execute(
		HttpServletRequest request, HttpServletResponse response	
	) throws Exception {
		
		HttpSession session=request.getSession();
		
		String cd=request.getParameter("cd");
		String name=request.getParameter("name");
		
		SubjectDAO subjectdao=new SubjectDAO();
		int line=subjectdao.update(cd,name);
		
		if(line>0) {
			return "subjectinfomationchangesuccess.jsp";
		}


		
		return "subjectinfomationchange.jsp";
	}
}