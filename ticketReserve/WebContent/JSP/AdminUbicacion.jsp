<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimun-scale=1.0">
<link rel="stylesheet" href="../css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="../css/estilo.css" type="text/css">
<title>Ubicacion</title>
</head>
<body>

	<jsp:include page="headerAdmin.jsp"></jsp:include>
	<br/>
	
	<form action="listarInfracciones.jsp">
		<center>
		<input type="button" value="Nueva Ubicacion"/>
		</center>	
	</form>
	
	<table  class="table">
		<tr>
		<th>Nombre</th><th>Dirección</th><th>Ciudad</th><th>Capacidad Ubicación</th>
		</tr>
		<br/>
		<% for (int i=1;i<=10;i++){%>
		<tr>
		<td>Nom Ubicacion <%=i%></td><td>Dirección <%=i%></td><td>Ciudad .. <%=i%></td><td>Capacidad .. <%=i%></td><td><input type="submit" value="Eliminar"/></td>
		</tr>
		<%	
		}
		%>
	</table>
	
	<br/>
	<%@ include file="fooder.jsp" %>
	
</body>
</html>