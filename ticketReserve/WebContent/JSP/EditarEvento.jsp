<%@page import="java.text.SimpleDateFormat"%>
<%@page import="ec.edu.epn.modelo.dto.UbicacionDTO"%>
<%@page import="java.util.List"%>
<%@page import="ec.edu.epn.modelo.dto.EventoDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimun-scale=1.0">
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="css/estilo.css" type="text/css">
<title>Editar Evento</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<br/>
	
	<div align="center">
	<h1><b>Evento</b></h1>
	<br>
	<br>
		<form method="post" action="NuevoEvento">
		<%EventoDTO evento = (EventoDTO) request.getAttribute("evento"); 
		List<UbicacionDTO> ubicaciones = (List<UbicacionDTO>) request.getAttribute("ubicaciones");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");%>			
				<table>
					<tr>
						<td class="td">Nombre: </td>
						<td class="td"><input type="text" name="nombre" class="campoTexto" value="<%=evento.getNombreevento()%>"></td>
					</tr>
					<tr>
						<td class="td">Descripción: </td>
						<td class="td"><textarea name="message" rows="3" cols="50" class="campoTexto"><%=evento.getDescripcionevento()%></textarea></td>
					</tr>
					<tr>
						<td class="td">Fecha: </td>
						<td class="td"><input type="date" name="fecha" class="campoTexto"></td>
					</tr>
					<tr>
						<td class="td">Hora: </td>
						<td class="td"><input type="time" name="hora" class="campoTexto"></td>
					</tr>
					<tr>
						<td class="td">Ubicación: </td>
						<td class="td">
							<select name="ubicacion" class="campoCombo">
							<%for(UbicacionDTO ubicacion:ubicaciones){%>
								<option value="<%=ubicacion.getCodigoubicacion()%>"><%=ubicacion.getNombreubicacion() +" - "+ ubicacion.getCiudadubicacion()%></option>
							<%}%>
							</select>												
						</td>						
					</tr>
					
					<tr align="center">
						<td colspan="2" class="td" >
							<input type="hidden" name="idEvento" value="<%=evento.getCodigoevento()%>"/>
							<button type="submit" class="boton">Cambiar</button>
						</td>
					
					</tr>
				</table>
			</form>		
	</div>
	<%@ include file="fooder.jsp" %>
</body>
</html>