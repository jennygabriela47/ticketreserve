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
import ec.edu.epn.modelo.dto.LocalidadDTO;
import ec.edu.epn.modelo.dto.UbicacionDTO;
import ec.edu.epn.modelo.servicio.EventoServicio;

@WebServlet("/Evento")
public class Evento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Evento() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/jsp/informacion.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EventoDTO edto = new EventoDTO();
		UbicacionDTO udto = new UbicacionDTO();
		EventoServicio es = new EventoServicio();		
		List<BoletoDTO> lbdto = new ArrayList<BoletoDTO>();
		List<LocalidadDTO> lldto = new ArrayList<LocalidadDTO>();
		
		String idEventoStr = request.getParameter("idEvento");
		int idEventoInt = Integer.parseInt(idEventoStr);		
		edto = es.getEvento(idEventoInt);
		
		String idUbicacionStr = String.valueOf(edto.getCodigoubicacion());
		int idUbicacionInt = Integer.parseInt(idUbicacionStr);
		udto = es.getUbicacion(idUbicacionInt);
		
		lbdto = es.listaBoleto(idEventoInt);
		lldto = es.listaLocalidad(idUbicacionInt);
		
		request.setAttribute("evento", edto);
		request.setAttribute("ubicacion", udto);
		request.setAttribute("boletos", lbdto);
		request.setAttribute("localidades", lldto);
		
		System.out.println(idEventoInt + " " + idUbicacionInt);
		
		RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/jsp/informacion.jsp");
		rd.forward(request, response);
	}

}
