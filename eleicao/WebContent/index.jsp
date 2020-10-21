<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>ELEIÇÕES 2020</title>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="style.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
	<div class="container">
		<div class="branco">		
			<div class="cinzaClaro">
				<p>Número:</p>
				<form action="">
					<input size="1" id="campo1" value="" maxlength="1" type="text"
						readonly="readonly" /> <input size="1" id="campo2" value=""
						maxlength="1" type="text" readonly="readonly" />
				</form>

			</div>
			<div class="cinzaEscuro">
				<b>JUSTIÇA<br>ELEITORAL
				</b>
			</div>
			<div class="preto">
				<button class="bnt click" onclick="inserir(1)">1</button>
				<button class="bnt click" onclick="inserir(2)">2</button>
				<button class="bnt click" onclick="inserir(3)">3</button>
				<button class="bnt click" onclick="inserir(4)">4</button>
				<button class="bnt click" onclick="inserir(5)">5</button>
				<button class="bnt click" onclick="inserir(6)">6</button>
				<button class="bnt click" onclick="inserir(7)">7</button>
				<button class="bnt click" onclick="inserir(8)">8</button>
				<button class="bnt click" onclick="inserir(9)">9</button>
				<button class="bnt click" onclick="inserir(0)">0</button>
				<div class="teclado2">
					<button class="branco  click">BRANCO</button>
					<button class="laranja  click" onclick="corrige()">CORRIGE</button>
					<button class="verde" onclick="votar()">CONFIRMA</button>
				</div>
				<div>
					<button class="cadastrar  click"
						onclick="window.location.href='salvarCandidato?acao=listartodos'">CADASTRAR</button>
				</div>
			</div>
		</div>
		<a href="resultado.jsp">Resultado</a>
	</div>
	<script>
		function inserir(valor) {
			var valor1 = document.getElementById("campo1").value;
			var valor2 = document.getElementById("campo2").value;

			if (valor1 == "") {
				document.getElementById("campo1").value = valor;
			} else if (valor2 == "") {
				document.getElementById("campo2").value = valor;
			}
		}

		function corrige() {
			document.getElementById("campo1").value = "";
			document.getElementById("campo2").value = "";
		}

		function votar() {

			var valor1 = parseInt(document.getElementById("campo1").value);
			var valor2 = parseInt(document.getElementById("campo2").value);
			var candidado = (valor1 * 10) + valor2;
			if (sessionStorage.getItem(candidado) !== null) {
				votos = parseInt(sessionStorage.getItem(candidado)) + 1;
				sessionStorage.setItem(candidado, votos);
				sessionStorage.setItem()
			} else {
				sessionStorage.setItem(candidado, 1);

			}
			alert("Confirmado voto no candidato " + candidado)
			document.getElementById("campo1").value = "";
			document.getElementById("campo2").value = "";
		}
	</script>
</body>
</html>


