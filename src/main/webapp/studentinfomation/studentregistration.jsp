<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.jsp"  %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@include file="../home/menu.jsp" %>

<div id="contents">
	<div id="theme">
		<h1>学生情報登録</h1>
		<p>学生情報の登録が行えます。</p>
		<form action="StudentRegistration.action" method="post">
			入学年度<select name="ent_year">
			<option value="0">---------</option>
			<c:forEach begin="${year - 10}" end="${year + 10}" step="1" var="foryear">
			<option value="${foryear}">${foryear}</option>
			</c:forEach></select>
			<p>${ent_year_none_error}</p>
			
			学生番号
			<input type="text" name="no" maxlength="10" required="required" value="${entered_no}">
			<p>${no_duplication_error}</p>
	
			
			氏名
			<input type="text" name="name" maxlength="30" required="required" value="${entered_name}">
			
			クラス<select name="class_num">
			<c:forEach items="${classnumber}" var="classnumber">
				<c:choose>
					<c:when test="${entered_class_num == classnumber.class_num}">
						<option value="${classnumber.class_num}" selected>${classnumber.class_num}</option>
					</c:when>
					<c:otherwise>
			       	<option value="${classnumber.class_num}">${classnumber.class_num}</option>
			    	</c:otherwise>	
				</c:choose>
			</c:forEach></select>
			
			<input type="hidden" name="school_cd" value="${account.school_cd}">
			
			
			
			<input type="submit" value="登録して終了">
		</form>
		
		
		<p><a href="studentinfomation.jsp">戻る</a></p>
	</div>







<%@include file="../footer.jsp"  %>