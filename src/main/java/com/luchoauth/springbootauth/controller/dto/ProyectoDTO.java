package com.luchoauth.springbootauth.controller.dto;

import java.io.Serializable;
import java.util.List;

public class ProyectoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nombre;
	private String descripcion;
	private String actualVersion;
	private List<RolDTO> listaRolProyectoDto;
	
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
	public String getActualVersion() {
		return actualVersion;
	}
	public void setActualVersion(String actualVersion) {
		this.actualVersion = actualVersion;
	}
	public List<RolDTO> getListaRolProyectoDto() {
		return listaRolProyectoDto;
	}
	public void setListaRolProyectoDto(List<RolDTO> listaRolProyectoDto) {
		this.listaRolProyectoDto = listaRolProyectoDto;
	}
}
