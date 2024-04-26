<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.jsp"  %>
<%@include file="../home/menu.jsp" %>


<div id="contents">
	<h1 class="function_title">マイページ</h1>
	<div class="mypage_main">
		<div class="mypage_main_contents">
			<p class="mypage_tags">氏名</p>
			<p class="mypage_name">${account.name}</p>
		</div>
		<div class="mypage_main_contents">
			<p class="mypage_tags">学校名</p>
			<p class="school_name">${school.name}</p>
		</div>
		<div class="mypage_main_contents">
			<p class="mypage_tags">アカウント情報</p>
			<p class="account_id">アカウントID：${account.id}</p>
			<p class="account_pass">パスワード：${account.password}</p>
		</div>
	</div>
	
	<div class="mypage_function">
		
		<h1 class="mypage_function_contests_title">各種機能</h1>
	
		<div class="mypage_function_contests_top">
			<p class="mypage_function_explanation">新規学生クラス追加機能</p>
			<p class="handling_explanation">学校コードに対応する、学生のクラスを追加することができます。</p>
			<p class="function_urls">新規追加はこのリンクから<a href="../studentinfomation/Class_numInsert.action?scd=${account.school_cd}">新規学生クラス追加</a></p> 
		</div>
		<div class="mypage_function_contests">
			<p class="mypage_function_explanation">新規アカウント登録機能</p>
			<p class="handling_explanation">新規の教職員用アカウントを登録できます。</p>
			<p class="function_urls">新規登録はこちらから<a href="../teacheraccount/teacherregistration.jsp">新規アカウント登録</a></p> 
		</div>
	</div>
</div>










<%@include file="../footer.jsp"  %>