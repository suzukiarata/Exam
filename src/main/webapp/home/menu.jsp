<%@page contentType="text/html; charset=UTF-8" %>
<header>
	<div class="menu-title-label">
		
		<h1>得点管理システム</h1>
		
		<div class="menu-title-contents">
			<div class="accountname">
				<p>${account.name}様</p>
			</div>
			<div class="accountlogout">
				<p><a href="../studentaccount/Logout.action">ログアウト</a></p>
			</div>
		
		</div>
		
	</div>
	<div id="navi">
		<ul>
			<li><a href="../home/Home.action">ホームへ</a>
			<li><a href="../studentinfomation/StudentInfomation.action?scd=${account.school_cd}">学生管理</a>
			<li><a href="../subjectinfomation/SubjectInfomation.action?scd=${account.school_cd}">科目管理</a>
	        <li><a href="../gradesinfomation/GradesInfomation.action?scd=${account.school_cd}">成績登録</a>
	        <li><a href="../gradesinfomation/GradesReference.action?scd=${account.school_cd}">成績参照</a>
		</ul>
	</div>
	
	<hr>
</header>