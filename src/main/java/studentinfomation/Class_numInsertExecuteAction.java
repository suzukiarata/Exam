package studentinfomation;

import java.util.List;

import bean.Class_num;
import dao.Class_numDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class Class_numInsertExecuteAction extends Action{
	public String execute(
		HttpServletRequest request, HttpServletResponse response	
	) throws Exception {
		
		HttpSession session=request.getSession();
		
		String school_cd=request.getParameter("school_cd");
		String class_num=request.getParameter("class_num");
		
		//文字数検査
		if(class_num.length() >= 6) {
			request.setAttribute("length_error", "クラス番号は5文字以内で入力してください");
			return "class_numinsertexecute.jsp";
		}
		
		//重複検査用
		Class_numDAO dao=new Class_numDAO();
		List<Class_num> s = dao.searchclass_num(class_num);
		if (s.size() != 0) {
			request.setAttribute("no_duplication_error", "クラス番号が重複しています");
			return "class_numinsertexecute.jsp";
		}
		int line=dao.insert(school_cd,class_num);
		
		if(line>0) {
			return "class_numinsertexecutesuccess.jsp";
		}
		
		
		
		
		request.setAttribute("error_text", "クラス追加機能");
		return "../home/Error.action";
	}
}
