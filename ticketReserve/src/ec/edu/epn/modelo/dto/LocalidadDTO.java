package ec.edu.epn.modelo.dto;

import java.math.BigDecimal;

public class LocalidadDTO {
	
	private long codigolocalidad;
	private int capacidadlocalidad;
	private BigDecimal codigoubicacion;
	private String nombrelocalidad;

	public LocalidadDTO() {
		
	}

	public long getCodigolocalidad() {
		return codigolocalidad;
	}

	public void setCodigolocalidad(long codigolocalidad) {
		this.codigolocalidad = codigolocalidad;
	}

	public int getCapacidadlocalidad() {
		return capacidadlocalidad;
	}

	public void setCapacidadlocalidad(int capacidadlocalidad) {
		this.capacidadlocalidad = capacidadlocalidad;
	}

	public BigDecimal getCodigoubicacion() {
		return codigoubicacion;
	}

	public void setCodigoubicacion(BigDecimal codigoubicacion) {
		this.codigoubicacion = codigoubicacion;
	}

	public String getNombrelocalidad() {
		return nombrelocalidad;
	}

	public void setNombrelocalidad(String nombrelocalidad) {
		this.nombrelocalidad = nombrelocalidad;
	}
}
