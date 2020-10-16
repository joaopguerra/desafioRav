<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Cadastro de Candidato</title>
</head>
<body>
	
	<h2>Cadastro de Candidato</h2>
	
	<form action="salvarCandidato" method="post" id="formCandidato">
		<table>
			<tr>
				<td>Id:</td>
				<td><input type="text" readonly="readonly" id="id"></td>
			</tr>
			<tr>
				<td>Nome:</td>
				<td><input type="text" id="nome"></td>
			</tr>
			<tr>
				<td>Número:</td>
				<td><input type="number" id="numero"></td>
			</tr>
		</table>
		<button type="submit">Cadastrar</button>
	</form>
	<br>
	<div class="container">
		<table class="responsive-table">
			<caption>Usuários cadastrados</caption>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Numero</th>
			</tr>
			<c:forEach items="${candidatos}" var="candidatos">
				<tr>
					<td>${candidatos.id}</td>
					<td>${candidatos.nome}</td>
					<td>${candidatos.numero}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>