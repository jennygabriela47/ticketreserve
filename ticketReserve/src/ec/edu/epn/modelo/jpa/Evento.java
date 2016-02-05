package ec.edu.epn.modelo.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the evento database table.
 * 
 */
@Entity
@NamedQuery(name="Evento.findAll", query="SELECT e FROM Evento e")
public class Evento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int codigoevento;

	private BigDecimal codigoubicacion;

	private String descripcionevento;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaevento;

	@Temporal(TemporalType.TIMESTAMP)
	private Date horaevento;

	private String imagen;

	private String nombreevento;

//	//bi-directional many-to-one association to Boleto
//	@OneToMany(mappedBy="evento")
//	private List<Boleto> boletos;

	public Evento() {
	}

	public int getCodigoevento() {
		return this.codigoevento;
	}

	public void setCodigoevento(int codigoevento) {
		this.codigoevento = codigoevento;
	}

	public BigDecimal getCodigoubicacion() {
		return this.codigoubicacion;
	}

	public void setCodigoubicacion(BigDecimal codigoubicacion) {
		this.codigoubicacion = codigoubicacion;
	}

	public String getDescripcionevento() {
		return this.descripcionevento;
	}

	public void setDescripcionevento(String descripcionevento) {
		this.descripcionevento = descripcionevento;
	}

	public Date getFechaevento() {
		return this.fechaevento;
	}

	public void setFechaevento(Date fechaevento) {
		this.fechaevento = fechaevento;
	}

	public Date getHoraevento() {
		return this.horaevento;
	}

	public void setHoraevento(Date horaevento) {
		this.horaevento = horaevento;
	}

	public String getImagen() {
		return this.imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getNombreevento() {
		return this.nombreevento;
	}

	public void setNombreevento(String nombreevento) {
		this.nombreevento = nombreevento;
	}

//	public List<Boleto> getBoletos() {
//		return this.boletos;
//	}
//
//	public void setBoletos(List<Boleto> boletos) {
//		this.boletos = boletos;
//	}

//	public Boleto addBoleto(Boleto boleto) {
//		getBoletos().add(boleto);
//		boleto.setEvento(this);
//
//		return boleto;
//	}
//
//	public Boleto removeBoleto(Boleto boleto) {
//		getBoletos().remove(boleto);
//		boleto.setEvento(null);
//
//		return boleto;
//	}

}