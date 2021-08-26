package com.luchoauth.springbootauth.controller.dto;

import java.io.Serializable;
import java.util.List;

public class TipoDocumentoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private String codigo;
	private String nombre;
	private String descripcion;
	private List<PersonaDTO> listaPersonasDto;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
	public List<PersonaDTO> getListaPersonasDto() {
		return listaPersonasDto;
	}
	public void setListaPersonasDto(List<PersonaDTO> listaPersonasDto) {
		this.listaPersonasDto = listaPersonasDto;
	}	
	
}
