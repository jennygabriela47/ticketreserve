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

import ec.edu.epn.modelo.dto.BoletoDTO;
import ec.edu.epn.modelo.dto.EventoDTO;
import ec.edu.epn.modelo.dto.LocalidadDTO;
import ec.edu.epn.modelo.dto.UbicacionDTO;
import ec.edu.epn.modelo.dto.UsuarioDTO;
import ec.edu.epn.modelo.jpa.Boleto;
import ec.edu.epn.modelo.jpa.Evento;
import ec.edu.epn.modelo.jpa.Localidad;
import ec.edu.epn.modelo.jpa.Reserva;
import ec.edu.epn.modelo.jpa.Ubicacion;
import ec.edu.epn.modelo.jpa.Usuario;


@Path("ServicioEvento")
@Produces("application/json")
@Consumes("application/json")

public class EventoServicio {
	
	public EventoServicio(){
		
	}
	
	
	@GET
	@Path("consultarEvento")
	public List<EventoDTO> listaEvento(){
		List<EventoDTO> eventosDTO = new ArrayList<EventoDTO>();
		List<Evento> eventosJPA = new ArrayList<Evento>();
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ticketReserve");
		EntityManager em = emf.createEntityManager();
		
		Query query = (Query) em.createQuery("SELECT e FROM Evento e");
		eventosJPA = query.getResultList();	
		
		for(Evento eventoJPA: eventosJPA){
			EventoDTO eventoDTO = new EventoDTO();
			
			eventoDTO.setCodigoevento(eventoJPA.getCodigoevento());
			eventoDTO.setCodigoubicacion(eventoJPA.getCodigoubicacion());
			eventoDTO.setNombreevento(eventoJPA.getNombreevento());
			eventoDTO.setDescripcionevento(eventoJPA.getDescripcionevento());
			eventoDTO.setFechaevento(eventoJPA.getFechaevento());
			eventoDTO.setHoraevento(eventoJPA.getHoraevento());
			eventoDTO.setImagen(eventoJPA.getImagen());
			
			eventosDTO.add(eventoDTO);
		}
		
		em.close();
		emf.close();
		
		return eventosDTO;
	}
	
	@GET
	@Path("buscarEvento/{nombreevento}")
	
	public List<EventoDTO> buscarEvento(@PathParam ("nombreevento")String nombreevento){
		List<EventoDTO> eventosDTO = new ArrayList<EventoDTO>();
		List<Evento> eventosJPA = new ArrayList<Evento>();
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ticketReserve");
		EntityManager em = emf.createEntityManager();
		
		Query query = (Query) em.createQuery("SELECT e FROM Evento e WHERE e.nombreevento LIKE :nombreevento");
		query.setParameter("nombreevento", '%'+nombreevento+'%');
		eventosJPA = query.getResultList();	
		
		for(Evento eventoJPA: eventosJPA){
			EventoDTO eventoDTO = new EventoDTO();
			
			eventoDTO.setCodigoevento(eventoJPA.getCodigoevento());
			eventoDTO.setCodigoubicacion(eventoJPA.getCodigoubicacion());
			eventoDTO.setNombreevento(eventoJPA.getNombreevento());
			eventoDTO.setDescripcionevento(eventoJPA.getDescripcionevento());
			eventoDTO.setFechaevento(eventoJPA.getFechaevento());
			eventoDTO.setHoraevento(eventoJPA.getHoraevento());
			eventoDTO.setImagen(eventoJPA.getImagen());
			
			eventosDTO.add(eventoDTO);
		}
		
		em.close();
		emf.close();
		
		return eventosDTO;
	}
	
	@GET
	@Path("getEvento/{idEvento}")
	
