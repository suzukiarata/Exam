package subjectinfomation;

import dao.SubjectDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class SubjectInfomationDeleteExecuteAction extends Action{
	public String execute(
			HttpServletRequest request, HttpServletResponse response	
		) throws Exception {
			
			HttpSession session=request.getSession();
			
			String cd=request.getParameter("subject_cd");
			
			
			SubjectDAO subjectdao=new SubjectDAO();
			int line=subjectdao.delete(cd);

			if(line>0) {
				return "subjectdeletesuccess.jsp";
			}
			
			return "subjectdeletesuccess.jsp";
		}
}
