package teacheraccount;

import java.util.List;

import bean.Teacher;
import dao.TeacherDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class TeacherRegistrationAction extends Action{
	public String execute(
		HttpServletRequest request, HttpServletResponse response	
	) throws Exception {
		
		
		HttpSession session=request.getSession();

		String id=request.getParameter("id");
		String password=request.getParameter("password");
		String name=request.getParameter("name");
		String school_cd=request.getParameter("school_cd");
		
		if (school_cd == "") {
			request.setAttribute("none_select", "学校コードを選択してください");
			return "teacherregistration.jsp";
		}
		
		
		Teacher teacher=new Teacher();
		teacher.setId(id);
		teacher.setPassword(password);
		teacher.setName(name);
		teacher.setSchool_cd(school_cd);
		
		
		TeacherDAO dao=new TeacherDAO();
		
		List<Teacher> s=dao.search(id);
		if (s.size() != 0) {
			request.setAttribute("no_duplication_error", "IDが重複しています");
			return "teacherregistration.jsp";
		}
		
		int line=dao.insert(teacher);
		
		if(line>0) {
			return "teacherregistrationsuccess.jsp";
		}
		

		return "registrationerror.jsp";
	}
}