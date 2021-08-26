package com.luchoauth.springbootauth.modelodatos.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity(name = "PERMISO_SERVICE_URL")
public class PermisoServiceUrlVO {

	@Id
	@Column(name = "PERMISO_SERVICE_URL_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERMISO_SERVICE_SEQ")
	@SequenceGenerator(sequenceName = "PERMISO_SERVICE_SEQ", allocationSize = 1, name = "PERMISO_SERVICE_SEQ")
	private Integer id;

	@Column(name = "NOMBRE", nullable = false)
	private String nombre;

	@Column(name = "DESCRIPCION")
	private String descripcion;
	
	@Column(name = "PROTOCOLO_SERVICE")
	private String protocoloService;
	
	@Column(name = "URL_SERVICE")
	private String urlService;

	@OneToMany(mappedBy = "permisoService")
	private List<RolPermisoServiceVO> listaRolPermisoService;

	public List<RolPermisoServiceVO> getListaRolPermisoService() {
		return listaRolPermisoService;
	}

	public void setListaRolPermisoService(List<RolPermisoServiceVO> listaRolPermisoService) {
		this.listaRolPermisoService = listaRolPermisoService;
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

	public String getProtocoloService() {
		return protocoloService;
	}

	public void setProtocoloService(String protocoloService) {
		this.protocoloService = protocoloService;
	}

	public String getUrlService() {
		return urlService;
	}

	public void setUrlService(String urlService) {
		this.urlService = urlService;
	}

}
