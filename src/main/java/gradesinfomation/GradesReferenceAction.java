package gradesinfomation;

import java.util.Calendar;
import java.util.List;

import bean.Class_num;
import bean.Student;
import dao.Class_numDAO;
import dao.StudentDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class GradesReferenceAction extends Action{
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
		
		String scd=request.getParameter("scd");
		
		StudentDAO studentdao=new StudentDAO();
		List<Student> student=studentdao.listsearch(ent_year, class_num, is_attend, scd);
		List<Student> ent=studentdao.searchent();
		
		Class_numDAO classdao=new Class_numDAO();
		List<Class_num> classnumber=classdao.search(scd);
		
		Calendar calendar = Calendar.getInstance();
	    int year = calendar.get(Calendar.YEAR);
		
		session.setAttribute("student", student);
		session.setAttribute("ent", ent);
		session.setAttribute("classnumber", classnumber);
		session.setAttribute("year", year);
		
		return "studentinfomation.jsp";
	}
}
