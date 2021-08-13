package com.luchoauth.springbootauth.modelodatos.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity(name = "ROL_PERSONA")
public class RolPersona {

	@Id
	@Column(name = "ROL_PERSONA_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROL_PERSONA_SEQ")
	@SequenceGenerator(sequenceName = "ROL_PERSONA_SEQ", allocationSize = 1, name = "ROL_PERSONA_SEQ")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "ROL",referencedColumnName = "ROL_ID", nullable = false)
	private Rol rol;

	@ManyToOne
	@JoinColumn(name = "PERSONA",referencedColumnName = "PERSONA_ID", nullable = false)
	private Persona persona;

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

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
}
