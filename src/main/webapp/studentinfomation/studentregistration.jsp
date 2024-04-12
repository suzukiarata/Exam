<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html"  %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<%@include file="../home/menu.jsp" %>


<div id="contents">
	<div id="theme">
		<h1>学生情報登録</h1>
		<p>学生情報の登録が行えます。</p>
		<form action="StudentRegistration.action" method="post">
			入学年度<select name="ent_year" required="required">
			<option value="" selected disabled>-----------</option>
			<option value="2021">2021</option>
			<option value="2022">2022</option></select>
			
			学生番号
			<input type="text" name="no" required="required">
			<p>${error}</p>
	
			
			氏名
			<input type="text" name="name" required="required">
			
			クラス<select name="class_num">
			<option value="101">101</option>
			<option value="201">201</option></select>
			
			<input type="hidden" name="school_cd" value="${account.school_cd}">
			
			
			
			<input type="submit" value="登録して終了">
		</form>
		
		
		<p><a href="studentinfomation.jsp">戻る</a></p>
	</div>







<%@include file="../footer.html"  %>