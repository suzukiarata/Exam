<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.jsp"  %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@include file="../home/menu.jsp" %>

<div id="contents">
	<h1 class="function_title">成績管理機能</h1>
	
	<div class="studentform">
		<form action="GradesInfomationExecute.action?scd=${account.school_cd}" method="post">
			
			<div class="studentform_elements">
				<label>入学年度</label><br>
				<select name="f1">
				<option value="0" selected>---------</option>
				<c:forEach items="${ent}" var="ent">
					<option value="${ent.ent_year}">${ent.ent_year}</option>
				</c:forEach></select>
			</div>
			
			<div class="studentform_elements">
				<label>クラス</label><br>
				<select name="f2">
				<option value="" selected>---------</option>
				<c:forEach items="${classnumber}" var="classnumber">
					<option value="${classnumber.class_num}">${classnumber.class_num}</option>
				</c:forEach></select>
			</div>

			<div class="studentform_elements">
				<label>科目</label><br>
				<select name="f3">
				<option value="" selected>---------</option>
				<c:forEach items="${subject}" var="subject">
					<option value="${subject.cd}">${subject.name}</option>
				</c:forEach></select>
			</div>
			
			<div class="studentform_elements">
				<label>回数</label><br>
				<select name="f4">
				<option value="0" selected>---------</option>
				<option value="1">1</option>
				<option value="2">2</option>
				</select>
			</div>
			
			<p>${none_error}</p>
			
			<div class="studentform_elements1">
				<input type="submit" value="検索" class="narrowdown_buttom">
			</div>
			
		</form>	
	</div>
	<div>
		<form action="GradesRegistration.action?scd=${account.school_cd}" method="post">
			<c:choose>
				<c:when test="${fn:length(test) == 0 }">
					<p class="none_message">学生情報が存在しません</p>
				</c:when>
				<c:when test="${fn:length(test) != 0 }">
				
					<c:forEach items="${subject}" var="subject">
						<c:choose>
							<c:when test="${subject.cd == subject_cd}">
								<p class="number_of_data">科目:${subject.name}（${no}回）</p>
							</c:when>
						</c:choose>
					</c:forEach>
					<table>
						<tr>
							<th>入学年度</th>
							<th>クラス</th>
							<th>学生番号</th>
							<th>氏名</th>
							<th>点数</th>
						</tr>
						<c:forEach items="${test}" var="test">
							<tr>
								<td>${test.ent_year}</td>
								<td>${test.class_num}</td>
								<td>${test.student_no}</td>
								<td>${test.name}</td>
								<td><input type="text" name="int_${test.student_no}" value="${test.point}"></td>
							</tr>
						</c:forEach>
					</table>
				</c:when>
			</c:choose>	
			
			<input type="hidden" name="ent_year" value="${ent_year}">
			<input type="hidden" name="class_num" value="${class_num}">
			<input type="hidden" name="no" value="${no}">
			<input type="hidden" name="subject_cd" value="${subject_cd}">
			
			<input type="submit" value="登録して終了" class="narrowdown_buttom">
		</form>
	</div>
	
</div>


<%@include file="../footer.jsp"  %>