package com.luchoauth.springbootauth.modelodatos.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity(name = "ROL_PROYECTO")
public class RolProyecto {

	@Id
	@Column(name = "ROL_PROYECTO_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROL_PROYECTO_SEQ")
	@SequenceGenerator(sequenceName = "ROL_PROYECTO_SEQ", allocationSize = 1, name = "ROL_PROYECTO_SEQ")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "ROL",referencedColumnName = "ROL_ID", nullable = false)
	private Rol rol;

	@ManyToOne
	@JoinColumn(name = "PROYECTO",referencedColumnName = "PROYECTO_ID", nullable = false)
	private Proyecto proyecto;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

}
