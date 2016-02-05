<%@page import="ec.edu.epn.modelo.dto.BoletoDTO"%>
<%@page import="ec.edu.epn.modelo.dto.LocalidadDTO"%>
<%@page import="ec.edu.epn.modelo.dto.UbicacionDTO"%>
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
<title>Reservar Ticket</title>
</head>
<body>

	<%@ include file="header.jsp"%>
	<%EventoDTO edto = (EventoDTO) request.getAttribute("evento");
	UbicacionDTO udto = (UbicacionDTO) request.getAttribute("ubicacion");
	List<BoletoDTO> lbdto = (List<BoletoDTO>) request.getAttribute("boletos");
	List<LocalidadDTO> lldto = (List<LocalidadDTO>) request.getAttribute("localidades");%>
	
	<div align="center">
		<table>
			<tr>
				<td class="td">
					<table>
						<tr>
							<td class="td">
								<img alt="" src="IMG/1.jpg">
							</td>
						</tr>
					</table>
				</td>
				<td class="td">
					<table>
						<tr>
							<td class="td"></td>
							<td class="td">
							<form method="post" action="RealizarReserva">
								<table>
									<tr>
										<td colspan="2" align="center" class="td"><h1><%=edto.getNombreevento()%></h1></td>
									</tr>
									<tr>
										<td class="td">Fecha: </td>
										<td class="td"><%=edto.getFechaevento()%></td>
									</tr>
									<tr>
										<td class="td">Lugar: </td>
										<td class="td"><%=udto.getNombreubicacion()%></td>
									</tr>
									<tr>
										<td class="td">Cantidad: </td>
										<td class="td"><input name="cantidad" type="number" min="1"/></td>
									</tr>
									<tr>
										<td class="td">Tipo de entrada: </td>
										<td class="td">
											<select name="tipoboleto" class="campoCombo">
											<%for(LocalidadDTO localidadDTO:lldto){
												for(BoletoDTO boletoDTO:lbdto){
													if(String.valueOf(boletoDTO.getCodigolocalidad()).equals(String.valueOf(localidadDTO.getCodigolocalidad()))){%>
												<option value="<%=boletoDTO.getCodigoboleto()%>"><%=localidadDTO.getNombrelocalidad() +" - "+ boletoDTO.getPrecioboleto()%></option>
												<%}
												}
												}%>
											</select>												
										</td>																		
									</tr>										
									<tr>
										<td colspan="2" align="center" class="td">											
											<input type="submit" value="Continuar" class="boton"/>
											
										</td>
									</tr>
								</table>
							</form>																
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>
	<%@ include file="fooder.jsp" %>
	<script language="Javascript" type="text/javascript" src="../js/jQuery.js"></script>
	<script language="Javascript" type="text/javascript" src="../js/bootstrap.min.js"></script>
</body>
</html>