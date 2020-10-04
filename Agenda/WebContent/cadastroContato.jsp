<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Cadastro Contato</title>
</head>
<body>
	<div class="container">
		<fieldset>
			<form action="CadastroContatoServlet" method="POST">
			
			<label for="labelNome">Nome: </label>  
			<input name="nome" id="nome" type=text></br>
			<label for="labelEmail">E-mail: </label>
			<input name="email" id="email" type="text"></br>
			<label for="labelSenha">Senha: </label>
			<input name="senha" id="endereco" type="text"></br>
			<label for="labelTel">Telefone: </label>
			<input name="telefone" id="telefone" type="text"></br>
			<label for="labelEnd">Endreço: </label>
			<input name="endereco" id="endereco" type="text"></br>
			
			</br>
			<input type="submit" class="btn btn-primary" value="Cadastrar" style="width:10%; margin:5px">
			<input type="submit" class="btn btn-danger" value="Sair" style="width:10%; margin:5px" formAction="login.jsp">
			</form>
			
		</fieldset>
	</div>
</body>
</html>