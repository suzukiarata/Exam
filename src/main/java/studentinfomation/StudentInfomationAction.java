package studentinfomation;

import java.util.Calendar;
import java.util.List;

import bean.Class_num;
import bean.Student;
import dao.Class_numDAO;
import dao.StudentDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class StudentInfomationAction extends Action{
	public String execute(
		HttpServletRequest request, HttpServletResponse response	
	) throws Exception {
		
		HttpSession session=request.getSession();
		
		if (session.getAttribute("account")==null) {
			request.setAttribute("required_login", "学生管理");		
			return "../home/Required_login.action";
		}
		
		String num=request.getParameter("f1");
		int ent_year=0;
		if(num != null) {
			ent_year=Integer.parseInt(num);
		}
		String class_num=request.getParameter("f2");
		if(class_num == null) {
			class_num = "no";
		}
		String authenticity=request.getParameter("f3");
		if(authenticity == null) {
			authenticity = "no";
		}
		String scd=request.getParameter("scd");
		StudentDAO studentdao=new StudentDAO();
		List<Student> student=null;
		
		//無理矢理検索条件の一部検索機能を作った。コードのみだとかなり複雑。
		
		//全部が未選択(初回起動or絞り込み要素未選択)
		if(ent_year == 0 && class_num.equals("no") && authenticity.equals("no")) {
			student=studentdao.firstsearch(scd);
		}
		//全選択
		else if(ent_year != 0 && class_num.equals("no") == false && authenticity.equals("no") == false) {
			student=studentdao.allsearch(ent_year,class_num,true,scd);
		}
		//入学年度選択
		else if(ent_year != 0) {
			
			//入学年度+クラス
			if(class_num.equals("no") == false && authenticity.equals("no")) {
				student=studentdao.yearclasssearch(ent_year,class_num,scd);
			}
			//入学年度+在学中
			else if(class_num.equals("no") && authenticity.equals("no") == false) {
				student=studentdao.yearattendsearch(ent_year,true,scd);
			}
			//入学年度のみ
			else {
				student=studentdao.yearsearch(ent_year,scd);
			}
		}
		//クラス選択
		else if(class_num.equals("no") == false) {
			//クラス+在学中
			if(ent_year == 0 && authenticity.equals("on")) {
				request.setAttribute("error_mes", "クラスを指定する場合、入学年度も指定してください");
				return "studentinfomation.jsp";
			}
			//クラスのみ
			else {
				request.setAttribute("error_mes", "クラスを指定する場合、入学年度も指定してください");
				return "studentinfomation.jsp";
			}
		}
		//在学中選択
		else if(authenticity.equals("on")) {
			student=studentdao.attendsearch(true,scd);
		}
		
		
		
		List<Student> ent=studentdao.searchent();
		
		Class_numDAO classdao=new Class_numDAO();
		List<Class_num> classnumber=classdao.search(scd);
		
		Calendar calendar = Calendar.getInstance();
	    int year = calendar.get(Calendar.YEAR);
		
	    session.setAttribute("student", student);
		session.setAttribute("ent", ent);
		session.setAttribute("classnumber", classnumber);
		session.setAttribute("year", year);
		
		return "studentinfomation.jsp";
	}
}
