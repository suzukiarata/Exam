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
	
	
	<div class="gnavi__wrap">
     <ul class="gnavi__lists">
        <li class="gnavi__list">
            <a href="../home/Home.action">ホームへ</a>
            <li class="gnavi__list">
            <a href="../studentinfomation/StudentInfomation.action?scd=${account.school_cd}">学生管理</a>
            <li class="gnavi__list">
            <a href="../subjectinfomation/SubjectInfomation.action?scd=${account.school_cd}">科目管理</a>
            <li class="gnavi__list">
            <a href="">成績管理</a>
            <ul class="dropdown__lists">
                <li class="dropdown__list"><a href="../gradesinfomation/GradesInfomation.action?scd=${account.school_cd}">成績登録</a></li>
                <li class="dropdown__list"><a href="../gradesinfomation/GradesReference.action?scd=${account.school_cd}">成績参照</a></li>
            </ul>
            <li class="gnavi__list">
            <a href="">マイページへ</a>
        </li>
    </ul>
</div>
	
	
	<hr>
</header>