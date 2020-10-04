<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Contatos</title>
</head>
<body>

	<fieldset>
		<c:forEach items="${contatos}" var="contato">
			<c:out value="${contato.nome}"></c:out><br/>
		</c:forEach>
	</fieldset>
	
	
	<a href="cadastroContato.jsp">Cadastrar Novo</a>

</body>
</html>