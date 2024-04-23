<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.jsp"  %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@include file="../home/menu.jsp" %>

<div id="contents">
	
	<h1 class="function_title">科目管理</h1>
	
	<!-- subjectregistration.jspは登録用のjspファイル　同じ階層に作ってね -->
	<p><a href="subjectregistration.jsp" class="registration_link">新規登録</a></p>
	
	
	<table class="grades_infomation">
		<tr>
			<th class="table_normal_tag">科目コード</th>
			<th class="table_subject_title">科目名</th>
			<th class="table_normal_tag"></th>
			<th class="table_normal_tag"></th>
		</tr>
		
		<!-- javaのsubjectinfomationファルダの中のSubjectInfomationAction.javaで、
		     subjectっていうリストがセッション情報として与えられている(分からなかったら聞いて) -->
		<c:forEach items="${subject}" var="subject">
			<tr>
				<td>${subject.cd}</td>
				<td>${subject.name}</td>
				
				<!-- javaのsubjectinfomationファルダの中に下記のファイルを作成してね
				     ?no=${subject.cd}"は該当する行の科目コードをsubject_cdっていう名前で渡しているよ -->
				<td><a href="SubjectChange.action?subject_cd=${subject.cd}">変更</a></td>
				<td><a href="SubjectInfomationDelete.action?subject_cd=${subject.cd}">削除</a></td>
			</tr>
		</c:forEach>
	</table>
	
	
</div>


<%@include file="../footer.jsp"  %>