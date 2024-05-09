<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.jsp"  %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@include file="../home/menu.jsp" %>

<!-- 科目の成績一覧のページ -->
<div id="contents">
	<h1 class="function_title">成績一覧（科目）</h1>
	
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
				<input type="text"name="f4" required="required" class="reference_no" placeholder="学生番号を入力してください">
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
				<p class="none_message">学生情報が存在しません</p>
			</c:when>
			<c:when test="${fn:length(test) != 0 }">
			
				<c:forEach items="${subject}" var="subject">
					<c:choose>
						<c:when test="${subject.cd == subject_cd}">
							<p class="number_of_data">科目:${subject.name}</p>
						</c:when>
					</c:choose>
				</c:forEach>
				<table class="grades_infomation">
					<tr>
						<th class="table_normal_tag">入学年度</th>
						<th class="table_normal_tag">クラス</th>
						<th class="table_normal_tag">学生番号</th>
						<th class="table_normal_tag">氏名</th>
						<th class="table_normal_tag">1回</th>
						<th class="table_normal_tag">2回</th>
					</tr>
					<c:forEach items="${test}" var="test">
						<tr>
							<td>${test.ent_year}</td>
							<td>${test.class_num}</td>
							<td>${test.student_no}</td>
							<td>${test.name}</td>
							<c:choose>
								<c:when test="${fn:length(test.points) == 0 }">
									<td>-</td>
									<td>-</td>
								</c:when>
								<c:when test="${fn:length(test.points) == 1 }">
									<c:forEach items="${test.nos}" var="no">
										<c:choose>
											<c:when test="${no == 1}">
												<c:forEach items="${test.points}" var="point">
													<td>${point}</td>
												</c:forEach>
												<td>-</td>
											</c:when>
											<c:when test="${no == 2}">
												<td>-</td>
												<c:forEach items="${test.points}" var="point">
													<td>${point}</td>
												</c:forEach>
											</c:when>
										</c:choose>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<c:forEach items="${test.points}" var="point">
										<td>${point}</td>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</tr>	
					</c:forEach>
				</table>
			</c:when>
		</c:choose>	
	</div>
	
</div>


<%@include file="../footer.jsp"  %>