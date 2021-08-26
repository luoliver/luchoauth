package com.luchoauth.springbootauth.service.request;

import javax.validation.constraints.NotBlank;

import com.luchoauth.springbootauth.controller.dto.PermisoServiceUrlDTO;
import com.luchoauth.springbootauth.controller.dto.ProyectoDTO;
import com.luchoauth.springbootauth.controller.dto.RolDTO;

public class CrearProyectoRolPermisoUrlRequest {

	@NotBlank
	private RolDTO rolDto;
	
	private ProyectoDTO proyectoDto;
	
	private PermisoServiceUrlDTO permisoServiceUrlDto;

	public RolDTO getRolDto() {
		return rolDto;
	}

	public void setRolDto(RolDTO rolDto) {
		this.rolDto = rolDto;
	}

	public ProyectoDTO getProyectoDto() {
		return proyectoDto;
	}

	public void setProyectoDto(ProyectoDTO proyectoDto) {
		this.proyectoDto = proyectoDto;
	}

	public PermisoServiceUrlDTO getPermisoServiceUrlDto() {
		return permisoServiceUrlDto;
	}

	public void setPermisoServiceUrlDto(PermisoServiceUrlDTO permisoServiceUrlDto) {
		this.permisoServiceUrlDto = permisoServiceUrlDto;
	}
	
}
