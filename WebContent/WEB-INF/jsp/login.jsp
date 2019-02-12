<html>
<head>
</head>
<body>
	<h2>Login</h2>
	<form action="j_spring_security_check" method="post">
		User name : <input type="text" name="j_username"><br />
		Password : <input type="password" name="j_password"><br /> 
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<button type="submit" value="login" name="login">login</button>
	</form>
</body>
</html>