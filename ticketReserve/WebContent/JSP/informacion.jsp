<%@page import="ec.edu.epn.modelo.dto.UbicacionDTO"%>
<%@page import="ec.edu.epn.modelo.dto.EventoDTO"%>
<%@page import="ec.edu.epn.modelo.dto.BoletoDTO"%>
<%@page import="ec.edu.epn.modelo.dto.LocalidadDTO"%>
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
	<div align= "center">
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
										<td class="td">Tipo de entrada: </td>
										<td class="td">
											<table>
											<%for(LocalidadDTO localidadDTO: lldto){%>
												<tr>
													<td><%=localidadDTO.getNombrelocalidad()%></td>
													<%for(BoletoDTO boletoDTO: lbdto){
													if(String.valueOf(boletoDTO.getCodigolocalidad()).equals(String.valueOf(localidadDTO.getCodigolocalidad()))){%>
													<td><%=boletoDTO.getPrecioboleto()%></td>
												</tr>
											<%}
											}
											}%>												
											</table>
											<!--<select class="campoCombo">
												<option value="general">General</option>
												<option value="preferencia">Preferencia</option>
												<option value="vip">VIP</option>
											</select>  -->												
										</td>																		
									</tr>										
									<tr>
										<td colspan="2" align="center" class="td">
											<%if(idusr != null){%>
											<form method="post" action="Reserva">
											<input type="hidden" name="idEvento" value="<%=edto.getCodigoevento()%>">
											<input type="hidden" name="idUbicacion" value="<%=udto.getCodigoubicacion()%>">
											<input type="submit" value="Reservar" class="boton"/>
											</form>		
											<%}
											else{
											%>	
											<font color="red">Inicie Sección para Reservar</font> 
											<%}%>								
										</td>
									</tr>
								</table>																
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>
	<%@ include file="fooder.jsp" %>
	<script language="Javascript" type="text/javascript" src="js/jQuery.js"></script>
	<script language="Javascript" type="text/javascript" src="js/bootstrap.min.js"></script>
</body>
</html>