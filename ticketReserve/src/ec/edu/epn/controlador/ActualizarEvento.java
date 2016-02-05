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

@WebServlet("/ActualizarEvento")
public class ActualizarEvento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ActualizarEvento() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/jsp/EditarEvento.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idEventoStr = request.getParameter("idEvento");		
		List<UbicacionDTO> lubidto = new ArrayList<UbicacionDTO>();
		
		EventoDTO edto = new EventoDTO();		
		EventoServicio es = new EventoServicio();
		
		edto.setNombreevento("");
		edto.setDescripcionevento("");
		if(idEventoStr != null && !idEventoStr.equals("")){
			int idEventoInt = Integer.parseInt(idEventoStr);
			edto = es.getEvento(idEventoInt);
		}		
		lubidto = es.listaUbicacion();
		
		request.setAttribute("evento", edto);
		request.setAttribute("ubicaciones", lubidto);
		
		RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/jsp/EditarEvento.jsp");
		rd.forward(request, response);
	}

}
