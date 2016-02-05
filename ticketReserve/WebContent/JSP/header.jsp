<%@page import="ec.edu.epn.modelo.dto.UsuarioDTO"%>
<div>
	<table>
		<tr>
			<td>
				<a href="Home"><img alt="" src="IMG/ticketMaster.png"></a>
			</td>
		</tr>		
	</table>
</div>
<nav class="navbar navbar-default" role="navigation">
		<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#colapsar">
					<span class="sr-only">Inicio/Ocultar - Desplegar</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a href="Home" class="navbar-brand">Inicio</a>
		</div>
		<div class="collapse navbar-collapse" id="colapsar">
			<ul class="nav navbar-nav">
				<li><a href="ListarEvento">Eventos</a></li>
				<% HttpSession hs = request.getSession();
				String idusr = (String) hs.getAttribute("idusr");%>
				<%if(idusr == null){%>
				<li><a href="Registro">Crear una cuenta</a></li>
				<li><a href="Login">Iniciar Sesión</a></li>		
				<%}
				else{%>
				<li><a href="Actualizar">Actualizar datos</a></li>	
				<li><a href="Salir">Salir</a></li>						
				<%UsuarioDTO usrdto = (UsuarioDTO) hs.getAttribute("udto");
				String usr = usrdto.getUsuario();
				if(usr.equals("admin")){%>
				<li>___</li>
				<li><a href="AdminEvento">Administrar Eventos</a></li>
				<li><a href="AdminReserva">Administrar Reservas</a></li>
				<!--<li><a href="#">Administrar Localidades</a></li>-->
				<li>___</li>	
				<%}
				}%>	
			</ul>
		</div>
</nav>