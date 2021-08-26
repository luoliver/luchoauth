package com.luchoauth.springbootauth.modelodatos.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity(name = "ROL")
public class RolVO {

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
	private List<RolPermisoVO> listaRolPermiso;
	
	@OneToMany(mappedBy = "rol")
	private List<RolUsuarioVO> listaRolUsuario;

	@ManyToOne
	@JoinColumn(name = "PROYECTO",referencedColumnName = "PROYECTO_ID", nullable = false)
	private ProyectoVO proyecto;

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

	public List<RolPermisoVO> getListaRolPermiso() {
		return listaRolPermiso;
	}

	public void setListaRolPermiso(List<RolPermisoVO> listaRolPermiso) {
		this.listaRolPermiso = listaRolPermiso;
	}

	public List<RolUsuarioVO> getListaRolUsuario() {
		return listaRolUsuario;
	}

	public void setListaRolUsuario(List<RolUsuarioVO> listaRolUsuario) {
		this.listaRolUsuario = listaRolUsuario;
	}

	public ProyectoVO getProyecto() {
		return proyecto;
	}

	public void setProyecto(ProyectoVO proyecto) {
		this.proyecto = proyecto;
	}

}
