<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header_animation.jsp"  %>
<%@include file="menu.jsp" %>



<div id="contents">
	<div class="home_title">
		<p>メニュー</p>
	</div>
	
	<div class="home_body">
		<div class="home_contents">
			<a href="../studentinfomation/StudentInfomation.action?scd=${account.school_cd}"><div class="home_image">
				<img src="../images/ラーメン.png" class="home_contents_image">
			</div></a>
			<div class="home_explanation">
				<h1 class="home_explanation_title">学生管理機能</h1>
				<p class="home_explanation_elements_normal">ログインユーザの学校コードに対応する学生の情報について</p>
				<p class="home_explanation_elements">・一覧検索</p>
				<p class="home_explanation_elements">・新規登録</p>
				<p class="home_explanation_elements">・変更</p>
				<p class="home_explanation_elements_normal">これらの機能を利用できます。</p>
				
			</div>
		</div>
		
		<hr>
		
		<div class="home_contents">
			<a href="../subjectinfomation/SubjectInfomation.action?scd=${account.school_cd}"><div class="home_image_pasta">
				<img src="../images/たらこパスタ.png" class="home_contents_image_pasta">
			</div></a>
			<div class="home_explanation">
				<h1 class="home_explanation_title">科目管理機能</h1>
				<p class="home_explanation_elements_normal">ログインユーザの学校コードに対応する科目の情報について</p>
				<p class="home_explanation_elements">・一覧表示</p>
				<p class="home_explanation_elements">・新規登録</p>
				<p class="home_explanation_elements">・変更</p>
				<p class="home_explanation_elements">・削除</p>
				<p class="home_explanation_elements_normal">これらの機能を利用できます。</p>
			</div>
		</div>
		
		<hr>
		
		<div class="home_contents">
			<div class="home_image_itamae">
				<img src="../images/板前.png" class="home_contents_image_itamae">
			</div>
			<div class="home_explanation">
				<h1 class="home_explanation_title">成績管理機能</h1>
				<div class="home_multi">
					<div class="home_multi_explanation">
						<a href="../gradesinfomation/GradesInfomation.action?scd=${account.school_cd}"><div class="home_multi_image_body">
							<img src="../images/エビ.png" class="home_multi_image">
						</div></a>
						<div class="home_multi_explanation_text">
							<h1 class="home_multi_title">成績登録</h1>
							<p class="multi_home_explanation_elements_normal">ログインユーザの学校コードに対応する<br>学生のテスト情報について</p>
							<p class="multi_home_explanation_elements">・新規登録</p>
							<p class="multi_home_explanation_elements">・変更</p>
							<p class="multi_home_explanation_elements_normal">これらの機能を利用できます。</p>
						</div>
					</div>
					<hr>
					<div class="home_multi_explanation">
						<a href="../gradesinfomation/GradesReference.action?scd=${account.school_cd}"><div class="home_multi_image_body">
							<img src="../images/サーモン.png" class="home_multi_image">
						</div></a>
						<div class="home_multi_explanation_text">
							<h1 class="home_multi_title">成績参照</h1>
							<p class="multi_home_explanation_elements_normal">ログインユーザの学校コードに対応する<br>学生のテスト情報について</p>
							<p class="multi_home_explanation_elements">・一覧検索(科目毎／学生毎)</p>
							<p class="multi_home_explanation_elements">・統計出力</p>
							<p class="multi_home_explanation_elements_normal">これらの機能を利用できます。</p>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<hr>
		
		<div class="home_contents">
			<a href="../mypage/Mypage.action?scd=${account.school_cd}"><div class="home_mypage_image">
				<img src="../images/ハヤシライス.png" class="home_mypage_image_in">
			</div></a>
			<div class="home_mypage_text">
				<h1 class="home_mypage_title">マイページへ</h1>
				<p class="home_mypage_inner_text">ログインユーザの情報の確認や</p>
				<p class="home_mypage_inner_text">各種追加機能を利用できます。</p>
			</div>
			<a href="../mypage/Mypage.action?scd=${account.school_cd}"><div class="home_mypage_image">
				<img src="../images/八宝菜.png" class="home_mypage_image_in">
			</div></a>
		</div>
	</div>
</div>










<%@include file="../footer_animation.jsp"  %>