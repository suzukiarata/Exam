package subjectinfomation;

import java.util.List;

import bean.Subject;
import dao.SubjectDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class SubjectRegistrationAction extends Action{
	public String execute(
		HttpServletRequest request, HttpServletResponse response	
	) throws Exception {
		
		
		HttpSession session=request.getSession();
		
		try {
			String school_cd=request.getParameter("school_cd");
			String cd=request.getParameter("cd");
			String name=request.getParameter("name");
			
			if(cd.length() !=3) {
				request.setAttribute("length_error", "科目コードは3文字で入力してください");
				request.setAttribute("entered_cd", cd);
				request.setAttribute("entered_name", name);
				return "subjectregistration.jsp";
			}
			
			SubjectDAO dao=new SubjectDAO();
			List<Subject>s=dao.searchcd(cd);
			if (s.size() != 0) {
				request.setAttribute("no_duplication_error", "科目コードが重複しています");
				request.setAttribute("entered_cd", cd);
				request.setAttribute("entered_name", name);
				return "subjectregistration.jsp";
			}
			
			Subject subject=new Subject();
			subject.setSchool_cd(school_cd);
			subject.setCd(cd);
			subject.setName(name);
			
			
			int line=dao.insert(subject);
			
			if(line>0) {
				return "subjectregistrationsuccess.jsp";
			}
			
			
		}catch (Exception e) {
			return "registrationerror.jsp";
		}
		return "registrationerror.jsp";
	}
}
