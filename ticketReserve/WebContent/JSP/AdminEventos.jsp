<%@page import="ec.edu.epn.modelo.dto.UbicacionDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ec.edu.epn.modelo.dto.EventoDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimun-scale=1.0">
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="css/estilo.css" type="text/css">
<title>Eventos</title>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	<br/>
	
	<form method="post" action="ActualizarEvento">
	<div align="center">
		<input type="submit" value="Nuevo Evento"/>
	</div>
	</form>
	
	<table  class="table">
		<tr>
		<th>Nombre</th><th>Descripcion</th><th>Fecha</th><th>Ubicación</th>
		</tr>
		<br/>
		<% List<EventoDTO> eventos = new ArrayList<EventoDTO>();
		List<UbicacionDTO> ubicaciones = new ArrayList<UbicacionDTO>();
		eventos = (List<EventoDTO>) request.getAttribute("eventos");
		ubicaciones = (List<UbicacionDTO>) request.getAttribute("ubicaciones");
		for (EventoDTO evento:eventos){%>
		<tr>
		<td><%=evento.getNombreevento()%></td><td><%=evento.getDescripcionevento()%></td><td><%=evento.getFechaevento()%></td>
		<% for (UbicacionDTO ubicacion: ubicaciones){
		if(String.valueOf(evento.getCodigoubicacion()).equals(String.valueOf(ubicacion.getCodigoubicacion()))){%>
		<td><%=ubicacion.getNombreubicacion()%></td>
		<% }
		}%>
		<td>
		<form method="post" action="ActualizarEvento">
		<input type="hidden" name="idEvento" value="<%=evento.getCodigoevento()%>"/>
		<input type="submit" value="Seleccionar"/>
		</form>
		</td>
		<td>
		<form method="post" action="EliminarEvento">
		<input type="hidden" name="idEvento" value="<%=evento.getCodigoevento()%>"/>
		<td><input type="submit" value="Eliminar"/></td>
		</form>	
		</td>	
		</tr>
		<%	
		}
		%>
	</table>
	
	<br/>
	<%@ include file="fooder.jsp" %>
	
</body>
</html>