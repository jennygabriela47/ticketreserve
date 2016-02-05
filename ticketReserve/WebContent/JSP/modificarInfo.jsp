<%@page import="ec.edu.epn.modelo.dto.UsuarioDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimun-scale=1.0">
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="css/estilo.css" type="text/css">
<title>Actualizar Datos</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div align="center">
		<form method="post" action="Actualizar">
			<%UsuarioDTO udto = (UsuarioDTO) hs.getAttribute("udto");%>
				<table>
					<tr>
						<td class="td">Nombres: </td>
						<td class="td"><input type="text" name="nombre" class="campoTexto" disabled value="<%=udto.getNombre()%>"></td>
					</tr>
					<tr>
						<td class="td">Apellidos: </td>
						<td class="td"><input type="text" name="apellido" class="campoTexto" disabled value="<%=udto.getApellido()%>"></td>
					</tr>
					<tr>
						<td class="td">Cédula: </td>
						<td class="td"><input type="text" name="cedula" class="campoTexto" disabled value="<%=udto.getCedula()%>"></td>
					</tr>
					<tr>
						<td class="td">Correo Electrónico: </td>
						<td class="td"><input type="text" name="direccion" class="campoTexto" disabled value="<%=udto.getCorreoelectronico()%>"></td>
					</tr>
					<tr>
						<td class="td">Usuario: </td>
						<td class="td"><input type="text" name="usuario" class="campoTexto" value="<%=udto.getUsuario()%>"></td>
					</tr>
					<tr>
						<td class="td">Contraseña: </td>
						<td class="td"><input type="password" name="psw" class="campoTexto"></td>
					</tr>
					<tr align="center">
						<td colspan="2" class="td" >
							<button type="submit" class="boton">Actualizar</button>
						</td>
					</tr>
				</table>
			</form>		
	</div>
	<%@ include file="fooder.jsp" %>
</body>
</html>