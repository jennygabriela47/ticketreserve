package ec.edu.epn.modelo.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the reserva database table.
 * 
 */
@Entity
@NamedQuery(name="Reserva.findAll", query="SELECT r FROM Reserva r")
public class Reserva implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long codigoreserva;

	private int cantidadboletoreservada;

	private BigDecimal codigoboleto;

	private BigDecimal codigousuario;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechareserva;

	public Reserva() {
	}

	public long getCodigoreserva() {
		return this.codigoreserva;
	}

	public void setCodigoreserva(long codigoreserva) {
		this.codigoreserva = codigoreserva;
	}

	public int getCantidadboletoreservada() {
		return this.cantidadboletoreservada;
	}

	public void setCantidadboletoreservada(int cantidadboletoreservada) {
		this.cantidadboletoreservada = cantidadboletoreservada;
	}

	public BigDecimal getCodigoboleto() {
		return this.codigoboleto;
	}

	public void setCodigoboleto(BigDecimal codigoboleto) {
		this.codigoboleto = codigoboleto;
	}

	public BigDecimal getCodigousuario() {
		return this.codigousuario;
	}

	public void setCodigousuario(BigDecimal codigousuario) {
		this.codigousuario = codigousuario;
	}

	public Date getFechareserva() {
		return this.fechareserva;
	}

	public void setFechareserva(Date fechareserva) {
		this.fechareserva = fechareserva;
	}

}