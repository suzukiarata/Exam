<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.jsp"  %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@include file="../home/menu.jsp" %>

<div id="contents">
	<div id="theme">
		<h1>科目管理</h1>
		<p>科目情報の管理が行えます</p>
		<p><a href="subjectregistration.jsp">新規登録</a></p>
	</div>
	<div id="element">
		<h1>学生情報一覧</h1>
		<table>
			<tr>
				<td>科目コード</td>
				<td>科目名</td>
				<td></td>
				<td></td>
			</tr>
			<c:forEach items="${subject}" var="subject">
				<tr>
					<td>${subject.cd}</td>
					<td>${subject.name}</td>
					<td><a href="SubjectInfomationChange.action?no=${subject.cd}">変更</a></td>
					<td><a href="SubjectInfomationDalete.action?no=${subject.cd}">削除</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	

	<aside id="side">
	<section>
		<h4>サイドバー</h4>
		<p>サイドバーの内容</p>
	</section>
	</aside>
	<aside id="side">
	<section>
		<h4>サイドバー</h4>
		<p>複数配置可能</p>
	</section>
	</aside>
</div>


<%@include file="../footer.jsp"  %>