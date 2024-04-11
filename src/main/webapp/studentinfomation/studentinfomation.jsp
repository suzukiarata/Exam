<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html"  %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<%@include file="../home/menu.jsp" %>

<div id="contents">
	<div id="element">
		<h1>学生情報管理機能</h1>
		<p>学生情報の管理が行えます。</p>
		<p>検索キーワードを入力してください。</p>
		<form action="StudentInfomation.action" method="post">
			入学年度<select name="f1">
			<option value="2021">2021</option>
			<option value="2022">2022</option></select>
			クラス<select name="f2">
			<option value="201">201</option>
			<option value="202">202</option></select>
			在学中<input type="checkbox" name="f3" value="true">
			<input type="submit" value="絞込み">
		</form>
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
				<th></th>
			</tr>
			<c:forEach items="${list}" var="s">
				<tr>
					<td>${s.ent_year}</td>
					<td>${s.no}</td>
					<td>${s.name}</td>
					<td>${s.class_num}</td>
					<c:choose>
						<c:when test="${s.is_attend==true}"><td>○</td></c:when>
						<c:when test="${s.is_attend==false}"><td>✕</td></c:when>
					</c:choose>
					<td><a href="StudentInfomationChange.action?no=${s.no}">変更</a></td>
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