package gradesinfomation;

import java.util.ArrayList;
import java.util.List;

import bean.Test;
import dao.StudentDAO;
import dao.TestDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class GradesRegistrationAction extends Action{
	public String execute(
		HttpServletRequest request, HttpServletResponse response	
	) throws Exception {
		
		
			HttpSession session=request.getSession();
		
			int ent_year=Integer.parseInt(request.getParameter("ent_year")); 
			String class_num=request.getParameter("class_num");
			String subject_cd=request.getParameter("subject_cd");
			int no=Integer.parseInt(request.getParameter("no")); 
			
			int line=0;
			
			TestDAO testdao=new TestDAO();
			List<Test> t=testdao.search(ent_year, class_num, subject_cd, no);
			
			StudentDAO studentdao=new StudentDAO();
			List<Test> s = studentdao.searchtest(ent_year, class_num, subject_cd, no);
			
			if (t.size() != s.size()) {
				List<Test> tas = new ArrayList<>();
				if (t.size() != 0) {
					iflabel:for(Test i:s) {
						for(Test j:t) {
							if(i.getStudent_no() == j.getStudent_no()) {
								tas.add(j);
								continue iflabel;
							}
						}
						tas.add(i);
					}
				} else {
					for(Test i:s) {
						tas.add(i);
					}
				}
				
				for(Test i:tas) {
					String num = request.getParameter("int_" + i.getStudent_no());
					if (num == "") {
						continue;
					} else {
						int point=Integer.parseInt(num);
						line=testdao.registrationpoint(i, point);
					}
				}
				
				
				return "gradesinfomationexecutesuccess.jsp";
				
				
			}
			
			for(Test i:t) {
				String num = request.getParameter("int_" + i.getStudent_no());
				if (num == "") {
					continue;
				} else {
					int point=Integer.parseInt(num);
					line=testdao.registrationpoint(i, point);
				}
			}
			
			if(line>0) {
				return "gradesinfomationexecutesuccess.jsp";
			}
			
			request.setAttribute("error_text", "成績登録/変更機能");
			return "../home/Error.action";
			
			
		}
	}	
