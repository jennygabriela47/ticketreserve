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

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/jsp/login.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario = request.getParameter("usuario");
		String psw = request.getParameter("psw");
		
		UsuarioServicio us = new UsuarioServicio();
		boolean acceso = us.accesoLogin(usuario, psw);
		
		if(acceso){
			String idusr = String.valueOf(us.getIdUsuario(usuario));
			HttpSession hs = request.getSession();
			hs.setAttribute("idusr", idusr);
			UsuarioDTO udto = us.getUsuario(Integer.parseInt(idusr));
			hs.setAttribute("udto", udto);
		}
		
		RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/jsp/login.jsp");
		rd.forward(request, response);
	}
}
