package com.luchoauth.springbootauth.modelodatos.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity(name = "PERMISO")
public class Permiso {

	@Id
	@Column(name = "PERMISO_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERMISO_SEQ")
	@SequenceGenerator(sequenceName = "PERMISO_SEQ", allocationSize = 1, name = "PERMISO_SEQ")
	private Integer id;

	@Column(name = "NOMBRE", nullable = false)
	private String nombre;

	@Column(name = "DESCRIPCION")
	private String descripcion;

	@OneToMany(mappedBy = "permiso")
	private List<RolPermiso> listaRolPermiso;

	public List<RolPermiso> getListaRolPermiso() {
		return listaRolPermiso;
	}

	public void setListaRolPermiso(List<RolPermiso> listaRolPermiso) {
		this.listaRolPermiso = listaRolPermiso;
	}

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

}
