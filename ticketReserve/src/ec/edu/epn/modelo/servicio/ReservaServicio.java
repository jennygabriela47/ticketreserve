package ec.edu.epn.modelo.servicio;

import java.math.BigDecimal;



import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import ec.edu.epn.modelo.dto.ReservaDTO;
import ec.edu.epn.modelo.jpa.Reserva;
@Path("ServicioReserva")
@Produces("application/json")
@Consumes("application/json")

public class ReservaServicio {
	
	public ReservaServicio(){
		
	}
	
	@GET
	@Path("realizarReserva/{codigousuario}/{codigoboleto}/{fechareserva}/{cantidadboletoreservada}")
	public void realizarReserva(@PathParam ("codigousuario") BigDecimal codigousuario, @PathParam ("codigoboleto") BigDecimal codigoboleto, @PathParam ("fechareserva") String fechareserva , @PathParam ("cantidadboletoreservada") int cantidadboletoreservada) throws ParseException{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ticketReserve");
		EntityManager em = emf.createEntityManager();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.ENGLISH);
		Date date = format.parse(fechareserva);
		Reserva rjpa = new Reserva();
		int idres = this.lastIdReserva()+1;
		
		rjpa.setCodigoreserva(idres);
		rjpa.setCodigousuario(codigousuario);
		rjpa.setCodigoboleto(codigoboleto);
		rjpa.setFechareserva(date);
		rjpa.setCantidadboletoreservada(cantidadboletoreservada);
		
		System.out.println("ultimo id "+idres);
		
		em.getTransaction().begin();
		em.persist(rjpa);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
	
	public int lastIdReserva(){
		int idres = 0;
		List<Reserva> lrjpa = new ArrayList<Reserva>();
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ticketReserve");
		EntityManager em = emf.createEntityManager();
		
		Query query = (Query) em.createQuery("SELECT r FROM Reserva r ORDER BY r.codigoreserva ASC"); 
		
		lrjpa = (List<Reserva>) query.getResultList();
		
		for(Reserva rjpa:lrjpa){
			idres = (int) rjpa.getCodigoreserva();
		}
		
		em.close();
		emf.close();
		
		return idres;
	}
	
	@GET
	@Path("consultarReserva")
	public List<ReservaDTO> listReserva(){
		List<ReservaDTO> lrdto = new ArrayList<ReservaDTO>();
		List<Reserva> lrjpa = new ArrayList<Reserva>();
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ticketReserve");
		EntityManager em = emf.createEntityManager();
		
		Query query = (Query) em.createQuery("SELECT r FROM Reserva r ORDER BY r.codigoreserva ASC"); 
		
		lrjpa = (List<Reserva>) query.getResultList();
		
		for(Reserva rjpa:lrjpa){
			ReservaDTO rdto = new ReservaDTO();
			rdto.setCodigoreserva(rjpa.getCodigoreserva());
			rdto.setCodigousuario(rjpa.getCodigousuario());
			rdto.setCodigoboleto(rjpa.getCodigoboleto());
			rdto.setFechareserva(rjpa.getFechareserva());
			rdto.setCantidadboletoreservada(rjpa.getCantidadboletoreservada());
			lrdto.add(rdto);
		}
		
		em.close();
		emf.close();
		
		return lrdto;
	}
	@GET
	@Path("eliminarReserva/{idReserva}")
	public void eliminarReserva(@PathParam ("idReserva") long idReserva){		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ticketReserve");
		EntityManager em = emf.createEntityManager();
				
		Reserva rjpa = em.find(Reserva.class, idReserva);
		
		em.getTransaction().begin();
		em.remove(rjpa);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
}
