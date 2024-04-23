<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.jsp"  %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@include file="../home/menu.jsp" %>

<div id="contents">
	<h1 class="function_title">成績一覧（統計）</h1>
	
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
			<p class="exception_message">${none_statistics}</p>
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
		</form>
	</div>
	<div>
		<c:choose>
			<c:when test="${test == null}">
				<p class="number_of_data">成績情報が存在しません</p>
			</c:when>
			<c:when test="${test != null}">	
				<c:forEach items="${subject}" var="subject">
					<c:choose>
						<c:when test="${subject.cd == test.subject_cd}">
							<p class="number_of_data">科目:${subject.name}(${no}回目)</p>
						</c:when>
					</c:choose>
				</c:forEach>
				<table class="grades_infomation">
					<tr>
						<th colspan="2" class="table_normal_tag">最高得点</th>
						<th colspan="2" class="table_normal_tag">最低得点</th>
						<th colspan="2" class="table_normal_tag">平均点</th>
					</tr>
					<tr>
						<td colspan="2">${test.maxpoint}</td>
						<td colspan="2">${test.minpoint}</td>
						<td colspan="2">${test.avgpoint}</td>
					</tr>
					<tr>
						<th colspan="6" class="table_normal_tag">最高得点者</th>
					</tr>
					<tr>
						<td colspan="2">学生番号</td>
						<td colspan="2">氏名</td>
						<td>入学年度</td>
						<td>クラス</td>
					</tr>
					<c:forEach  items="${tmax}" var="max">
						<tr>
							<td colspan="2">${max.student_no}</td>
							<td colspan="2">${max.name}</td>
							<td>${max.ent_year}</td>
							<td>${max.class_num}</td>
						</tr>
					</c:forEach>
					<tr>
						<th colspan="6" class="table_normal_tag">最低得点者</th>
					</tr>
					<tr>
						<td colspan="2">学生番号</td>
						<td colspan="2">氏名</td>
						<td>入学年度</td>
						<td>クラス</td>
					</tr>
					<c:forEach items="${tmin}" var="min">
						<tr>
							<td colspan="2">${min.student_no}</td>
							<td colspan="2">${min.name}</td>
							<td>${min.ent_year}</td>
							<td>${min.class_num}</td>
						</tr>
					</c:forEach>
				</table>
			</c:when>
		</c:choose>	
	</div>
	
</div>


<%@include file="../footer.jsp"  %>