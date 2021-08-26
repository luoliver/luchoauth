package com.luchoauth.springbootauth.controller.dto;

import java.io.Serializable;

public class PersonaDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segundoApellido;
	private TipoDocumentoDTO tipoDocumentoDto;
	private String numeroDocumento;
	private UsuarioDTO usuarioDto;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPrimerNombre() {
		return primerNombre;
	}
	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}
	public String getSegundoNombre() {
		return segundoNombre;
	}
	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}
	public String getPrimerApellido() {
		return primerApellido;
	}
	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}
	public String getSegundoApellido() {
		return segundoApellido;
	}
	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}
	public TipoDocumentoDTO getTipoDocumentoDto() {
		return tipoDocumentoDto;
	}
	public void setTipoDocumentoDto(TipoDocumentoDTO tipoDocumentoDto) {
		this.tipoDocumentoDto = tipoDocumentoDto;
	}
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	public UsuarioDTO getUsuarioDto() {
		return usuarioDto;
	}
	public void setUsuarioDto(UsuarioDTO usuarioDto) {
		this.usuarioDto = usuarioDto;
	}
	
}
