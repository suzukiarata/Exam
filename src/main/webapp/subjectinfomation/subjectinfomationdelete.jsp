<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.jsp"  %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@include file="../home/menu.jsp" %>

<div id="contents">
		<h1 class="function_title">科目情報登録</h1>
		<form action="SubjectDeleteExecute.action?subject_cd=${subject.cd}" method="post">
			<p>「${subject.name}(${subject.cd})」を削除してもよろしいでしょうか</p>
			
			<input type="submit" value="削除" class="narrowdown_buttom">
		</form>
		
		
		<p><a href="subjectinfomation.jsp">戻る</a></p>







<%@include file="../footer.jsp"  %>