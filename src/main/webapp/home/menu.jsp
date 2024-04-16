<%@page contentType="text/html; charset=UTF-8" %>
<header>
	<h1>サンプル用サイト</h1>
	<p>${account.name}様</p>
	<p><a href="../studentaccount/Logout.action">ログアウト</a></p>
	<div id="navi">
		<ul>
			<li><a href="../home/Home.action">ホームへ</a>
			<li><a href="../studentinfomation/StudentInfomation.action?scd=${account.school_cd}">学生管理</a>
			<li><a href="../subjectinfomation/SubjectInfomation.action?scd=${account.school_cd}">科目管理</a>
			<li><a href="../gradesinfomation/GradesRegistration.action?scd=${account.school_cd}">成績管理</a>
			<li><a href="../home/Home.action">ホームへ</a>
		</ul>
	</div>
	
	<hr>
</header>
