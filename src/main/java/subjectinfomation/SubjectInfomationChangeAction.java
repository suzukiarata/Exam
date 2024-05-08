package subjectinfomation;

import bean.Subject;
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
		Subject changesubject=subjectdao.changeserch(cd);
		int line=subjectdao.update(cd,name);
		
		if(changesubject == null) {
			request.setAttribute("no_subject_text", "科目が存在していません");
			return "subjectinfomationchange.jsp";
		}
		
		if(line>0) {
			return "subjectinfomationchangesuccess.jsp";
		}


		request.setAttribute("error_text", "科目変更機能");
		return "../home/Error.action";
	}
}