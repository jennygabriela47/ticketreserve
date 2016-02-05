package ec.edu.epn.modelo.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the localidad database table.
 * 
 */
@Entity
@NamedQuery(name="Localidad.findAll", query="SELECT l FROM Localidad l")
public class Localidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long codigolocalidad;

	private int capacidadlocalidad;

	private BigDecimal codigoubicacion;

	private String nombrelocalidad;

	public Localidad() {
	}

	public long getCodigolocalidad() {
		return this.codigolocalidad;
	}

	public void setCodigolocalidad(long codigolocalidad) {
		this.codigolocalidad = codigolocalidad;
	}

	public int getCapacidadlocalidad() {
		return this.capacidadlocalidad;
	}

	public void setCapacidadlocalidad(int capacidadlocalidad) {
		this.capacidadlocalidad = capacidadlocalidad;
	}

	public BigDecimal getCodigoubicacion() {
		return this.codigoubicacion;
	}

	public void setCodigoubicacion(BigDecimal codigoubicacion) {
		this.codigoubicacion = codigoubicacion;
	}

	public String getNombrelocalidad() {
		return this.nombrelocalidad;
	}

	public void setNombrelocalidad(String nombrelocalidad) {
		this.nombrelocalidad = nombrelocalidad;
	}

}