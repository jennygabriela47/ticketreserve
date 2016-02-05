package ec.edu.epn.modelo.dto;

import java.math.BigDecimal;
import java.util.Date;

public class ReservaDTO {

	private long codigoreserva;
	private int cantidadboletoreservada;
	private BigDecimal codigoboleto;
	private BigDecimal codigousuario;
	private Date fechareserva;
	
	public ReservaDTO() {
		
	}
	

	public long getCodigoreserva() {
		return codigoreserva;
	}

	public void setCodigoreserva(long codigoreserva) {
		this.codigoreserva = codigoreserva;
	}

	public int getCantidadboletoreservada() {
		return cantidadboletoreservada;
	}

	public void setCantidadboletoreservada(int cantidadboletoreservada) {
		this.cantidadboletoreservada = cantidadboletoreservada;
	}

	public BigDecimal getCodigoboleto() {
		return codigoboleto;
	}

	public void setCodigoboleto(BigDecimal codigoboleto) {
		this.codigoboleto = codigoboleto;
	}

	public BigDecimal getCodigousuario() {
		return codigousuario;
	}

	public void setCodigousuario(BigDecimal codigousuario) {
		this.codigousuario = codigousuario;
	}

	public Date getFechareserva() {
		return fechareserva;
	}

	public void setFechareserva(Date fechareserva) {
		this.fechareserva = fechareserva;
	}
}
