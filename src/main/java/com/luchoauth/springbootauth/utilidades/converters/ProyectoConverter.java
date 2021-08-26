package com.luchoauth.springbootauth.utilidades.converters;

import java.util.ArrayList;
import java.util.List;

import com.luchoauth.springbootauth.controller.dto.ProyectoDTO;
import com.luchoauth.springbootauth.modelodatos.modelo.ProyectoVO;

public class ProyectoConverter {

	private ProyectoConverter() {
		throw new IllegalStateException("Clase converter sin constructor");
	}
	
	public static List<ProyectoVO> convertirDtoAVo(List<ProyectoDTO> listaProyectoDto,boolean completo) {
		List<ProyectoVO> listaProyecto = new ArrayList<>();
		if(listaProyectoDto != null)
			for(ProyectoDTO ProyectoDto :listaProyectoDto) {
				listaProyecto.add(convertir(ProyectoDto,completo));
			}
		return listaProyecto;
	}
	
	public static ProyectoVO convertir(ProyectoDTO proyectoDto,boolean completo) {
		ProyectoVO proyecto = new ProyectoVO();
		proyecto.setId(proyectoDto.getId());
		proyecto.setNombre(proyectoDto.getNombre());
		proyecto.setDescripcion(proyectoDto.getDescripcion());
		proyecto.setActualVersion(proyectoDto.getActualVersion());
		if(completo)
			proyecto.setListaRolProyecto(RolConverter.convertirDtoAVo(proyectoDto.getListaRolProyectoDto(),completo));
		return proyecto;
	}
	
	public static List<ProyectoDTO> convertirVoADto(List<ProyectoVO> listaProyecto,boolean completo) {
		List<ProyectoDTO> listaProyectoDto = new ArrayList<>();
		if(listaProyecto != null)
			for(ProyectoVO Proyecto :listaProyecto) {
				listaProyectoDto.add(convertir(Proyecto,completo));
			}
		return listaProyectoDto;
	}
	
	public static ProyectoDTO convertir(ProyectoVO proyecto,boolean completo) {
		ProyectoDTO proyectoDto = new ProyectoDTO();
		proyectoDto.setId(proyecto.getId());
		proyectoDto.setNombre(proyecto.getNombre());
		proyectoDto.setDescripcion(proyecto.getDescripcion());
		proyectoDto.setActualVersion(proyecto.getActualVersion());
		if(completo)
			proyectoDto.setListaRolProyectoDto(RolConverter.convertirVoADto(proyecto.getListaRolProyecto(),completo));
		return proyectoDto;
	}
}
