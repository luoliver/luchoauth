package com.luchoauth.springbootauth.service.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AuthenticationRequest {

	@NotBlank
	private String usuario;
	
	@NotBlank
	private String contrasena;
	
	@NotBlank
	private String rol;
	
	@NotNull(message = "Proyecto no puede ir vacio")
	private String proyecto;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getProyecto() {
		return proyecto;
	}

	public void setProyecto(String proyecto) {
		this.proyecto = proyecto;
	}
	
}
