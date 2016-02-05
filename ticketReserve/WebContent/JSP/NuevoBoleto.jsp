<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimun-scale=1.0">
<link rel="stylesheet" href="../css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="../css/estilo.css" type="text/css">
<title>Nuevo Boleto</title>
</head>
<body>
<div>
	<table>
		<tr>
			<td>
				<img alt="" src="../IMG/ticketMaster.png">
			</td>
		</tr>		
	</table>
</div>


	<div align="center">
	<h1><b>Nuevo Boleto</b> </h1>
	<br>
	<br>
		<form>
			
				<table>
					<tr>
						<td class="td">Evento: 
						<td><select class="campoCombo">
												<option value="1">EV1</option>
												<option value="2">EV2</option>
												<option value="3">EV3</option>
											</select></td>	
											</td>
					</tr>
					<tr>
					</tr>
					<tr>
						<td class="td">Fecha: </td>
						<td class="td"><input type="text" name="fecha" class="campoTexto"></td>
					</tr>
					<tr>
						<td class="td">Hora: </td>
						<td class="td"><input type="text" name="fecha" class="campoTexto"></td>
					</tr>
					<tr>
						<td class="td">Ubicación: 
						<td><select class="campoCombo">
												<option value="1">U1</option>
												<option value="2">U2</option>
												<option value="3">U3</option>
											</select></td>	
											</td>
					</tr>
					<tr>
						<td class="td">Localidad: 
						<td><select class="campoCombo">
												<option value="1">GENERAL</option>
												<option value="2">BUTACA</option>
												<option value="3">VIP</option>
											</select></td>	
											</td>
					</tr>
					
					<tr>
						<td class="td">Precio: </td>
						<td class="td"><input type="text" name="fecha" class="campoTexto"></td>
					</tr>
					
					
					<tr align="center">
						<td colspan="2" class="td" >
							<button type="submit" class="boton">Ingresar</button>
						</td>
					
					</tr>
				</table>
			</form>		
	</div>
	<%@ include file="fooder.jsp" %>
</body>
</html>