<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.jsp"  %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@include file="../home/menu.jsp" %>

<div id="contents">
	<div id="theme">
		<h1>学生情報変更</h1>
		<form action="StudentInfomationChange.action" method="post">
		
			入学年度
			<input type="text" name="ent_year" value="${changelist.ent_year}" readonly><br>
			
			学生番号
			<input type="text" name="no" value="${changelist.no}" readonly><br>
			
			氏名
			<input type="text" name="name" maxlength="30" required="required"><br>
			
			クラス<select name="class_num">
			<c:forEach items="${classnumber}" var="classnumber">
				<option value="${classnumber.class_num}">${classnumber.class_num}</option>
			</c:forEach></select><br>
			
			在学中<input type="checkbox" name="is_attend" value="enrollment" checked><br>
			
			<input type="hidden" name="school_cd" value="${changelist.school_cd}">
			
			<input type="submit" value="変更">
		</form>
		
		
		<p><a href="studentinfomation.jsp">戻る</a></p>
	</div>







<%@include file="../footer.jsp"  %>