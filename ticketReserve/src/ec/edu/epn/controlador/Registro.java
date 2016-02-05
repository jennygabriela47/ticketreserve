package ec.edu.epn.controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.epn.modelo.dto.UsuarioDTO;
import ec.edu.epn.modelo.servicio.UsuarioServicio;

@WebServlet("/Registro")
public class Registro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Registro() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/jsp/formularioRegistro.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UsuarioDTO udto = new UsuarioDTO();
		
		udto.setNombre((String)request.getParameter("nombre"));
		udto.setApellido((String) request.getParameter("apellido"));
		udto.setCedula((String) request.getParameter("cedula"));
		udto.setCorreoelectronico((String) request.getParameter("direccion"));
		udto.setUsuario((String) request.getParameter("usuario"));
		udto.setContrasenia((String) request.getParameter("psw"));
		
		UsuarioServicio us = new UsuarioServicio();
		us.registrarUsuario(udto);
		
		RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/jsp/formularioRegistro.jsp");
		rd.forward(request, response);
	}

}
