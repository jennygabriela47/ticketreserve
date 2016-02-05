<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimun-scale=1.0">
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="css/estilo.css" type="text/css">
<title>Registro</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div align="center">
		<form method="post" action="Registro">
			
				<table>
					<tr>
						<td class="td">Nombres: </td>
						<td class="td"><input type="text" name="nombre" class="campoTexto"></td>
					</tr>
					<tr>
						<td class="td">Apellidos: </td>
						<td class="td"><input type="text" name="apellido" class="campoTexto"></td>
					</tr>
					<tr>
						<td class="td">C�dula: </td>
						<td class="td"><input type="text" name="cedula" class="campoTexto"></td>
					</tr>
					<tr>
						<td class="td">Correo Electr�nico: </td>
						<td class="td"><input type="text" name="direccion" class="campoTexto"></td>
					</tr>
					<tr>
						<td class="td">Usuario: </td>
						<td class="td"><input type="text" name="usuario" class="campoTexto"></td>
					</tr>
					<tr>
						<td class="td">Contrase�a: </td>
						<td class="td"><input type="password" name="psw" class="campoTexto"></td>
					</tr>
					<tr align="center">
						<td colspan="2" class="td" >
							<button type="submit" class="boton">Registrarse</button>
						</td>
					</tr>
				</table>
			</form>		
	</div>
	<%@ include file="fooder.jsp" %>
</body>
</html>