<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.jsp"  %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@include file="../home/menu.jsp" %>

<div id="contents">
		<h1 class="function_title">科目情報登録</h1>
		<form action="SubjectRegistration.action" method="post">
			
			<br>
			科目コード
			<input class="select_ent_year" type="text" name="cd" maxlength="10" required="required" placeholder="科目コードを入力してください" value="${entered_cd}">
			<p class="exception_message">${no_duplication_error}</p>
			<p class="exception_message">${length_error}</p>
	
			<br>
			科目名
			<input class="select_ent_year" type="text" name="name" maxlength="20" required="required"placeholder="科目名を入力してください" value="${entered_name}">
			
			<br><br><br>
			<input type="hidden" name="school_cd" value="${account.school_cd}">
			
			
			<input type="submit" value="登録" class="narrowdown_buttom">
		</form>
		
		
		<p><a href="subjectinfomation.jsp">戻る</a></p>







<%@include file="../footer.jsp"  %>