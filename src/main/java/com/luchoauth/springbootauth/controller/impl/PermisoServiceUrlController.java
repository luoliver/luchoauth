package com.luchoauth.springbootauth.controller.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luchoauth.springbootauth.controller.IPermisoServiceUrlController;
import com.luchoauth.springbootauth.controller.dto.PermisoServiceUrlDTO;
import com.luchoauth.springbootauth.controller.dto.RolDTO;
import com.luchoauth.springbootauth.modelodatos.dao.IPermisoServiceUrlDAO;
import com.luchoauth.springbootauth.modelodatos.dao.IRolDAO;
import com.luchoauth.springbootauth.modelodatos.dao.IRolPermisoServiceDAO;
import com.luchoauth.springbootauth.modelodatos.modelo.PermisoServiceUrlVO;
import com.luchoauth.springbootauth.modelodatos.modelo.RolVO;
import com.luchoauth.springbootauth.modelodatos.modelo.RolPermisoServiceVO;
import com.luchoauth.springbootauth.utilidades.converters.PermisoServiceUrlConverter;
import com.luchoauth.springbootauth.utilidades.converters.RolConverter;
import com.luchoauth.springbootauth.utilidades.excepciones.ExcepcionesPersonalizadas;

@Service
public class PermisoServiceUrlController implements IPermisoServiceUrlController {

	@Autowired
	private IPermisoServiceUrlDAO permisoServiceUrlDao;
	
	@Autowired
	private IRolPermisoServiceDAO rolPermisoServiceDao;
	
	@Autowired
	private IRolDAO rolDao;
	
	@Override
	public PermisoServiceUrlDTO crearPermisoServiceUrl(PermisoServiceUrlDTO permisoServiceUrlDto, RolDTO rolDto) {
		PermisoServiceUrlVO permisoServiceUrl = permisoServiceUrlDao.save(PermisoServiceUrlConverter.convertir(permisoServiceUrlDto, true));
		RolPermisoServiceVO rolPermisoService = new RolPermisoServiceVO();
		rolPermisoService.setPermisoService(permisoServiceUrl);
		rolPermisoService.setRol(RolConverter.convertir(rolDto, false));
		rolPermisoService = rolPermisoServiceDao.save(rolPermisoService);
		permisoServiceUrl.setListaRolPermisoService(new ArrayList<>());
		permisoServiceUrl.getListaRolPermisoService().add(rolPermisoService);
		return PermisoServiceUrlConverter.convertir(permisoServiceUrl, true);
	}

	@Override
	public List<PermisoServiceUrlDTO> consultarPermisoServiceUrlPorRol(Integer idRol) throws ExcepcionesPersonalizadas {
		Optional<RolVO> rol = rolDao.findById(idRol);
		if(!rol.isPresent())
			throw new ExcepcionesPersonalizadas("Rol no existe");
		List<PermisoServiceUrlDTO> listaPermisoServiceUrlDto = new ArrayList<>();
		for(RolPermisoServiceVO rolPermisoService :rolPermisoServiceDao.findByRol(rol.get()))
		{
			listaPermisoServiceUrlDto.add(PermisoServiceUrlConverter.convertir(rolPermisoService.getPermisoService(), false));
		}
		return listaPermisoServiceUrlDto;
	}

}
