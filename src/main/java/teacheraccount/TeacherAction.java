package teacheraccount;

import java.util.List;

import bean.School;
import dao.SchoolDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class TeacherAction extends Action{
	public String execute(
		HttpServletRequest request, HttpServletResponse response	
	) throws Exception {
		
		
		HttpSession session=request.getSession();
		
		SchoolDAO dao=new SchoolDAO();
		List<School> school = dao.schoollist();
		
		
		session.setAttribute("schoollist",school);
		
		return "teacherregistration.jsp";
	}
}