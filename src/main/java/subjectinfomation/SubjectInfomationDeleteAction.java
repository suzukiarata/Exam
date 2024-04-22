package subjectinfomation;

import java.util.List;

import bean.Subject;
import dao.SubjectDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class SubjectInfomationDeleteAction extends Action{
	public String execute(
		HttpServletRequest request, HttpServletResponse response	
	) throws Exception {
		
		HttpSession session=request.getSession();
		
		//scdはurlで渡している(分からなかったら聞いて)
		String subject_cd=request.getParameter("subject_cd");
		
		//SubjectDAOのsearchメソッドを見て
		SubjectDAO subjectdao=new SubjectDAO();
		List<Subject> subject=subjectdao.searchcd(subject_cd);

		//↑に書いてあるsubjectっていう Subject型のリストをsubjectっていう名前でjspファイルに渡している。
		session.setAttribute("subject", subject);
		
		return "subjectinfomationdelete.jsp";
	}
}