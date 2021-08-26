package com.luchoauth.springbootauth.controller.dto;

import java.io.Serializable;

public class RolPermisoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;
	private RolDTO rolDto;
	private PermisoDTO permisoDto;
	
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
	public PermisoDTO getPermisoDto() {
		return permisoDto;
	}
	public void setPermisoDto(PermisoDTO permisoDto) {
		this.permisoDto = permisoDto;
	}
}
