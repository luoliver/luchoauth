package com.luchoauth.springbootauth.modelodatos.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "TIPO_DOCUMENTO")
public class TipoDocumentoVO {

	@Id
	@Column(name = "CODIGO")
	private String codigo;

	@Column(name = "NOMBRE", unique = true, nullable = false)
	private String nombre;

	@Column(name = "DESCRIPCION", nullable = true)
	private String descripcion;

	@OneToMany(mappedBy = "tipoDocumento")
	private List<PersonaVO> listaPersonas;

	public List<PersonaVO> getListaPersonas() {
		return listaPersonas;
	}

	public void setListaPersonas(List<PersonaVO> listaPersonas) {
		this.listaPersonas = listaPersonas;
	}

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

}
