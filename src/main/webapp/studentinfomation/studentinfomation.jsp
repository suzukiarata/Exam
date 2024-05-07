<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.jsp"  %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@include file="../home/menu.jsp" %>


<!-- 学生管理ページ -->
<div id="contents">
	<h1 class="function_title">学生情報管理機能</h1>
	<a href="studentregistration.jsp" class="registration_link">新規登録</a>
	
	
	<div class="studentform">
		
		<!-- フォーム送信時に学校コードを追加で渡している -->
		<form action="StudentInfomation.action?scd=${account.school_cd}" method="post">
			
			<!-- 入学年度は学生テーブルに存在する入学年度のみ表示している -->
			<div class="studentform_elements">
				<label>入学年度</label><br>
				<select name="f1">
				<option value="0" selected>---------</option>
				<c:forEach items="${ent}" var="ent">
					<option value="${ent.ent_year}">${ent.ent_year}</option>
				</c:forEach></select>
			</div>
			
			<!-- クラスは学校コードに対応しているクラスのみ表示している -->
			<div class="studentform_elements">
				<label>クラス</label><br>
				<select name="f2">
				<option value="no" selected>---------</option>
				<c:forEach items="${classnumber}" var="classnumber">
					<option value="${classnumber.class_num}">${classnumber.class_num}</option>
				</c:forEach></select>
			</div>
			
			<!-- 真偽値の送り方知らないので文字送るようにしました -->
			<div class="studentform_elements1">
				<input type="checkbox" name="f3" value="on">
				<label>在学中</label>
			</div>
			
			<div class="studentform_elements1">
				<input type="submit" value="絞込み" class="narrowdown_buttom">
			</div>
			
			<p class="exception_message">${error_mes}</p>
			
		</form>	
	</div>
	<div>
	
		<!-- 検索結果一覧の表示 -->
		<table class="student_list">
			
			<!-- Functionタグを使用して、セッションに保存している配列(student)の長さを取得している -->
			<c:choose>
				<c:when test="${fn:length(student) == 0 }">
					<p class="none_message">学生情報が存在しません</p>
				</c:when>
				<c:when test="${fn:length(student) != 0 }">
					<p class="number_of_data">検索結果：${fn:length(student)}件</p>
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
</div>


<%@include file="../footer.jsp"  %>