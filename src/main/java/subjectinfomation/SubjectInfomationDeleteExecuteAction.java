package subjectinfomation;

import dao.SubjectDAO;
import dao.TestDAO;
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

			TestDAO testdao=new TestDAO();
			line=testdao.delete(cd);
			
			return "subjectdeletesuccess.jsp";
		}
}
