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

public class GradesInfomationStudentExecuteAction extends Action{
	public String execute(
		HttpServletRequest request, HttpServletResponse response	
	) throws Exception {
		
		HttpSession session=request.getSession();
		
		

		String student_no=request.getParameter("f4");
		String scd=request.getParameter("scd");
		
		//検索条件に一致するテスト情報の取得
		TestDAO testdao=new TestDAO();
		List<Test> t=testdao.studentsearch(student_no);
		
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
		
		return "gradesinfomationstudentexecute.jsp";
	}
}