package com.luchoauth.springbootauth.modelodatos.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity(name = "ROL_USUARIO")
public class RolUsuarioVO {

	@Id
	@Column(name = "ROL_USUARIO_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROL_USUARIO_SEQ")
	@SequenceGenerator(sequenceName = "ROL_USUARIO_SEQ", allocationSize = 1, name = "ROL_USUARIO_SEQ")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "ROL",referencedColumnName = "ROL_ID", nullable = false)
	private RolVO rol;

	@ManyToOne
	@JoinColumn(name = "USUARIO",referencedColumnName = "USUARIO_ID", nullable = false)
	private UsuarioVO usuario;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public RolVO getRol() {
		return rol;
	}

	public void setRol(RolVO rol) {
		this.rol = rol;
	}

	public UsuarioVO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioVO usuario) {
		this.usuario = usuario;
	}

}
