package home;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class HomeAction extends Action{
	public String execute(
		HttpServletRequest request, HttpServletResponse response	
	) throws Exception {
		
		return "index.jsp";
	}
}