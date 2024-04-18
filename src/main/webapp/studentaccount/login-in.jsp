<%@page contentType="text/html; charset=UTF-8" %>


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
	<div id="contents">
		<h2 class="login-title">得点管理システム</h2>
		<form action="Login.action" method="post">
		
		<p>${login_error}<p>
		<div class="login-container">
	
				<h1 class="login-main">ログイン</h1>
			
		  <form onsubmit="submitForm(); return false;">
		  <div class="form-group"> 
			    <label for="id" class="login-label">ID:</label>
			    <input type="text"required="required" name="id" class="login-input"> 
		  </div>
		
		   <div class="form-group">
			    <label for="Password" class="login-label">Password:</label> 
			    <input  class="login-input" type="password" id="password" oninput="maskPassword()" name="password" required> 
		   </div>
		   
		   <div class="form-group">
			   <div class="login-p">
				    <input type="checkbox" id="showPassword" onchange="togglePasswordVisibility()" >
				    <label  for="showPassword">パスワードを表示</label> 
			   </div> 
		   </div>
		    	<button type="submit">ログイン</button> 
		
		  </form> 
		</div>
	</div>
	</body> 

</html>


<%@include file="../footer.jsp"  %>


