package com.luchoauth.springbootauth.controller.dto;

import java.io.Serializable;
import java.util.List;

public class PermisoServiceUrlDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nombre;
	private String descripcion;
	private String protocoloService;
	private String urlService;
	private List<RolPermisoServiceDTO> listaRolPermisoServiceDto;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getProtocoloService() {
		return protocoloService;
	}
	public void setProtocoloService(String protocoloService) {
		this.protocoloService = protocoloService;
	}
	public String getUrlService() {
		return urlService;
	}
	public void setUrlService(String urlService) {
		this.urlService = urlService;
	}
	public List<RolPermisoServiceDTO> getListaRolPermisoServiceDto() {
		return listaRolPermisoServiceDto;
	}
	public void setListaRolPermisoServiceDto(List<RolPermisoServiceDTO> listaRolPermisoServiceDto) {
		this.listaRolPermisoServiceDto = listaRolPermisoServiceDto;
	}
	
}
