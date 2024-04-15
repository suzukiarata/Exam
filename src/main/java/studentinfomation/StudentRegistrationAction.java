package studentinfomation;

import java.util.List;

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
			
			
			if (ent_year == 0) {
				request.setAttribute("ent_year_none_error", "入学年度を選択してください");
				request.setAttribute("entered_name", name);
				request.setAttribute("entered_no", no);
				request.setAttribute("entered_class_num", class_num);
				return "studentregistration.jsp";
			}
			
			
			Student student=new Student();
			student.setName(name);
			student.setNo(no);
			student.setEnt_year(ent_year);
			student.setClass_num(class_num);
			student.setIs_attend(is_attend);
			student.setSchool_cd(school_cd);
			
			
			StudentDAO dao=new StudentDAO();
			List<Student> s=dao.searchno(no);
			
			if (s.size() != 0) {
				request.setAttribute("no_duplication_error", "学生番号が重複しています");
				return "studentregistration.jsp";
			}
			
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