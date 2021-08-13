package com.luchoauth.springbootauth.modelodatos.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity(name = "PROYECTO")
public class Proyecto {

	@Id
	@Column(name = "PROYECTO_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROYECTO_SEQ")
	@SequenceGenerator(sequenceName = "PROYECTO_SEQ", allocationSize = 1, name = "PROYECTO_SEQ")
	private Integer id;

	@Column(name = "NOMBRE", nullable = false, unique = true)
	private String nombre;

	@Column(name = "DESCRIPCION")
	private String descripcion;

	@Column(name = "ACTUAL_VERSION", nullable = false)
	private String actualVersion;

	@OneToMany(mappedBy = "proyecto")
	private List<RolProyecto> listaRolProyecto;

	public List<RolProyecto> getListaRolProyecto() {
		return listaRolProyecto;
	}

	public void setListaRolProyecto(List<RolProyecto> listaRolProyecto) {
		this.listaRolProyecto = listaRolProyecto;
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

	public String getActualVersion() {
		return actualVersion;
	}

	public void setActualVersion(String actualVersion) {
		this.actualVersion = actualVersion;
	}

}
