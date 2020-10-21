<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="cadastro.css">
<title>Cadastro de Candidato</title>
</head>
<body>
	<div class="container">
		<div class="wrapper">
			<h2>Cadastro de Candidato</h2>
			<form action="salvarCandidato" method="post">
				<table class="datatable">
					<tr>
						<td>Id:</td>
						<td><input type="text" readonly="readonly" id="id" name="id" value="${candidato.id}"></td>
					</tr>
					<tr>
						<td>Nome:</td>
						<td><input type="text" id="nome" name="nome" value="${candidato.nome}"></td>
					</tr>
					<tr>
						<td>Número:</td>
						<td><input type="number" id="numero" name="numero" value="${candidato.numero}"></td>
					</tr>
				</table>
				<button type="submit">Salvar</button>
				<button type="button" onclick="window.location.href='index.jsp'">Voltar</button>
			</form>
			<div class="presentation-data">
				<table class="tabela">
					<caption>Usuários cadastrados</caption>
					<tr  class="datatable-head">
						<th>Id</th>
						<th>Nome</th>
						<th>Numero</th>
					</tr>
					<c:forEach items="${candidatos}" var="candidato">
						<tr>
							<td>${candidato.id}</td>
							<td>${candidato.nome}</td>
							<td>${candidato.numero}</td>
							<td><a href="salvarCandidato?acao=update&id=${candidato.id}">Editar</a></td>
							<td><a href="salvarCandidato?acao=delete&nome=${candidato.nome}">Deletar</a></td>
						</tr>						
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>