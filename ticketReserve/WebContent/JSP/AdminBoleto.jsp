<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimun-scale=1.0">
<link rel="stylesheet" href="../css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="../css/estilo.css" type="text/css">
<title>Boletos</title>
</head>
<body>

	<jsp:include page="headerAdmin.jsp"></jsp:include>
	<br/>
	
	<form action="listarInfracciones.jsp">
		<center>
		<input type="button" value="Nuevo Boleto"/>
		</center>	
	</form>
	
	<table  class="table">
		<tr>
		<th>Evento</th><th>Fecha</th><th>Hora</th><th>Ubicación</th><th>Localidad</th><th>Precio</th>
		
		</tr>
		<br/>
		<% for (int i=1;i<=10;i++){%>
		<tr>
		<td>Evento <%=i%></td><td>Fecha.. <%=i%></td><td>Hora .. <%=i%></td><td>Ubicacion.. <%=i%></td><td>Localidad <%=i%></td><td>Precio <%=i%></td><td><input type="submit" value="Eliminar"/></td>
		</tr>
		<%	
		}
		%>
	</table>
	
	<br/>
	<%@ include file="fooder.jsp" %>
	
</body>
</html>