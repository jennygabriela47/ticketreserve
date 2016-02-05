<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimun-scale=1.0">
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="css/estilo.css" type="text/css">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<form method="post" action="Login" >
		<div id="login" align="center">
			<table>
				<tr>
					<td colspan="2" align="center" class="sesion">
						<h1>Inicio de Sesión</h1>
						<hr>
						<br>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center" class="td">
						<img alt="" src="IMG/Apps-Computer-Login-icon.png">
					</td>
				</tr>
				<tr>
					<td class="td">
						<label>Usuario: </label>
					</td>
					<td class="td">
						<input type="text" name="usuario" class="campoTexto">
					</td>					
				</tr>
				<tr>
					<td class="td">
						<label>Contraseña: </label>
					</td>
					<td class="td">
						<input type="password" name="psw" class="campoTexto">
					</td>
				</tr>
				<tr align="center">
					<td colspan="2" class="td">
						<input type="submit" value="Ingresar" class="boton">
					</td>
				</tr>		
			</table>
		</div>
	</form>
	<%@ include file="fooder.jsp" %>
</body>
</html>