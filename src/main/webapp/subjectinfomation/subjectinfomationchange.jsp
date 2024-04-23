<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.jsp"  %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@include file="../home/menu.jsp" %>

<div id="contents">
		<h1 class="function_title">科目情報変更</h1>
		<form action="SubjectInfomationChange.action" method="post">
		
			科目コード
			<input class="student-change-line" type="text" name="cd" value="${changeaction.cd}" readonly><br>
			
			科目名
			<input class="student-change-wk" type="text" name="name" maxlength="30"value="${changeaction.name}" required="required"><br><br><br>
			
			
			
			<input class="student-change-button" type="submit" value="変更">
		</form>
		
		
		<p><a href="subjectinfomation.jsp">戻る</a></p>
	</div>







<%@include file="../footer.jsp"  %>