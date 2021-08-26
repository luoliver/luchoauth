package com.luchoauth.springbootauth.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luchoauth.springbootauth.controller.IRolPermisoServiceController;
import com.luchoauth.springbootauth.controller.dto.RolDTO;
import com.luchoauth.springbootauth.controller.dto.RolPermisoServiceDTO;
import com.luchoauth.springbootauth.modelodatos.dao.IRolPermisoServiceDAO;
import com.luchoauth.springbootauth.modelodatos.modelo.RolPermisoServiceVO;
import com.luchoauth.springbootauth.utilidades.converters.RolConverter;
import com.luchoauth.springbootauth.utilidades.converters.RolPermisoServiceConverter;

@Service
public class RolPermisoServiceController implements IRolPermisoServiceController{

	@Autowired
	private IRolPermisoServiceDAO rolPermisoServiceDao;
	
	@Override
	public List<RolPermisoServiceDTO> consultarRolPermisoServicePorRol(RolDTO rolDto) {
		List<RolPermisoServiceVO> rolPermisoService = rolPermisoServiceDao.findByRol(RolConverter.convertir(rolDto, false));
		return RolPermisoServiceConverter.convertirVoADto(rolPermisoService, true);
	}

	
}
