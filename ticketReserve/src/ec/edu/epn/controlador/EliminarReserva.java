package ec.edu.epn.controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.epn.modelo.servicio.ReservaServicio;

@WebServlet("/EliminarReserva")
public class EliminarReserva extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EliminarReserva() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/Home");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String idReservaStr = request.getParameter("idReserva");
		long idReservaInt = Integer.parseInt(idReservaStr);
		
		ReservaServicio rs = new ReservaServicio();
		rs.eliminarReserva(idReservaInt);
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/home.jsp");
		rd.forward(request, response);
	}

}
