package com.luchoauth.springbootauth.controller.dto;

import java.io.Serializable;

public class RolPermisoServiceDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;
	private RolDTO rolDto;
	private PermisoServiceUrlDTO permisoServiceDto;
	
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
	public PermisoServiceUrlDTO getPermisoServiceDto() {
		return permisoServiceDto;
	}
	public void setPermisoServiceDto(PermisoServiceUrlDTO permisoServiceDto) {
		this.permisoServiceDto = permisoServiceDto;
	}
	
}
