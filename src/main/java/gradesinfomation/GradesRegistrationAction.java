package gradesinfomation;

import java.util.List;

import bean.Test;
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
		
		int ent_year=Integer.parseInt(request.getParameter("ent_year")); 
		String class_num=request.getParameter("class_num");
		String subject_cd=request.getParameter("subject_cd");
		int no=Integer.parseInt(request.getParameter("no")); 
		
		int line=0;
		
		Test test=new Test();
		test.setEnt_year(ent_year);
		test.setClass_num(class_num);
		test.setSubject_cd(subject_cd);
		test.setNo(no);
		
		TestDAO testdao=new TestDAO();
		List<Test> t=testdao.search(test);
		
		for(Test i:t) {
			int point=Integer.parseInt(request.getParameter("int_" + i.getStudent_no())); 
			line=testdao.registrationpoint(i, point);
		}
		
		if (line>0) {
			return "gradesinfomationexecutesuccess.jsp";
		}
		
		return "gradesinfomationexecuteerror.jsp";
	}
}