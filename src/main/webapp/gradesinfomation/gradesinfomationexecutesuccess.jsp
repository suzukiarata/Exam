<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.jsp"  %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@include file="../home/menu.jsp"%>

<div id="contents">
	<h1 class="function_title">学生管理</h1>
	<h2 class="succsess_mes">登録が完了しました</h2>
	<p><%@include file="../home/gradesinfomation.jsp"%></p>
	<p><a href="../gradesinfomation/GradesReference.action">学生参照</a></p>
</div>



<%@include file="../footer.jsp"  %>