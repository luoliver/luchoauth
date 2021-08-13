package com.luchoauth.springbootauth.modelodatos.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity(name = "ROL")
public class Rol {

	@Id
	@Column(name = "ROL_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROL_SEQ")
	@SequenceGenerator(sequenceName = "ROL_SEQ", allocationSize = 1, name = "ROL_SEQ")
	private Integer id;

	@Column(name = "NOMBRE", nullable = false)
	private String nombre;

	@Column(name = "DESCRIPCION")
	private String descripcion;

	@OneToMany(mappedBy = "rol")
	private List<RolPermiso> listaRolPermiso;
	
	@OneToMany(mappedBy = "rol")
	private List<RolPersona> listaRolPersona;

	@OneToMany(mappedBy = "rol")
	private List<RolProyecto> listaRolProyecto;

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

	public List<RolPermiso> getListaRolPermiso() {
		return listaRolPermiso;
	}

	public void setListaRolPermiso(List<RolPermiso> listaRolPermiso) {
		this.listaRolPermiso = listaRolPermiso;
	}

	public List<RolPersona> getListaRolPersona() {
		return listaRolPersona;
	}

	public void setListaRolPersona(List<RolPersona> listaRolPersona) {
		this.listaRolPersona = listaRolPersona;
	}

	public List<RolProyecto> getListaRolProyecto() {
		return listaRolProyecto;
	}

	public void setListaRolProyecto(List<RolProyecto> listaRolProyecto) {
		this.listaRolProyecto = listaRolProyecto;
	}

}