	public EventoDTO getEvento(@PathParam ("idEvento") int idEvento){
		EventoDTO eventoDTO = new EventoDTO();
		Evento eventoJPA = new Evento();
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ticketReserve");
		EntityManager em = emf.createEntityManager();
		
		Query query = (Query) em.createQuery("SELECT e FROM Evento e WHERE e.codigoevento = :idEvento");
		query.setParameter("idEvento", idEvento);
		eventoJPA = (Evento) query.getSingleResult();	
			
		eventoDTO.setCodigoevento(eventoJPA.getCodigoevento());
		eventoDTO.setCodigoubicacion(eventoJPA.getCodigoubicacion());
		eventoDTO.setNombreevento(eventoJPA.getNombreevento());
		eventoDTO.setDescripcionevento(eventoJPA.getDescripcionevento());
		eventoDTO.setFechaevento(eventoJPA.getFechaevento());
		eventoDTO.setHoraevento(eventoJPA.getHoraevento());
		eventoDTO.setImagen(eventoJPA.getImagen());
		
		em.close();
		emf.close();
		
		return eventoDTO;
	}
	@GET
	@Path("consultarUbicacion")
	public List<UbicacionDTO> listaUbicacion(){
		List<UbicacionDTO> ubicacionesDTO = new ArrayList<UbicacionDTO>();
		List<Ubicacion> ubicacionesJPA = new ArrayList<Ubicacion>();
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ticketReserve");
		EntityManager em = emf.createEntityManager();
		
		Query query = (Query) em.createQuery("SELECT u FROM Ubicacion u");
		ubicacionesJPA = query.getResultList();	
		
		for(Ubicacion ubicacionJPA: ubicacionesJPA){
			UbicacionDTO ubicacionDTO = new UbicacionDTO();
			
			ubicacionDTO.setCodigoubicacion(ubicacionJPA.getCodigoubicacion());
			ubicacionDTO.setNombreubicacion(ubicacionJPA.getNombreubicacion());
			ubicacionDTO.setDireccionubicacion(ubicacionJPA.getDireccionubicacion());
			ubicacionDTO.setCiudadubicacion(ubicacionJPA.getCiudadubicacion());
			ubicacionDTO.setCapacidadubicacion(ubicacionJPA.getCapacidadubicacion());
			
			ubicacionesDTO.add(ubicacionDTO);
		}
		
		em.close();
		emf.close();
		
		return ubicacionesDTO;
	}
	
	@GET
	@Path("getUbicacion/{idUbicacion}")
	
	
	public UbicacionDTO getUbicacion(@PathParam("idUbicacion") long idUbicacion){
		UbicacionDTO ubicacionDTO = new UbicacionDTO();
		Ubicacion ubicacionJPA = new Ubicacion();
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ticketReserve");
		EntityManager em = emf.createEntityManager();
		
		Query query = (Query) em.createQuery("SELECT u FROM Ubicacion u WHERE u.codigoubicacion = :idUbicacion");
		query.setParameter("idUbicacion", idUbicacion);
		ubicacionJPA = (Ubicacion) query.getSingleResult();	
			
		ubicacionDTO.setCodigoubicacion(ubicacionJPA.getCodigoubicacion());
		ubicacionDTO.setNombreubicacion(ubicacionJPA.getNombreubicacion());
		ubicacionDTO.setDireccionubicacion(ubicacionJPA.getDireccionubicacion());
		ubicacionDTO.setCiudadubicacion(ubicacionJPA.getCiudadubicacion());
		ubicacionDTO.setCapacidadubicacion(ubicacionJPA.getCapacidadubicacion());
			
		
		em.close();
		emf.close();
		
		return ubicacionDTO;
	}
	
	@GET
	@Path("listaBoleto/{idEvento}")
	
	public List<BoletoDTO> listaBoleto(@PathParam("idEvento") BigDecimal idEvento){
		List<BoletoDTO> boletosDTO = new ArrayList<BoletoDTO>();
		List<Boleto> boletosJPA = new ArrayList<Boleto>();
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ticketReserve");
		EntityManager em = emf.createEntityManager();
		
		Query query = (Query) em.createQuery("SELECT b FROM Boleto b WHERE b.codigoevento = :idEvento");
		query.setParameter("idEvento", idEvento);
		boletosJPA = query.getResultList();	
		
		for(Boleto boletoJPA: boletosJPA){
			BoletoDTO boletoDTO = new BoletoDTO();
			
			boletoDTO.setCodigoboleto(boletoJPA.getCodigoboleto());
			boletoDTO.setCodigoevento(boletoJPA.getCodigoevento());
			boletoDTO.setCodigolocalidad(boletoJPA.getCodigolocalidad());
			boletoDTO.setPrecioboleto(boletoJPA.getPrecioboleto());
						
			boletosDTO.add(boletoDTO);
		}
		
		em.close();
		emf.close();
		
		return boletosDTO;
	}
	@GET
	@Path("consultarBoleto")
	
