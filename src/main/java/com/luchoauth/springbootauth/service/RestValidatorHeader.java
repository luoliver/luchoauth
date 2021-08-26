package com.luchoauth.springbootauth.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.luchoauth.springbootauth.controller.IProyectoController;
import com.luchoauth.springbootauth.controller.IRolController;
import com.luchoauth.springbootauth.controller.IRolPermisoServiceController;
import com.luchoauth.springbootauth.controller.dto.ProyectoDTO;
import com.luchoauth.springbootauth.controller.dto.RolDTO;
import com.luchoauth.springbootauth.controller.dto.RolPermisoServiceDTO;
import com.luchoauth.springbootauth.utilidades.excepciones.ExcepcionesPersonalizadas;

public class RestValidatorHeader {

	@Autowired
	private IRolController rolController;
	
	@Autowired
	private IProyectoController proyectoController;
	
	@Autowired
	private IRolPermisoServiceController rolPermisoServiceController;
	
	public boolean validarAutenticacion(HttpServletRequest request) throws ExcepcionesPersonalizadas {
		try {
			String[] temporalSubString = request.getUserPrincipal().getName().split(";");
			ProyectoDTO proyectoDto = proyectoController.consultarProyectoPorNombre(temporalSubString[2]);			
			RolDTO rolDto = rolController.consultarRolPorProyectoYNombre(proyectoDto,temporalSubString[1]);
			List<RolPermisoServiceDTO> listaRolPersmisoServiceDto = rolPermisoServiceController.consultarRolPermisoServicePorRol(rolDto);
			for(RolPermisoServiceDTO rolPermisoServiceDto :listaRolPersmisoServiceDto)
				if(rolPermisoServiceDto.getPermisoServiceDto().getProtocoloService().equals(request.getMethod()) && rolPermisoServiceDto.getPermisoServiceDto().getUrlService().equals(request.getRequestURI()))
					return true;
		}catch (Exception excepcion) {
			throw new ExcepcionesPersonalizadas("Error validando la autorizacion del servicio con el rol ",excepcion);
		}		
		return false;
	}
}
