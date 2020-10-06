<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>welcome!</title>
</head>
<body>

	<div>

		<h1>MENU</h1>
		</br>
		
		<form action="CadastroContatoServlet" method="GET">
		<input type="submit" class="btn btn-dark" value="Cadastro Contato" style="width:15%; margin:5px" formAction="cadastroContato.jsp"></br>
		<input type="submit" class="btn btn-dark" value="Lista de Contatos" style="width:15%; margin:5px"></br>
		<input type="submit" class="btn btn-dark" value="Sair" style="width:15%; margin:5px" formAction="login.jsp">
		</form>
		
	</div>
</body>
</html>