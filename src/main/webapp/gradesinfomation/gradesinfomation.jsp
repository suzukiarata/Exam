<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.jsp"  %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@include file="../home/menu.jsp" %>


<!-- 成績管理のページ -->
<div id="contents">
	<h1 class="function_title">成績管理機能</h1>
	
	<div class="studentform">
		<form action="GradesInfomationExecute.action?scd=${account.school_cd}" method="post">
			
			<!-- 特にコメントすることは無い -->
			<div class="gradesform_elements">
				<label>入学年度</label><br>
				<select name="f1">
					<option value="0" selected>---------</option>
					<c:forEach items="${ent}" var="ent">
						<option value="${ent.ent_year}">${ent.ent_year}</option>
					</c:forEach>
				</select>
			</div>
			
			<div class="gradesform_elements">
				<label>クラス</label><br>
				<select name="f2">
					<option value="" selected>---------</option>
					<c:forEach items="${classnumber}" var="classnumber">
						<option value="${classnumber.class_num}">${classnumber.class_num}</option>
					</c:forEach>
				</select>
			</div>

			<div class="gradesform_elements2">
				<label>科目</label><br>
				<select name="f3">
				<option value="" selected>---------</option>
				<c:forEach items="${subject}" var="subject">
					<option value="${subject.cd}">${subject.name}</option>
				</c:forEach></select>
			</div>
			
			<div class="gradesform_elements">
				<label>回数</label><br>
				<select name="f4">
				<option value="0" selected>---------</option>
				<option value="1">1</option>
				<option value="2">2</option>
				</select>
			</div>
			
			<div class="gradesform_elements1">
				<input type="submit" value="検索" class="narrowdown_buttom">
			</div>
			
			<p class="exception_message">${none_error}</p>
			
		</form>	
	</div>
	<div>
		
	</div>
</div>


<%@include file="../footer.jsp"  %>