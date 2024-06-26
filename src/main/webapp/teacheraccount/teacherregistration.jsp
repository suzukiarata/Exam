<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.jsp"  %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@include file="../home/menu.jsp" %>

<div id="contents">
		<h1 class="function_title">新規アカウント登録</h1>
		<form action="TeacherRegistration.action" method="post">
			
			<br>
			ID
			<input class="select_ent_year" type="text" name="id" maxlength="10" required="required" placeholder="IDを入力してください">
			<p class="exception_message">${no_duplication_error}</p>
	
			<br>
			パスワード
			<input class="select_ent_year" type="text" name="password" maxlength="30" required="required"placeholder="パスワードを入力してください"><br>
			<br><br>
			名前
			<input class="select_ent_year" type="text" name="name" maxlength="30" required="required"placeholder="名前を入力してください">
			
			<br><br>
			学校コード
			<select name="school_cd"class="select_label_line">
			<option value="">---------</option>
			<c:forEach items="${schoollist}" var="schoollist">
			
				<option value="${schoollist.school_cd}">${schoollist.name} (${schoollist.school_cd })</option>
				
			</c:forEach></select>
			<p class="exception_message">${none_select}</p>
			
			
			<br><br>
			
			
			<input type="submit" value="登録" class="narrowdown_buttom">
		</form>
		
		
		<p><a href="../mypage/mypage.jsp">戻る</a></p>







<%@include file="../footer.jsp"  %>