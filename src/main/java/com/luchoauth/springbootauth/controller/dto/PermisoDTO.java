package com.luchoauth.springbootauth.controller.dto;

import java.io.Serializable;
import java.util.List;

public class PermisoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nombre;
	private String descripcion;
	private List<RolPermisoDTO> listaRolPermisoDto;
	
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
	public List<RolPermisoDTO> getListaRolPermisoDto() {
		return listaRolPermisoDto;
	}
	public void setListaRolPermisoDto(List<RolPermisoDTO> listaRolPermisoDto) {
		this.listaRolPermisoDto = listaRolPermisoDto;
	}
	
}
