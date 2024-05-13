<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.jsp"  %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@include file="../home/menu.jsp"%>

<div id="contents">
	<h1 class="function_title">学生情報登録</h1>
	<h2 class="succsess_mes">登録が完了しました</h2>
	<p><a href="studentregistration.jsp">戻る</a></p>
	
	<!-- これも無理やりリンク張っている -->
	<p><%@include file="../home/infomation.jsp"%></p>
</div>



<%@include file="../footer.jsp"  %>