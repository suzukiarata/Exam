<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.jsp"  %>

<form action="Login.action" method="post">
<p>${login_error}<p>
<p>ID<input type="text"required="required" name="id"></p>
<p>パスワード<input type="text"required="required" name="password"></p>
<p><input type="submit" value="ログイン"></p>
<p></p>
</form>

<%@include file="../footer.jsp"  %>

