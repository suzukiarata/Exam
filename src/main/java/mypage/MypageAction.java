package mypage;

import bean.School;
import dao.SchoolDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class MypageAction extends Action{
	public String execute(
			HttpServletRequest request, HttpServletResponse response	
		) throws Exception {
			
			HttpSession session=request.getSession();
			
			if (session.getAttribute("account")==null) {
				request.setAttribute("required_login", "マイページ");		
				return "../home/Required_login.action";
			}
			
			String scd=request.getParameter("scd");
			
			SchoolDAO dao=new SchoolDAO();
			School school=dao.search(scd);
			
			
			session.setAttribute("school", school);
			
			return "mypage.jsp";
		}
	}
