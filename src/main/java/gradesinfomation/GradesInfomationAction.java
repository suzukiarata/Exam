package gradesinfomation;

import java.util.List;

import bean.Class_num;
import bean.Student;
import bean.Subject;
import dao.Class_numDAO;
import dao.StudentDAO;
import dao.SubjectDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class GradesInfomationAction extends Action{
	public String execute(
		HttpServletRequest request, HttpServletResponse response	
	) throws Exception {
		
		HttpSession session=request.getSession();
		
		
		
		
		String scd=request.getParameter("scd");
		
		
		StudentDAO studentdao=new StudentDAO();
		List<Student> ent=studentdao.searchtestent();
		
		Class_numDAO classdao=new Class_numDAO();
		List<Class_num> classnumber=classdao.search(scd);
		
		SubjectDAO subjectdao=new SubjectDAO();
		List<Subject> subject=subjectdao.search(scd);
		

		session.setAttribute("classnumber", classnumber);
		session.setAttribute("ent", ent);
		session.setAttribute("subject", subject);
		
		return "gradesinfomation.jsp";
	}
}

