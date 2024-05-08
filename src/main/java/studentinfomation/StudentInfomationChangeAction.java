package studentinfomation;

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
		String name=request.getParameter("name");
		int ent_year=Integer.parseInt(request.getParameter("ent_year"));
		String class_num=request.getParameter("class_num");
		String authenticity=request.getParameter("is_attend");
		boolean is_attend = true;
		
		if (authenticity == null) {
			is_attend = false;
		}
		
		String school_cd=request.getParameter("school_cd");
		
		Student student=new Student();
		student.setNo(no);
		student.setName(name);
		student.setEnt_year(ent_year);
		student.setClass_num(class_num);
		student.setIs_attend(is_attend);
		student.setSchool_cd(school_cd);
		
		StudentDAO studentdao=new StudentDAO();
		int line=studentdao.changestudent(student);
		
		if (line>0) {
			return "studentinfomationchangesuccess.jsp";
		}
		request.setAttribute("error_text", "学生変更機能");
		return "../home/Error.action";
	}
}