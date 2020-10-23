<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>ELEIÇÕES 2020</title>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="style.css">
<script type="text/javascript" src="js/jquery-3.5.1.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
	<div>	
			
	</div>
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
					<button class="verde" id="btnVotar">CONFIRMA</button>
				</div>
				<div>
					<button class="cadastrar  click"
						onclick="window.location.href='salvarCandidato?acao=listartodos'">CADASTRAR</button>
				</div>
			</div>
		</div>	
		<button onclick="window.location.href='resultado.jsp'">Resultado</button>	
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

		$( "#btnVotar" ).click(function() {
			
			const valor1 = parseInt($("#campo1").val());
			const valor2 = parseInt($("#campo2").val());
			const numeroCandidato = (valor1 * 10) + valor2;

			$.ajax({
				url: "/eleicao/consultaCandidato?numeroCandidato=" + numeroCandidato,
				type : "GET",
				success: function(nomeDoCandidato){
					if (nomeDoCandidato !== "") {
						alert("Candidato: " + nomeDoCandidato);
						document.getElementById("campo1").value = "";
						document.getElementById("campo2").value = "";
						let votos = 0;
						if (sessionStorage.getItem(nomeDoCandidato) !== null) {
							votos = parseInt(sessionStorage.getItem(nomeDoCandidato)) + 1;
							sessionStorage.setItem(nomeDoCandidato, votos);
						} else {
							sessionStorage.setItem(nomeDoCandidato, 1);
						}
					} else {
						alert("Candidato nao existe");
					}
				},
				error:  function(data, status, er){
					alert(data+"_"+status+"_"+er);
				}
			});
		});
	</script>
</body>
</html>


