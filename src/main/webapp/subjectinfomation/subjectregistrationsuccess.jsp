<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.jsp"  %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@include file="../home/menu.jsp"%>

<div id="contents">
	<h2 class="successtag">登録が完了しました</h2>
	<p><a href="subjectregistration.jsp">戻る</a></p>
	<p><%@include file="../home/subjectinfomation.jsp"%></p>
</div>



<%@include file="../footer.jsp"  %>