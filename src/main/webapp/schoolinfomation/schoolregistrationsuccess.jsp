<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.jsp"  %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@include file="../home/menu.jsp"%>

<div id="contents">
	<h1 class="function_title">新規学校登録</h1>
	<h2 class="succsess_mes">登録が完了しました</h2>
	<p><a href="schoolregistration.jsp">戻る</a></p>
	<p><a href="../mypage/Mypage.action?scd=${account.school_cd}">マイページへ</a></p>
</div>



<%@include file="../footer.jsp"  %>