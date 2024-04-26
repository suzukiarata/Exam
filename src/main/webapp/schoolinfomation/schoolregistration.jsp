<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.jsp"  %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@include file="../home/menu.jsp" %>

<div id="contents">
		<h1 class="function_title">新規学校登録</h1>
		<form action="SchoolRegistration.action" method="post">
			
			<br>
			学校コード
			<input class="select_ent_year" type="text" name="cd" maxlength="10" required="required" placeholder="学校コードを入力してください">
			<p class="exception_message">${no_duplication_error}</p>

			名前
			<input class="select_ent_year" type="text" name="name" maxlength="30" required="required"placeholder="名前を入力してください">
			
			<br><br>
			<input type="submit" value="登録" class="narrowdown_buttom">
		</form>
		
		
		<p><a href="../mypage/mypage.jsp">戻る</a></p>







<%@include file="../footer.jsp"  %>