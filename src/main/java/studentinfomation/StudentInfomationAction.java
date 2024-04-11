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
		
		String class_num=request.getParameter("class_num");
		if (class_num==null) {
			class_num="";
		}
		
		StudentDAO dao=new StudentDAO();
		List<Student> list=dao.search(class_num);
		
		session.setAttribute("list", list);
		
		return "studentinfomation.jsp";
	}
}
