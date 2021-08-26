package com.luchoauth.springbootauth.controller.dto;

import java.io.Serializable;

public class RolUsuarioDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;
	private RolDTO rolDto;
	private UsuarioDTO usuarioDto;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public RolDTO getRolDto() {
		return rolDto;
	}
	public void setRolDto(RolDTO rolDto) {
		this.rolDto = rolDto;
	}
	public UsuarioDTO getUsuarioDto() {
		return usuarioDto;
	}
	public void setUsuarioDto(UsuarioDTO usuarioDto) {
		this.usuarioDto = usuarioDto;
	}
	
}
