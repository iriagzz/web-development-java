<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<div>
		<form id="form-agenda" action="Login" method="POST">
			<label for="login">Login: </label>
			<input type="text" name="login" id="login" required/></br>
			<label for="senha">Senha: </label>
			<input type="password" name="senha" id="senha" required/></br></br>
			<button type="submit" class="btn btn-primary">Entrar</button>		
		</form>
	</div>
	<div>
		</br></br>	
 		<p style="color:red"> ${erro} </p>
		</div>
		</p>
	</div>
</body>
</html>