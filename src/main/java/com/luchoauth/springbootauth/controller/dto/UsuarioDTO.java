package com.luchoauth.springbootauth.controller.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class UsuarioDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String usuario;
	private String contrasena;
	private String correoElectronico;
	private String confirmaCorreoElectronico;
	private Date fechaCambioContrasena;
	private PersonaDTO personaDto;
	private List<RolUsuarioDTO> listaRolUsuarioDto;
	
	public List<RolUsuarioDTO> getListaRolUsuarioDto() {
		return listaRolUsuarioDto;
	}
	public void setListaRolUsuarioDto(List<RolUsuarioDTO> listaRolUsuarioDto) {
		this.listaRolUsuarioDto = listaRolUsuarioDto;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	public String getConfirmaCorreoElectronico() {
		return confirmaCorreoElectronico;
	}
	public void setConfirmaCorreoElectronico(String confirmaCorreoElectronico) {
		this.confirmaCorreoElectronico = confirmaCorreoElectronico;
	}
	public Date getFechaCambioContrasena() {
		return fechaCambioContrasena;
	}
	public void setFechaCambioContrasena(Date fechaCambioContrasena) {
		this.fechaCambioContrasena = fechaCambioContrasena;
	}
	public PersonaDTO getPersonaDto() {
		return personaDto;
	}
	public void setPersonaDto(PersonaDTO personaDto) {
		this.personaDto = personaDto;
	}
	
}
