package ec.edu.epn.modelo.dto;

import java.math.BigDecimal;
import java.util.Date;

public class EventoDTO {
	
	private int codigoevento;
	private BigDecimal codigoubicacion;
	private String descripcionevento;
	private Date fechaevento;
	private Date horaevento;
	private String imagen;
	private String nombreevento;
	
	public EventoDTO() {
		
	}

	public int getCodigoevento() {
		return codigoevento;
	}

	public void setCodigoevento(int codigoevento) {
		this.codigoevento = codigoevento;
	}

	public BigDecimal getCodigoubicacion() {
		return codigoubicacion;
	}

	public void setCodigoubicacion(BigDecimal codigoubicacion) {
		this.codigoubicacion = codigoubicacion;
	}

	public String getDescripcionevento() {
		return descripcionevento;
	}

	public void setDescripcionevento(String descripcionevento) {
		this.descripcionevento = descripcionevento;
	}

	public Date getFechaevento() {
		return fechaevento;
	}

	public void setFechaevento(Date fechaevento) {
		this.fechaevento = fechaevento;
	}

	public Date getHoraevento() {
		return horaevento;
	}

	public void setHoraevento(Date horaevento) {
		this.horaevento = horaevento;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getNombreevento() {
		return nombreevento;
	}

	public void setNombreevento(String nombreevento) {
		this.nombreevento = nombreevento;
	}
}
