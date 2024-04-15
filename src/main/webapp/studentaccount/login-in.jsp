<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.jsp"  %>

<form action="Login.action" method="post">

<p>${login_error}<p>
<p>ID<input type="text"required="required" name="id" placeholder="Loginid"></p>
<form>
    <label for="password">パスワード：</label>
    <input type="password" required="required" name="password" placeholder="Password">
    <input type="submit" value="ログイン">

</form>

<%@include file="../footer.jsp"  %>


