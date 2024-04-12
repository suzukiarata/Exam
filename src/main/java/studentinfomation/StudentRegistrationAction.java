package studentinfomation;

import bean.Student;
import dao.StudentDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class StudentRegistrationAction extends Action{
	public String execute(
		HttpServletRequest request, HttpServletResponse response	
	) throws Exception {
		
		
		HttpSession session=request.getSession();
		
		try {
			String name=request.getParameter("name");
			String no=request.getParameter("no");
			int ent_year=Integer.parseInt(request.getParameter("ent_year"));		
			String class_num=request.getParameter("class_num");
			boolean is_attend = true;
			String school_cd=request.getParameter("school_cd");
			
			Student student=new Student();
			student.setName(name);
			student.setNo(no);
			student.setEnt_year(ent_year);
			student.setClass_num(class_num);
			student.setIs_attend(is_attend);
			student.setSchool_cd(school_cd);
			
			
			StudentDAO dao=new StudentDAO();
			int line=dao.insert(student);
			
			if (line>0) {
				return "studentregistrationsuccess.jsp";
			}
			
		} catch (Exception e) {
			return "registrationerror.jsp";
		}
		
		return "registrationerror.jsp";
		
	}	
}