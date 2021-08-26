package com.luchoauth.springbootauth.modelodatos.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity(name = "ROL_PERMISO_SERVICE")
public class RolPermisoServiceVO {

	@Id
	@Column(name = "ROL_PERMISO_SERVICE_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROL_PERMISO_SERVICE_SEQ")
	@SequenceGenerator(sequenceName = "ROL_PERMISO_SERVICE_SEQ", allocationSize = 1, name = "ROL_PERMISO_SERVICE_SEQ")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "ROL",referencedColumnName = "ROL_ID", nullable = false)
	private RolVO rol;

	@ManyToOne
	@JoinColumn(name = "PERMISO_SERVICE",referencedColumnName = "PERMISO_SERVICE_URL_ID", nullable = false)
	private PermisoServiceUrlVO permisoService;

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

	public PermisoServiceUrlVO getPermisoService() {
		return permisoService;
	}

	public void setPermisoService(PermisoServiceUrlVO permisoService) {
		this.permisoService = permisoService;
	}

}
