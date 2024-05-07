<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.jsp"  %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@include file="../home/menu.jsp" %>

<!-- 学生情報変更ページ -->
<div id="contents">
		<h1 class="function_title">学生情報変更</h1>
		<form action="StudentInfomationChange.action" method="post">
			
			<!-- 変更対象の学生の学生番号に一致する入学年度を初期値にしている -->
			入学年度
			<input class="student-change-line" type="text" name="ent_year" value="${changelist.ent_year}" readonly><br>
			
			<!-- 変更対象の学生の学生番号に一致する学生番号を初期値にしている -->
			学生番号
			<input class="student-change-line" type="text" name="no" value="${changelist.no}" readonly><br>
			
			氏名
			<input class="student-change-wk" type="text" name="name" maxlength="10" required="required"><br>
			
			<!-- ログインユーザの学校コードに対応するクラスを表示 -->
			クラス<select class="student-change-label"name="class_num">
			<c:forEach items="${classnumber}" var="classnumber">
				<option value="${classnumber.class_num}">${classnumber.class_num}</option>
			</c:forEach></select><br><br>
			
			<!-- 真偽値の送り方知らないので文字送るようにしました -->
			在学中<input type="checkbox" name="is_attend" value="enrollment" checked><br>
			
			<input type="hidden" name="school_cd" value="${changelist.school_cd}"><br>
			
			<input class="student-change-button" type="submit" value="変更">
		</form>
		
		
		<p><a href="studentinfomation.jsp">戻る</a></p>
	</div>







<%@include file="../footer.jsp"  %>