package ec.edu.epn.controlador;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ec.edu.epn.modelo.dto.ReservaDTO;
import ec.edu.epn.modelo.servicio.ReservaServicio;

@WebServlet("/RealizarReserva")
public class RealizarReserva extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RealizarReserva() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReservaDTO rdto = new ReservaDTO();
		HttpSession hs = request.getSession();
		
		String idusr = (String) hs.getAttribute("idusr");
		
		rdto.setCodigousuario(new BigDecimal(idusr));
		rdto.setCodigoboleto(new BigDecimal(request.getParameter("tipoboleto")));
		rdto.setFechareserva(new Date());
		rdto.setCantidadboletoreservada(new Integer(request.getParameter("cantidad")));
		
		ReservaServicio rs = new ReservaServicio();
		rs.realizarReserva(rdto);
		
		RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/jsp/home.jsp");
		rd.forward(request, response);
	}

}
