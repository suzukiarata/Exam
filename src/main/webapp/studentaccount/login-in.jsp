<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.jsp"  %>

<form action="Login.action" method="post">
<p>ID<input type="text" name="id"></p>
<p>パスワード<input type="text" name="password"></p>
<p><input type="submit" value="ログイン"></p>
<p></p>
</form>

<%@include file="../footer.jsp"  %>