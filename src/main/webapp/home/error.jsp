<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header_error.jsp"  %>
<%@include file="menu.jsp" %>


<div id="contents">

	<div class="error_title">
		<p class="error_log">${error_text}</p>
		<p class="error_explanation">上記の機能でエラーが発生しました。</p>
		
		<div class="fun_area">
			<p class="complaint_text">何について調べますか？</p>
			<input type="text" class="complaint_area">
		</div>
	</div>
	<div class="error_hateful">
		<img src="../images/カイル素材.jpg" class="kairu_png">
	</div>

</div>










<%@include file="../footer_error.jsp"  %>