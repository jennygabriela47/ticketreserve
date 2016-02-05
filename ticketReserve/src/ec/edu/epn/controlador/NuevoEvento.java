package ec.edu.epn.controlador;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.persistence.jpa.jpql.parser.DateTime;

import ec.edu.epn.modelo.dto.EventoDTO;
import ec.edu.epn.modelo.servicio.EventoServicio;

@WebServlet("/NuevoEvento")
public class NuevoEvento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NuevoEvento() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/AdminEvento");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String idEventoStr = request.getParameter("idEvento");
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("message");
		String fecha = request.getParameter("fecha");
		String hora = request.getParameter("hora");
		String idUbicacion = request.getParameter("ubicacion");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date date = new Date();
		try {
			date = sdf.parse(fecha+" "+hora);
		} catch (ParseException e) {
			
		}
		
		EventoServicio es = new EventoServicio();
		
		EventoDTO edto = new EventoDTO();
		edto.setCodigoubicacion(new BigDecimal(idUbicacion));
		edto.setNombreevento(nombre);
		edto.setDescripcionevento(descripcion);
		edto.setFechaevento(date);
		edto.setHoraevento(date);
		
		if(idEventoStr.equals("0")){
			es.registrarEvento(edto);
		}
		else{				
			int idEventoInt = Integer.parseInt(idEventoStr);
			edto.setCodigoevento(idEventoInt);
			es.actualizarEvento(edto);
		}
		
		RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/AdminEvento");
		rd.forward(request, response);
	}

}
