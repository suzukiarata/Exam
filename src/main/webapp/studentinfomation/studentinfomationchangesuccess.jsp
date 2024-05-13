<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.jsp"  %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@include file="../home/menu.jsp"%>

<div id="contents">
	<h1 class="function_title">学生変更機能</h1>
	<h2 class="succsess_mes">変更が完了しました</h2>
	
	<!-- 何故かActionのURLを張れないので無理やり解決 -->
	<p><%@include file="../home/infomation.jsp"%></p>
</div>



<%@include file="../footer.jsp"  %>