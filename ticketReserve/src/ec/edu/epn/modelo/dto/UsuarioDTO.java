package ec.edu.epn.modelo.dto;

public class UsuarioDTO {
	
	private int codigousuario;
	private String apellido;
	private String cedula;
	private String contrasenia;
	private String correoelectronico;
	private String nombre;
	private String usuario;
	
	public UsuarioDTO() {
		
	}

	public int getCodigousuario() {
		return codigousuario;
	}

	public void setCodigousuario(int codigousuario) {
		this.codigousuario = codigousuario;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getCorreoelectronico() {
		return correoelectronico;
	}

	public void setCorreoelectronico(String correoelectronico) {
		this.correoelectronico = correoelectronico;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}	
}
