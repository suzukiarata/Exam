<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html"  %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="../css/style.css">

<%@include file="../home/menu.jsp" %>

<div id="contents">
	<div id="element">
		<h1>学生情報管理機能</h1>
		<p>学生情報の管理が行えます。</p>
	</div>
	<div id="element">
		<h1>学生情報一覧</h1>
		<table>
		<tr>
			<th>入学年度</th>
			<th>学生番号</th>
			<th>氏名</th>
			<th>クラス</th>
			<th>在学中</th>
		</tr>
		<c:forEach var="student" items="${list}">
			<tr>
				<td>${student.ent_year}</td>
				<td>${student.no}</td>
				<td>${student.name}</td>
				<td>${student.num_class}</td>
				<c:if test="${student.is_attend==True}">
					○
				</c:if>
				<c:if test="${student.is_attend==False}">
					✕
				</c:if>
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







<%@include file="../footer.html"  %>