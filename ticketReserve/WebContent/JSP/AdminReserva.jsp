<%@page import="ec.edu.epn.modelo.dto.BoletoDTO"%>
<%@page import="ec.edu.epn.modelo.dto.EventoDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ec.edu.epn.modelo.dto.UsuarioDTO"%>
<%@page import="ec.edu.epn.modelo.dto.ReservaDTO"%>
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
<title>Reservas</title>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	<br/>
	
	<table  class="table">
	
		<tr>
		<th>Usuario</th><th>Evento</th><th>Fecha Reservación</th><th>Número de Boletos</th>
		</tr>
		<br/>
		<% List<ReservaDTO> reservas = new ArrayList<ReservaDTO>();
		List<UsuarioDTO> usuarios = new ArrayList<UsuarioDTO>();
		List<EventoDTO> eventos = new ArrayList<EventoDTO>();
		List<BoletoDTO> boletos = new ArrayList<BoletoDTO>();
		reservas = (List<ReservaDTO>)request.getAttribute("reservas");
		usuarios = (List<UsuarioDTO>)request.getAttribute("usuarios");
		eventos = (List<EventoDTO>)request.getAttribute("eventos");
		boletos = (List<BoletoDTO>)request.getAttribute("boletos");
		for (ReservaDTO reserva: reservas){%>
		<tr>		
		<%for(UsuarioDTO usuario:usuarios){
			if(String.valueOf(usuario.getCodigousuario()).equals(String.valueOf(reserva.getCodigousuario()))){%>
		<td><%=usuario.getUsuario()%></td>
		<%}
		}
		for(BoletoDTO boleto:boletos){
			if(String.valueOf(reserva.getCodigoboleto()).equals(String.valueOf(boleto.getCodigoboleto()))){
				for(EventoDTO evento:eventos){
					if(String.valueOf(boleto.getCodigoevento()).equals(String.valueOf(evento.getCodigoevento()))){%>
						<td><%=evento.getNombreevento()%></td>
					<%}
				}
		}
		}%>				
		<td><%=reserva.getFechareserva()%></td>
		<td><%=reserva.getCantidadboletoreservada()%></td>
		<td>
		<form method="post" action="EliminarReserva">
		<input type="hidden" name="idReserva" value="<%=reserva.getCodigoreserva()%>"/>
		<input type="submit" value="Eliminar"/>
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