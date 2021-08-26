package com.luchoauth.springbootauth.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luchoauth.springbootauth.controller.IRolController;
import com.luchoauth.springbootauth.controller.dto.ProyectoDTO;
import com.luchoauth.springbootauth.controller.dto.RolDTO;
import com.luchoauth.springbootauth.modelodatos.dao.IProyectoDAO;
import com.luchoauth.springbootauth.modelodatos.dao.IRolDAO;
import com.luchoauth.springbootauth.modelodatos.modelo.RolVO;
import com.luchoauth.springbootauth.utilidades.converters.ProyectoConverter;
import com.luchoauth.springbootauth.utilidades.converters.RolConverter;
import com.luchoauth.springbootauth.utilidades.excepciones.ExcepcionesPersonalizadas;

@Service
public class RolController implements IRolController{

	@Autowired
	private IRolDAO rolDao;
	
	@Autowired
	private IProyectoDAO proyectoDao;
	
	@Override
	public List<RolDTO> consultarRolPorProyecto(ProyectoDTO proyectoDto) {
		List<RolVO> listaRol = rolDao.findByProyecto(ProyectoConverter.convertir(proyectoDto, false));
		return RolConverter.convertirVoADto(listaRol, false);
	}

	@Override
	public RolDTO crearRol(RolDTO rolDto) throws ExcepcionesPersonalizadas {
		if(!proyectoDao.existsById(rolDto.getProyectoDto().getId()))
			throw new ExcepcionesPersonalizadas("Proyecto no existe");
		if(validarExisteRolProyecto(rolDto))
			throw new ExcepcionesPersonalizadas("Rol ya existe para ese proyecto");
		RolVO rol = rolDao.save(RolConverter.convertir(rolDto, true));
		return RolConverter.convertir(rol, true);
	}

	@Override
	public RolDTO consultarRolPorProyectoYNombre(ProyectoDTO proyectoDto, String nombre) {
		List<RolDTO> listaRolDto = this.consultarRolPorProyecto(proyectoDto);
		for(RolDTO rolDto :listaRolDto) {
			if(rolDto.getNombre().equals(nombre)) {
				return rolDto;
			}
		}
		return null;
	}
	
	private boolean validarExisteRolProyecto(RolDTO rolDto) {
		RolDTO rol = consultarRolPorProyectoYNombre(rolDto.getProyectoDto(), rolDto.getNombre());
		return rol != null;
	}
	
	
}
