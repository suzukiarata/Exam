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
			<p class="handling_explanation">ログインユーザの学校コードに対応する、学生のクラスを追加することができます。</p>
			<p class="function_urls">新規追加はこのリンクから<a href="../studentinfomation/Class_numInsert.action?scd=${account.school_cd}">新規学生クラス追加</a></p>
		</div>
		<hr>
		<div class="mypage_function_contests">
			<p class="mypage_function_explanation">新規アカウント登録機能</p>
			<p class="handling_explanation">新規の教職員用アカウントを登録できます。</p>
			<p class="function_urls">新規登録はこちらから<a href="../teacheraccount/Teacher.action">新規アカウント登録</a></p> 
			<p class="exception_function">※新規の学校コードを利用する場合は先に「新規学校登録」をしてください</p> 
		</div>
		<hr>
		<div class="mypage_function_contests">
			<p class="mypage_function_explanation">新規学校登録機能</p>
			<p class="handling_explanation">新規の学校を登録できます。</p>
			<p class="function_urls">新規学校の登録はこちらから<a href="../schoolinfomation/schoolregistration.jsp">新規学校登録</a></p> 
		</div>
		<hr>
		<div class="mypage_function_contests">
			<p class="mypage_function_explanation">エラー機能確認用</p>
			<p class="handling_explanation">エラー機能の動作確認用</p>
			<p class="function_urls">エラーページのURL<a href="../home/Error.action">エラーページ</a></p> 
		</div>
	</div>
</div>










<%@include file="../footer.jsp"  %>