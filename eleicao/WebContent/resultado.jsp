<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>RESULTADO</title>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="style.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
	<button onclick="resultado()">Resultado</button>
	<p id="resultado"></p>
	<a href="index.jsp">Voltar</a>
</body>
<script>
	function resultado() {
		document.getElementById("resultado").innerHTML = ""
		for (i = 0; i < 100; i++) {
			if (sessionStorage.getItem(i) !== null) {
				//alert(i);
				document.getElementById("resultado").innerHTML += "Candidato "
						+ i + " tem " + sessionStorage.getItem(i)
						+ " votos<br/>";
			}
		}
	}
</script>
</html>


