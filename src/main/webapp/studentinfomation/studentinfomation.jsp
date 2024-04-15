<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.jsp"  %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@include file="../home/menu.jsp" %>

<div id="contents">
	<div id="theme">
		<h1>学生情報管理機能</h1>
		<p>学生情報の管理が行えます。</p>
		<form action="StudentInfomation.action" method="post">
			入学年度<select name="f1">
			<option value="" selected disabled>---------</option>
			<c:forEach items="${ent}" var="ent">
				<option value="${ent.ent_year}">${ent.ent_year}</option>
			</c:forEach></select>
			
			クラス<select name="f2">
			<option value="" selected disabled>---------</option>
			<c:forEach items="${classnumber}" var="classnumber">
				<option value="${classnumber.class_num}">${classnumber.class_num}</option>
			</c:forEach></select>
			
			在学中<input type="checkbox" name="f3" value="enrollment" checked>
			
			<input type="submit" value="絞込み">
		</form>
		<p><a href="studentregistration.jsp?${year}">新規登録</a></p>
	</div>
	<div id="element">
		<h1>学生情報一覧</h1>
		<table>
			<c:choose>
				<c:when test="${fn:length(student) == 0 }">
					<p>学生情報が存在しません</p>
				</c:when>
				<c:when test="${fn:length(student) != 0 }">
					<p>検索結果：${fn:length(student)}件</p>
					<tr>
						<th>入学年度</th>
						<th>学生番号</th>
						<th>氏名</th>
						<th>クラス</th>
						<th>在学中</th>
						<th></th>
					</tr>
					<c:forEach items="${student}" var="student">
						<tr>
							<td>${student.ent_year}</td>
							<td>${student.no}</td>
							<td>${student.name}</td>
							<td>${student.class_num}</td>
							<c:choose>
								<c:when test="${student.is_attend==true}"><td>○</td></c:when>
								<c:when test="${student.is_attend==false}"><td>✕</td></c:when>
							</c:choose>
							<td><a href="Change.action?no=${student.no}">変更</a></td>
						</tr>
					</c:forEach>
				</c:when>
			</c:choose>
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