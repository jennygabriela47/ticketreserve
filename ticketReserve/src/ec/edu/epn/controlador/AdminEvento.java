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

import ec.edu.epn.modelo.dto.EventoDTO;
import ec.edu.epn.modelo.dto.UbicacionDTO;
import ec.edu.epn.modelo.servicio.EventoServicio;

@WebServlet("/AdminEvento")
public class AdminEvento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminEvento() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<EventoDTO> eventos = new ArrayList<EventoDTO>();
		List<UbicacionDTO> ubicaciones = new ArrayList<UbicacionDTO>();
		EventoServicio es = new EventoServicio();
		
		eventos = es.listaEvento();
		ubicaciones = es.listaUbicacion();
		
		request.setAttribute("eventos", eventos);
		request.setAttribute("ubicaciones", ubicaciones);
		
		RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/jsp/AdminEventos.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<EventoDTO> eventos = new ArrayList<EventoDTO>();
		List<UbicacionDTO> ubicaciones = new ArrayList<UbicacionDTO>();
		EventoServicio es = new EventoServicio();
		
		eventos = es.listaEvento();
		ubicaciones = es.listaUbicacion();
		
		request.setAttribute("eventos", eventos);
		request.setAttribute("ubicaciones", ubicaciones);
		
		RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/jsp/AdminEventos.jsp");
		rd.forward(request, response);
	}

}
