package com.luchoauth.springbootauth.modelodatos.modelo;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity(name = "USUARIO")
public class UsuarioVO {

	@Id
	@Column(name = "USUARIO_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USUARIO_SEQ")
	@SequenceGenerator(sequenceName = "USUARIO_SEQ", allocationSize = 1, name = "USUARIO_SEQ")
	private Integer id;

	@Column(name = "USUARIO", nullable = false, unique = true)
	private String usuario;

	@Column(name = "CONTRASENA", nullable = false)
	private String contrasena;

	@Column(name = "CORREO_ELECTRONICO", nullable = false, unique = true)
	private String correoElectronico;

	@Column(name = "CONFIRMA_CORREO_ELECTRONICO", nullable = false)
	private String confirmaCorreoElectronico;

	@Column(name = "FECHA_CAMBIO_CONTRASENA", nullable = false)
	private Date fechaCambioContrasena;

	@OneToOne(mappedBy = "usuario")
	private PersonaVO persona;
	
	@OneToMany(mappedBy = "usuario")
	private List<RolUsuarioVO> listaRolUsuario;

	public List<RolUsuarioVO> getListaRolUsuario() {
		return listaRolUsuario;
	}

	public void setListaRolUsuario(List<RolUsuarioVO> listaRolUsuario) {
		this.listaRolUsuario = listaRolUsuario;
	}

	public PersonaVO getPersona() {
		return persona;
	}

	public void setPersona(PersonaVO persona) {
		this.persona = persona;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getConfirmaCorreoElectronico() {
		return confirmaCorreoElectronico;
	}

	public void setConfirmaCorreoElectronico(String confirmaCorreoElectronico) {
		this.confirmaCorreoElectronico = confirmaCorreoElectronico;
	}

	public Date getFechaCambioContrasena() {
		return fechaCambioContrasena;
	}

	public void setFechaCambioContrasena(Date fechaCambioContrasena) {
		this.fechaCambioContrasena = fechaCambioContrasena;
	}

}
