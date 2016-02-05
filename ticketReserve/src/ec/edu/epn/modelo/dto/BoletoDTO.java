package ec.edu.epn.modelo.dto;

import java.math.BigDecimal;

import ec.edu.epn.modelo.jpa.Evento;

public class BoletoDTO {

	private long codigoboleto;
	private BigDecimal codigolocalidad;
	private float precioboleto;
//	private Evento evento;
	private BigDecimal codigoevento;

	public BoletoDTO() {
		
	}

	public long getCodigoboleto() {
		return codigoboleto;
	}

	public void setCodigoboleto(long codigoboleto) {
		this.codigoboleto = codigoboleto;
	}

	public BigDecimal getCodigolocalidad() {
		return codigolocalidad;
	}

	public void setCodigolocalidad(BigDecimal codigolocalidad) {
		this.codigolocalidad = codigolocalidad;
	}

	public float getPrecioboleto() {
		return precioboleto;
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
//		return evento;
//	}
//
//	public void setEvento(Evento evento) {
//		this.evento = evento;
//	}
}
