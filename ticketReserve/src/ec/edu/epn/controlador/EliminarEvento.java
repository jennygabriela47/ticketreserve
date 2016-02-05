package ec.edu.epn.controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.epn.modelo.servicio.EventoServicio;
import ec.edu.epn.modelo.servicio.ReservaServicio;

@WebServlet("/EliminarEvento")
public class EliminarEvento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EliminarEvento() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idEventoStr = request.getParameter("idEvento");
		int idEventoInt = Integer.parseInt(idEventoStr);
		
		EventoServicio es = new EventoServicio();
		es.eliminarEvento(idEventoInt);
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/home.jsp");
		rd.forward(request, response);
	}

}
