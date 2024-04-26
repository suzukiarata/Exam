package schoolinfomation;

import java.util.List;

import bean.School;
import dao.SchoolDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class SchoolRegistrationAction extends Action{
	public String execute(
		HttpServletRequest request, HttpServletResponse response	
	) throws Exception {
		
		
		HttpSession session=request.getSession();

		String name=request.getParameter("name");
		String cd=request.getParameter("cd");
		
		
		School school=new School();
		school.setSchool_cd(cd);
		school.setName(name);

		
		
		SchoolDAO dao=new SchoolDAO();

		List<School> s=dao.searchsch(cd);
		if (s.size() != 0) {
			request.setAttribute("no_duplication_error", "学校コードが重複しています");
			return "schoolregistration.jsp";
		}
		
		int line=dao.insert(school);
		
		if(line>0) {
			return "schoolregistrationsuccess.jsp";
		}
		

		return "registrationerror.jsp";
	}
}