package ec.edu.epn.controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ec.edu.epn.modelo.dto.UsuarioDTO;
import ec.edu.epn.modelo.servicio.UsuarioServicio;

@WebServlet("/Actualizar")
public class Actualizar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Actualizar() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		HttpSession hs = request.getSession();
//		String idusr = (String) hs.getAttribute("idusr");
//		
//		UsuarioServicio us = new UsuarioServicio();
//		UsuarioDTO udto = us.getUsuario(Integer.parseInt(idusr));	
		
		RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/jsp/modificarInfo.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UsuarioDTO udto = new UsuarioDTO();
		HttpSession hs = request.getSession();
		String idusr = (String) hs.getAttribute("idusr");
		
		udto.setCodigousuario(Integer.parseInt(idusr));
		udto.setUsuario((String) request.getParameter("usuario"));
		udto.setContrasenia((String) request.getParameter("psw"));
		
		UsuarioServicio us = new UsuarioServicio();
		us.actualizarUsuario(udto);
		
		RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/jsp/modificarInfo.jsp");
		rd.forward(request, response);
	}

}
