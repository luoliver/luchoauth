package com.luchoauth.springbootauth.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luchoauth.springbootauth.controller.IProyectoController;
import com.luchoauth.springbootauth.controller.dto.ProyectoDTO;
import com.luchoauth.springbootauth.modelodatos.dao.IProyectoDAO;
import com.luchoauth.springbootauth.modelodatos.dao.IRolDAO;
import com.luchoauth.springbootauth.modelodatos.modelo.ProyectoVO;
import com.luchoauth.springbootauth.utilidades.converters.ProyectoConverter;
import com.luchoauth.springbootauth.utilidades.converters.RolConverter;
import com.luchoauth.springbootauth.utilidades.excepciones.ExcepcionesPersonalizadas;

@Service
public class ProyectoController implements IProyectoController{

	@Autowired
	private IProyectoDAO proyectoDao;
	
	@Autowired
	private IRolDAO rolDao;
	
	@Override
	public ProyectoDTO crearProyecto(ProyectoDTO proyectoDto) throws ExcepcionesPersonalizadas {
		proyectoDto.setNombre(proyectoDto.getNombre().toUpperCase());
		if(proyectoDao.findByNombre(proyectoDto.getNombre()) != null)
			throw new ExcepcionesPersonalizadas("Proyecto ya existe");
		ProyectoVO proyecto = proyectoDao.save(ProyectoConverter.convertir(proyectoDto, false));
		return ProyectoConverter.convertir(proyecto,false);
	}

	@Override
	public List<ProyectoDTO> obtenerProyectos() {
		List<ProyectoVO> listaProyectos = proyectoDao.findAll();
		return ProyectoConverter.convertirVoADto(listaProyectos, true);
	}

	@Override
	public ProyectoDTO consultarProyectoPorNombre(String nombre) {
		ProyectoVO proyecto = proyectoDao.findByNombre(nombre);
		ProyectoDTO proyectoDto = ProyectoConverter.convertir(proyecto, false);
		proyectoDto.setListaRolProyectoDto(RolConverter.convertirVoADto(rolDao.findByProyecto(proyecto),false));
		return proyectoDto;
	}

}
