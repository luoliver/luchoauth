package com.luchoauth.springbootauth.controller;

import java.util.List;

import com.luchoauth.springbootauth.controller.dto.RolDTO;
import com.luchoauth.springbootauth.controller.dto.RolPermisoServiceDTO;

public interface IRolPermisoServiceController {

	/**
	 * 
	 * @param rolDto
	 * @return
	 */
	public List<RolPermisoServiceDTO> consultarRolPermisoServicePorRol (RolDTO rolDto);
}
