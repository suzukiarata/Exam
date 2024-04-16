package gradesinfomation;

import java.util.List;

import bean.Class_num;
import bean.Student;
import bean.Subject;
import bean.Test;
import dao.Class_numDAO;
import dao.StudentDAO;
import dao.SubjectDAO;
import dao.TestDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class GradesRegistrationAction extends Action{
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
		String subject_cd=request.getParameter("f3");
		
		num=request.getParameter("f4");
		int no;
		if (num==null) {
			no = 0;
		} else {
			no=Integer.parseInt(num); 
		}
		
		
		String scd=request.getParameter("scd");
		
		Test test=new Test();
		test.setEnt_year(ent_year);
		test.setClass_num(class_num);
		test.setSubject_cd(subject_cd);
		test.setNo(no);
		
		TestDAO testdao=new TestDAO();
		List<Test> t=testdao.search(test);
		
		StudentDAO studentdao=new StudentDAO();
		List<Student> ent=studentdao.searchtestent();
		
		Class_numDAO classdao=new Class_numDAO();
		List<Class_num> classnumber=classdao.search(scd);
		
		SubjectDAO subjectdao=new SubjectDAO();
		List<Subject> subject=subjectdao.search(scd);
		

		session.setAttribute("classnumber", classnumber);
		session.setAttribute("ent", ent);
		session.setAttribute("subject", subject);
		session.setAttribute("test", t);
		
		return "gradesregistration.jsp";
	}
}

