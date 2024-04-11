package studentinfomation;

import java.util.List;

import bean.Student;
import dao.StudentDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class StudentInfomationAction extends Action{
	public String execute(
		HttpServletRequest request, HttpServletResponse response	
	) throws Exception {
		
		HttpSession session=request.getSession();
		
		int ent_year=Integer.parseInt(request.getParameter("f1")); 
		String class_num=request.getParameter("f2");
		boolean is_attend = true;
		
		
		
		
		StudentDAO dao=new StudentDAO();
		List<Student> list=dao.listsearch(ent_year, class_num,is_attend);
		
		session.setAttribute("list", list);
		
		return "studentinfomation.jsp";
	}
}
