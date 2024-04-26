<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.jsp"  %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@include file="../home/menu.jsp" %>


<!-- 追加機能のクラスの新規登録ページ -->
<div id="contents">
		<h1 class="function_title">新規クラス登録</h1>
		<form action="Class_numInsertExecute.action" method="post">
		
			
			<!-- クラスは文字数制限と重複エラーに対応している -->
			<br>
			クラス
			<input class="select_ent_year" type="text" name="class_num" required="required"placeholder="クラスを入力してください">
			<p class="exception_message">${no_duplication_error}</p>
			<p class="exception_message">${length_error}</p>
			
			
			<br>
			<input type="hidden" name="school_cd" value="${account.school_cd}">
			
			
			<input type="submit" value="登録して終了" class="narrowdown_buttom">
		</form>
		
		
		<p><a href="../mypage/Mypage.action?scd=${account.school_cd}">戻る</a></p>







<%@include file="../footer.jsp"  %>