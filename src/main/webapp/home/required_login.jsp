<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header_error.jsp"  %>
<%@include file="menu.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div id="contents">

	<p>${required_login}機能はログイン時のみ使用可能です。</p>
	<p><a href="../studentaccount/login-in.jsp">ログイン</a>

</div>










<%@include file="../footer_error.jsp"  %>