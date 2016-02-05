package ec.edu.epn.modelo.dto;

public class UbicacionDTO {

	private long codigoubicacion;
	private int capacidadubicacion;
	private String ciudadubicacion;
	private String direccionubicacion;
	private String nombreubicacion;
	
	public UbicacionDTO() {
		
	}

	public long getCodigoubicacion() {
		return codigoubicacion;
	}

	public void setCodigoubicacion(long codigoubicacion) {
		this.codigoubicacion = codigoubicacion;
	}

	public int getCapacidadubicacion() {
		return capacidadubicacion;
	}

	public void setCapacidadubicacion(int capacidadubicacion) {
		this.capacidadubicacion = capacidadubicacion;
	}

	public String getCiudadubicacion() {
		return ciudadubicacion;
	}

	public void setCiudadubicacion(String ciudadubicacion) {
		this.ciudadubicacion = ciudadubicacion;
	}

	public String getDireccionubicacion() {
		return direccionubicacion;
	}

	public void setDireccionubicacion(String direccionubicacion) {
		this.direccionubicacion = direccionubicacion;
	}

	public String getNombreubicacion() {
		return nombreubicacion;
	}

	public void setNombreubicacion(String nombreubicacion) {
		this.nombreubicacion = nombreubicacion;
	}
}
