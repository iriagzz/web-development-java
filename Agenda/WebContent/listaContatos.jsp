<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>     
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Contatos</title>
</head>
<body>
	<fieldset align=center>
	<table border="1" cellpadding="5">
              <tr>
                  <th>Nome</th>
                  <th>E-mail</th>
                  <th>Telefone</th>
                  <th>Endereço</th>
                  <th>Senha</th>
              </tr>
              <c:forEach var="contato" items="${contatos}">
                  <tr>
                      <td><c:out value="${contato.nome}" /></td>
                      <td><c:out value="${contato.email}" /></td>
                      <td><c:out value="${contato.telefone}" /></td>
                      <td><c:out value="${contato.endereco}" /></td>
                      <td><c:out value="${contato.senha}" /></td>
                  </tr>
              </c:forEach>
          </table>
	
		</br>
		<a href="cadastroContato.jsp">Cadastrar Novo</a>
		<a style="color:red; margin:10px" href="menu.jsp">Voltar</a></br>
	</fieldset>
</body>
</html>