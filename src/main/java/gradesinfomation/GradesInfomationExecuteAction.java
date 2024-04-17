package gradesinfomation;

import java.util.List;

import bean.Class_num;
import bean.Student;
import bean.Subject;
import bean.Test;
import dao.Class_numDAO;
import dao.StudentDAO;
import dao.SubjectDAO;
import dao.TestDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class GradesInfomationExecuteAction extends Action{
	public String execute(
		HttpServletRequest request, HttpServletResponse response	
	) throws Exception {
		
		HttpSession session=request.getSession();
		
		
		int ent_year=Integer.parseInt(request.getParameter("f1")); 
		String class_num=request.getParameter("f2");
		String subject_cd=request.getParameter("f3");
		int no=Integer.parseInt(request.getParameter("f4")); 
		
		if (ent_year == 0 || class_num == null || subject_cd == null || no == 0) {
			request.setAttribute("none_error", "入学年度とクラスと科目と回数を選択してください");
			return "gradesinfomationexecute.jsp";
		}
		
		
		String scd=request.getParameter("scd");
		
		//ここは恐らくOK
		Test test=new Test();
		test.setEnt_year(ent_year);
		test.setClass_num(class_num);
		test.setSubject_cd(subject_cd);
		test.setNo(no);
		
		
		//検索条件に一致するテスト情報の取得
		TestDAO testdao=new TestDAO();
		List<Test> t=testdao.search(test);
		
		if (ent_year != 0) {
			session.setAttribute("test", t);
			return "gradesinfomationexecute.jsp";
		}
		
		
		//テストテーブルに存在する学生の入学年度の取得
		StudentDAO studentdao=new StudentDAO();
		List<Student> ent=studentdao.searchtestent();
		
		//学校コードに対応するクラスの情報
		Class_numDAO classdao=new Class_numDAO();
		List<Class_num> classnumber=classdao.search(scd);
		
		//学校コードに対応する科目の情報
		SubjectDAO subjectdao=new SubjectDAO();
		List<Subject> subject=subjectdao.search(scd);
		

		session.setAttribute("classnumber", classnumber);
		session.setAttribute("ent", ent);
		session.setAttribute("subject", subject);
		session.setAttribute("test", t);
		
		return "gradesinfomationexecute.jsp";
	}
}