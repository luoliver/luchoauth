package com.luchoauth.springbootauth.utilidades.converters;

import java.util.ArrayList;
import java.util.List;

import com.luchoauth.springbootauth.controller.dto.PermisoDTO;
import com.luchoauth.springbootauth.modelodatos.modelo.PermisoVO;

public class PermisoConverter {

	private PermisoConverter() {
		throw new IllegalStateException("Clase converter sin constructor");
	}
	
	public static List<PermisoVO> convertirDtoAVo(List<PermisoDTO> listaPermisoDto,boolean completo) {
		List<PermisoVO> listaPermiso = new ArrayList<>();
		if(listaPermisoDto != null)
			for(PermisoDTO PermisoDto :listaPermisoDto) {
				listaPermiso.add(convertir(PermisoDto,completo));
			}
		return listaPermiso;
	}
	
	public static PermisoVO convertir(PermisoDTO permisoDto,boolean completo) {
		PermisoVO permiso = new PermisoVO();
		permiso.setId(permisoDto.getId());
		permiso.setNombre(permisoDto.getNombre());
		permiso.setDescripcion(permisoDto.getDescripcion());
		if(completo)
			permiso.setListaRolPermiso(RolPermisoConverter.convertirDtoAVo(permisoDto.getListaRolPermisoDto(),false));
		return permiso;
	}
	
	public static List<PermisoDTO> convertirVoADto(List<PermisoVO> listaPermiso,boolean completo) {
		List<PermisoDTO> listaPermisoDto = new ArrayList<>();
		if(listaPermiso != null)
			for(PermisoVO Permiso :listaPermiso) {
				listaPermisoDto.add(convertir(Permiso,completo));
			}
		return listaPermisoDto;
	}
	
	public static PermisoDTO convertir(PermisoVO permiso,boolean completo) {
		PermisoDTO permisoDto = new PermisoDTO();
		permisoDto.setId(permiso.getId());
		permisoDto.setNombre(permiso.getNombre());
		permisoDto.setDescripcion(permiso.getDescripcion());
		if(completo)
			permisoDto.setListaRolPermisoDto(RolPermisoConverter.convertirVoADto(permiso.getListaRolPermiso(),false));
		return permisoDto;
	}
}
