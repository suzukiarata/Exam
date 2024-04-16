<%@page contentType="text/html; charset=UTF-8" %>

<div id="contents">
	<form action="Login.action" method="post">
	
	<p>${login_error}<p>
	<!DOCTYPE html> 

<html> 

<head> 

  <title>Password Input and Submission Example</title> 

  <script> 

    function maskPassword() { 

      var passwordInput = document.getElementById("password"); 

      var maskedPassword = document.getElementById("maskedPassword"); 

  

      // パスワードの値を取得し、同じ長さのマスク文字列で置き換える 

      maskedPassword.value = "*".repeat(passwordInput.value.length); 

    } 

  

    function togglePasswordVisibility() { 

      var passwordInput = document.getElementById("password"); 

      var checkBox = document.getElementById("showPassword"); 

  

      // チェックボックスの状態に応じてパスワード表示フィールドのタイプを変更する 

      passwordInput.type = checkBox.checked ? "text" : "password"; 

    } 

  

    function submitForm() { 

      var passwordInput = document.getElementById("password").value; 

  

      // サーバーにパスワードを送信する（ここでは単純にコンソールに出力） 

      console.log("Password submitted: " + passwordInput); 

  

      // ここでフォームを送信するか、必要な処理を実行する 

    } 

  </script> 
  <meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="../css/style.css">
</head> 

<body> 

  <form onsubmit="submitForm(); return false;"> 
    <label for="id">ID:</label>
    <input type="text"required="required" name="id"> 

    <br> 
    <label for="Password">Password:</label> 
    <input type="password" id="password" oninput="maskPassword()" name="password" required> 
    
    <br>
    <input type="checkbox" id="showPassword" onchange="togglePasswordVisibility()"> 

    <label for="showPassword">パスワードを表示</label> 

    <br> 

    <button type="submit">ログイン</button> 

  </form> 

</body> 

</html>

	
	</form>
</div>

<%@include file="../footer.jsp"  %>


