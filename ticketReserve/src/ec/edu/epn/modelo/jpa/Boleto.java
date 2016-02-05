package ec.edu.epn.modelo.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the boleto database table.
 * 
 */
@Entity
@NamedQuery(name="Boleto.findAll", query="SELECT b FROM Boleto b")
public class Boleto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long codigoboleto;

	private BigDecimal codigolocalidad;

	private float precioboleto;

//	//bi-directional many-to-one association to Evento
//	@ManyToOne
//	@JoinColumn(name="CODIGOEVENTO")
//	private Evento evento;
	
	private BigDecimal codigoevento;

	public Boleto() {
	}

	public long getCodigoboleto() {
		return this.codigoboleto;
	}

	public void setCodigoboleto(long codigoboleto) {
		this.codigoboleto = codigoboleto;
	}

	public BigDecimal getCodigolocalidad() {
		return this.codigolocalidad;
	}

	public void setCodigolocalidad(BigDecimal codigolocalidad) {
		this.codigolocalidad = codigolocalidad;
	}

	public float getPrecioboleto() {
		return this.precioboleto;
	}

	public void setPrecioboleto(float precioboleto) {
		this.precioboleto = precioboleto;
	}

	public BigDecimal getCodigoevento() {
		return codigoevento;
	}

	public void setCodigoevento(BigDecimal codigoevento) {
		this.codigoevento = codigoevento;
	}

//	public Evento getEvento() {
//		return this.evento;
//	}
//
//	public void setEvento(Evento evento) {
//		this.evento = evento;
//	}
	
	

}