	public List<BoletoDTO> listaBoletoTotal(){
		List<BoletoDTO> boletosDTO = new ArrayList<BoletoDTO>();
		List<Boleto> boletosJPA = new ArrayList<Boleto>();
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ticketReserve");
		EntityManager em = emf.createEntityManager();
		
		Query query = (Query) em.createQuery("SELECT b FROM Boleto b");
		boletosJPA = query.getResultList();	
		
		for(Boleto boletoJPA: boletosJPA){
			BoletoDTO boletoDTO = new BoletoDTO();
			
			boletoDTO.setCodigoboleto(boletoJPA.getCodigoboleto());
			boletoDTO.setCodigoevento(boletoJPA.getCodigoevento());
			boletoDTO.setCodigolocalidad(boletoJPA.getCodigolocalidad());
			boletoDTO.setPrecioboleto(boletoJPA.getPrecioboleto());
						
			boletosDTO.add(boletoDTO);
		}
		
		em.close();
		emf.close();
		
		return boletosDTO;
	}
	@GET
	@Path("listaLocalidad/{idUbicacion}")
	public List<LocalidadDTO> listaLocalidad(@PathParam ("idUbicacion") BigDecimal idUbicacion){
		List<LocalidadDTO> localidadesDTO = new ArrayList<LocalidadDTO>();
		List<Localidad> localidadesJPA = new ArrayList<Localidad>();
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ticketReserve");
		EntityManager em = emf.createEntityManager();
		
		Query query = (Query) em.createQuery("SELECT l FROM Localidad l WHERE l.codigoubicacion = :idUbicacion");
		query.setParameter("idUbicacion", idUbicacion);
		localidadesJPA = query.getResultList();	
		
		for(Localidad localidadJPA: localidadesJPA){
			LocalidadDTO localidadDTO = new LocalidadDTO();
			
			localidadDTO.setCodigolocalidad(localidadJPA.getCodigolocalidad());
			localidadDTO.setCodigoubicacion(localidadJPA.getCodigoubicacion());
			localidadDTO.setNombrelocalidad(localidadJPA.getNombrelocalidad());
			localidadDTO.setCapacidadlocalidad(localidadJPA.getCapacidadlocalidad());
						
			localidadesDTO.add(localidadDTO);
		}
		
		em.close();
		emf.close();
		
		return localidadesDTO;
	}
	@GET
	@Path("registrarEvento/{nombreevento}/{descripcionevento}/{fechareserva}/{horareserva}/{codigoubicacion}")
	
	public void registrarEvento(@PathParam ("nombreevento") String nombreevento, @PathParam ("descripcionevento") String descripcionevento, @PathParam ("fechareserva") String fechareserva, @PathParam ("horareserva") String horareserva, @PathParam ("codigoubicacion") BigDecimal codigoubicacion) throws ParseException{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ticketReserve");
		EntityManager em = emf.createEntityManager();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.ENGLISH);
		Date date = format.parse(fechareserva);
		
		DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.ENGLISH);
		Date hora = format1.parse(horareserva);
		Evento ejpa = new Evento();
		
		int ideve = this.hashCode()+1;
		
		ejpa.setCodigoevento(ideve);
		ejpa.setCodigoubicacion(codigoubicacion);
		ejpa.setNombreevento(nombreevento);
		ejpa.setDescripcionevento(descripcionevento);
		ejpa.setFechaevento(date);
		ejpa.setHoraevento(hora);
		ejpa.setImagen("Imagen");
		
		em.getTransaction().begin();
		em.persist(ejpa);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
	
	public int lastIdEvento(){
		int ideve = 0;
		List<Evento> lejpa = new ArrayList<Evento>();
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ticketReserve");
		EntityManager em = emf.createEntityManager();
		
		Query query = (Query) em.createQuery("SELECT e FROM Evento e ORDER BY e.codigoevento ASC"); 
		
		lejpa = (List<Evento>) query.getResultList();
		
		for(Evento ejpa:lejpa){
			ideve = (int) ejpa.getCodigoevento();
		}
		
		em.close();
		emf.close();
		
		return ideve;
	}
	
	@GET
	@Path("actualizarEvento/{codigoevento}/{nombreevento}/{descripcionevento}/{fechareserva}/{horareserva}/{codigoubicacion}")
	public void actualizarEvento(@PathParam ("codigoevento") int codigoevento, @PathParam ("nombreevento") String nombreevento, @PathParam ("descripcionevento") String descripcionevento, @PathParam ("fechareserva") String fechareserva, @PathParam ("horareserva") String horareserva, @PathParam ("codigoubicacion") BigDecimal codigoubicacion) throws ParseException{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ticketReserve");
		EntityManager em = emf.createEntityManager();
		
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.ENGLISH);
		Date date = format.parse(fechareserva);
		
		DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.ENGLISH);
		Date hora = format1.parse(horareserva);
		Evento ejpa = em.find(Evento.class,codigoevento);
		
		ejpa.setCodigoubicacion(codigoubicacion);
		ejpa.setNombreevento(nombreevento);
		ejpa.setDescripcionevento(descripcionevento);
		ejpa.setFechaevento(date);
		ejpa.setHoraevento(hora);
		
		em.getTransaction().begin();
		em.merge(ejpa);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
	@GET
	@Path("eliminarEvento/{codigoevento}")
	public void eliminarEvento(@PathParam("codigoevento") int codigoevento){		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ticketReserve");
		EntityManager em = emf.createEntityManager();
				
		Evento ejpa = em.find(Evento.class, codigoevento);
		
		em.getTransaction().begin();
		em.remove(ejpa);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}

}
