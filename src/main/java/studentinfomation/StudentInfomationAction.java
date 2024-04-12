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
		
		String num=request.getParameter("f1");
		int ent_year;
		
		if (num==null) {
			ent_year = 0;
		} else {
			ent_year=Integer.parseInt(num); 
		}
		
		String class_num=request.getParameter("f2");
		String authenticity=request.getParameter("f3");
		boolean is_attend = true;
		
		if (authenticity == null) {
			is_attend = false;
		}
		
		StudentDAO dao=new StudentDAO();
		List<Student> list=dao.listsearch(ent_year, class_num, is_attend);
		
		session.setAttribute("list", list);
		
		return "studentinfomation.jsp";
	}
}
