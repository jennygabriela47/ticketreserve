package ec.edu.epn.modelo.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ubicacion database table.
 * 
 */
@Entity
@NamedQuery(name="Ubicacion.findAll", query="SELECT u FROM Ubicacion u")
public class Ubicacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long codigoubicacion;

	private int capacidadubicacion;

	private String ciudadubicacion;

	private String direccionubicacion;

	private String nombreubicacion;

	public Ubicacion() {
	}

	public long getCodigoubicacion() {
		return this.codigoubicacion;
	}

	public void setCodigoubicacion(long codigoubicacion) {
		this.codigoubicacion = codigoubicacion;
	}

	public int getCapacidadubicacion() {
		return this.capacidadubicacion;
	}

	public void setCapacidadubicacion(int capacidadubicacion) {
		this.capacidadubicacion = capacidadubicacion;
	}

	public String getCiudadubicacion() {
		return this.ciudadubicacion;
	}

	public void setCiudadubicacion(String ciudadubicacion) {
		this.ciudadubicacion = ciudadubicacion;
	}

	public String getDireccionubicacion() {
		return this.direccionubicacion;
	}

	public void setDireccionubicacion(String direccionubicacion) {
		this.direccionubicacion = direccionubicacion;
	}

	public String getNombreubicacion() {
		return this.nombreubicacion;
	}

	public void setNombreubicacion(String nombreubicacion) {
		this.nombreubicacion = nombreubicacion;
	}

}