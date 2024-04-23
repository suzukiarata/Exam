package studentinfomation;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class Class_numInsertAction extends Action{
	public String execute(
		HttpServletRequest request, HttpServletResponse response	
	) throws Exception {
		
		HttpSession session=request.getSession();
		
		String scd=request.getParameter("scd");
		
		
		
		session.setAttribute("school_cd", scd);
		
		return "class_numinsertexecute.jsp";
	}
}
