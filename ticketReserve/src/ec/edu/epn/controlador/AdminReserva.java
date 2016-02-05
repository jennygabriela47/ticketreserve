package ec.edu.epn.controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.epn.modelo.dto.BoletoDTO;
import ec.edu.epn.modelo.dto.EventoDTO;
import ec.edu.epn.modelo.dto.ReservaDTO;
import ec.edu.epn.modelo.dto.UsuarioDTO;
import ec.edu.epn.modelo.servicio.EventoServicio;
import ec.edu.epn.modelo.servicio.ReservaServicio;
import ec.edu.epn.modelo.servicio.UsuarioServicio;

@WebServlet("/AdminReserva")
public class AdminReserva extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminReserva() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		List<EventoDTO> eventos = new ArrayList<EventoDTO>();
		List<ReservaDTO> reservas = new ArrayList<ReservaDTO>();
		List<UsuarioDTO> usuarios = new ArrayList<UsuarioDTO>();
		List<BoletoDTO> boletos = new ArrayList<BoletoDTO>();
		
		EventoServicio es = new EventoServicio();
		ReservaServicio rs = new ReservaServicio();
		UsuarioServicio us = new UsuarioServicio();
		
		eventos = es.listaEvento();
		reservas = rs.listReserva();
		usuarios = us.listUsuario();
		boletos = es.listaBoletoTotal();
		
		request.setAttribute("eventos", eventos);
		request.setAttribute("reservas", reservas);
		request.setAttribute("usuarios", usuarios);
		request.setAttribute("boletos", boletos);
		
		RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/jsp/AdminReserva.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

}
