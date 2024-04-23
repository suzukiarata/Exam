<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.jsp"  %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@include file="../home/menu.jsp" %>

<div id="contents">
	<h1 class="function_title">成績一覧（学生）</h1>
	
	<div class="studentform">
		<form action="GradesInfomationSubjectExecute.action?scd=${account.school_cd}" method="post">
			
			<div class="gradesform_elements">
				<p>科目情報</p>
			</div>
			
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
			<div class="gradesform_elements1">
				<input type="submit" value="検索" class="narrowdown_buttom">
			</div>
			<p class="exception_message">${subject_none_error}</p>
			
		</form>	
		
		<hr>
		
		<form action="GradesInfomationStudentExecute.action?scd=${account.school_cd}" method="post">
			
			
			<div class="gradesform_elements">
				<p>学生情報</p>
			</div>
			<div class="gradesform_elements2">
				<label>学生番号</label><br>
				<input type="text"name="f4" required="required" class="reference_no">
			</div>	
			<div class="gradesform_elements1">
				<input type="submit" value="検索" class="narrowdown_buttom">
			</div>
			<div class="gradesform_elements">
			</div>
			<div class="gradesform_elements">
			</div>
		</form>
		
		<hr>
		
		<form action="GradesInfomationStatisticsExecute.action?scd=${account.school_cd}" method="post">
			
			
			<div class="gradesform_elements">
				<p>統計情報</p>
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
			<div class="gradesform_elements">
			</div>
			<p class="exception_message">${none_statistics}</p>
		</form>
	</div>
	<div>
		<c:choose>
			<c:when test="${fn:length(test) == 0 }">
				<c:choose>
					<c:when test="${studentdata == null}">
						<p class="number_of_data">検索した番号に一致する生徒が存在しません</p>
					</c:when>
					<c:when test="${studentdata != null}">
						<p class="number_of_data">氏名:${studentdata.name}（${studentdata.no}）</p>
						<p class="number_of_data">成績情報が存在しません</p>
					</c:when>
				</c:choose>
			</c:when>
			<c:when test="${fn:length(test) != 0 }">	
				<p class="number_of_data">氏名:${test[0].name}（${test[0].student_no}）</p>
				<table class="grades_infomation">
					<tr>
						<th class="table_subject_title">科目名</th>
						<th class="table_normal_tag">科目コード</th>
						<th class="table_normal_tag">回数</th>
						<th class="table_normal_tag">点数</th>
					</tr>
					<c:forEach items="${test}" var="test">
						<tr>
							<td>${test.subject_name}</td>
							<td>${test.subject_cd}</td>
							<td>${test.no}</td>
							<td>${test.point}</td>
							
						</tr>	
					</c:forEach>
				</table>
			</c:when>
		</c:choose>	
	</div>
	
</div>


<%@include file="../footer.jsp"  %>