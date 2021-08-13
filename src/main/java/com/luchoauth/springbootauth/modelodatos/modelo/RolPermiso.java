package com.luchoauth.springbootauth.modelodatos.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity(name = "ROL_PERMISO")
public class RolPermiso {

	@Id
	@Column(name = "ROL_PERMISO_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROL_PERMISO_SEQ")
	@SequenceGenerator(sequenceName = "ROL_PERMISO_SEQ", allocationSize = 1, name = "ROL_PERMISO_SEQ")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "ROL",referencedColumnName = "ROL_ID", nullable = false)
	private Rol rol;

	@ManyToOne
	@JoinColumn(name = "PERMISO",referencedColumnName = "PERMISO_ID", nullable = false)
	private Permiso permiso;

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

	public Permiso getPermiso() {
		return permiso;
	}

	public void setPermiso(Permiso permiso) {
		this.permiso = permiso;
	}
}
