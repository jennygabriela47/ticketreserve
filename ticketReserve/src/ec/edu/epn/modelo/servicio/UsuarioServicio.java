package ec.edu.epn.modelo.servicio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import ec.edu.epn.modelo.dto.UsuarioDTO;
import ec.edu.epn.modelo.jpa.Usuario;

@Path("ServicioUsuario")
@Produces("application/json")
@Consumes("application/json")
public class UsuarioServicio {

	public UsuarioServicio() {
		
	}

	@GET
	@Path("accesoLogin/{usr}/{psw}")
	public boolean accesoLogin(@PathParam ("usr") String usr, @PathParam ("psw") String psw){
		boolean acceso = false;
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ticketReserve");
		EntityManager em = emf.createEntityManager();
		
		Query query = (Query) em.createQuery("SELECT u FROM Usuario u WHERE u.usuario = :usr"); 
		query.setParameter("usr", usr);
		
		try{
			Usuario ujpa = (Usuario) query.getSingleResult();
			String usuario = ujpa.getUsuario();
			String pass = ujpa.getContrasenia();
			
			if(usuario.equals(usr) && pass.equals(psw)){
				acceso = true;
			}		
		}
		catch(Exception e){
			
		}
		
		em.close();
		emf.close();
		
		return acceso;
	}
	//ERRROORR
	@GET
	@Path("getIdUsuario/{codigousuario}")
	public int getIdUsuario(@PathParam ("codigousuario") int codigousuario){
		int idusr = 0;
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ticketReserve");
		EntityManager em = emf.createEntityManager();
		
		Query query = (Query) em.createQuery("SELECT u FROM Usuario u WHERE u.usuario = :codigousuario"); 
		query.setParameter("codigousuario", codigousuario);
		
		Usuario ujpa = (Usuario) query.getSingleResult();
		idusr = ujpa.getCodigousuario();
		
		em.close();
		emf.close();
		
		return idusr;
	}
	
	
		@GET
		@Path("getUsuario/{idusr}")
	public UsuarioDTO getUsuario(@PathParam ("idusr") int idusr){
		UsuarioDTO usrDto = new UsuarioDTO();
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ticketReserve");
		EntityManager em = emf.createEntityManager();
				
		Usuario ujpa = em.find(Usuario.class, idusr);
		usrDto.setNombre(ujpa.getNombre());
		usrDto.setApellido(ujpa.getApellido());
		usrDto.setCedula(ujpa.getCedula());
		usrDto.setCorreoelectronico(ujpa.getCorreoelectronico());
		usrDto.setUsuario(ujpa.getUsuario());
		usrDto.setContrasenia(ujpa.getContrasenia());
		
		em.close();
		emf.close();
		
		return usrDto;
	}
	
		@GET
		@Path("registrarUsuario/{nombre}/{apellido}/{cedula}/{correoelectronico}/{usuario}/{contrasenia}")
	public void registrarUsuario(@PathParam ("nombre") String nombre, @PathParam ("apellido") String apellido, @PathParam ("cedula") String cedula, @PathParam ("correoelectronico") String correoelectronico, @PathParam ("usuario") String usuario, @PathParam ("contrasenia") String contrasenia){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ticketReserve");
		EntityManager em = emf.createEntityManager();
		
		Usuario ujpa = new Usuario();
		
		ujpa.setNombre(nombre);
		ujpa.setApellido(apellido);
		ujpa.setCedula(cedula);
		ujpa.setCorreoelectronico(correoelectronico);
		ujpa.setUsuario(usuario);
		ujpa.setContrasenia(contrasenia);
		
		em.getTransaction().begin();
		em.persist(ujpa);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
		@GET
		@Path("actualizarUsuario/{codigousuario}/{usuario}/{contrasenia}")
	public void actualizarUsuario(@PathParam ("codigousuario") int codigousuario, @PathParam ("usuario") String usuario, @PathParam ("contrasenia") String contrasenia){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ticketReserve");
		EntityManager em = emf.createEntityManager();
				
		Usuario ujpa = em.find(Usuario.class, codigousuario);
		ujpa.setUsuario(usuario);
		ujpa.setContrasenia(contrasenia);
		
		em.getTransaction().begin();		
		em.merge(ujpa);		
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
	@GET
	@Path("listarUsuario")
	public List<UsuarioDTO> listUsuario(){
		List<UsuarioDTO> ludto = new ArrayList<UsuarioDTO>();
		List<Usuario> lujpa = new ArrayList<Usuario>();
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ticketReserve");
		EntityManager em = emf.createEntityManager();
		
		Query query = (Query) em.createQuery("SELECT u FROM Usuario u"); 
		
		lujpa = (List<Usuario>) query.getResultList();
		
		for(Usuario ujpa:lujpa){
			UsuarioDTO udto = new UsuarioDTO();
			
			udto.setCodigousuario(ujpa.getCodigousuario());
			udto.setNombre(ujpa.getNombre());
			udto.setApellido(ujpa.getApellido());
			udto.setCedula(ujpa.getCedula());
			udto.setCorreoelectronico(ujpa.getCorreoelectronico());
			udto.setUsuario(ujpa.getUsuario());
			udto.setContrasenia(ujpa.getContrasenia());
			
			ludto.add(udto);
		}
		
		em.close();
		emf.close();
		
		return ludto;
	}
}
