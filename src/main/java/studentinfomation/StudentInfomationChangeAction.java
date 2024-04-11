package studentinfomation;

import java.util.List;

import bean.Student;
import dao.StudentDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class StudentInfomationChangeAction extends Action{
	public String execute(
		HttpServletRequest request, HttpServletResponse response	
	) throws Exception {
		
		HttpSession session=request.getSession();
		
		String no=request.getParameter("no");
		
		
		StudentDAO dao=new StudentDAO();
		List<Student> list=dao.changesearch(no);
		
		session.setAttribute("list", list);
		
		return "studentinfomationchange.jsp";
	}
}
