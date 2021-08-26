package com.luchoauth.springbootauth.controller;

import java.util.List;

import com.luchoauth.springbootauth.controller.dto.PermisoServiceUrlDTO;
import com.luchoauth.springbootauth.controller.dto.RolDTO;
import com.luchoauth.springbootauth.utilidades.excepciones.ExcepcionesPersonalizadas;

public interface IPermisoServiceUrlController {

	/**
	 * 
	 * @param permisoServiceUrlDto
	 * @param rolDto
	 * @return
	 */
	public PermisoServiceUrlDTO crearPermisoServiceUrl(PermisoServiceUrlDTO permisoServiceUrlDto, RolDTO rolDto);
	
	/**
	 * 
	 * @param idRol
	 * @return
	 * @throws ExcepcionesPersonalizadas 
	 */
	public List<PermisoServiceUrlDTO> consultarPermisoServiceUrlPorRol(Integer idRol) throws ExcepcionesPersonalizadas;
}
