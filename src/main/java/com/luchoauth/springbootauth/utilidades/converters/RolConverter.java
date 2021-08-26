package com.luchoauth.springbootauth.utilidades.converters;

import java.util.ArrayList;
import java.util.List;

import com.luchoauth.springbootauth.controller.dto.RolDTO;
import com.luchoauth.springbootauth.modelodatos.modelo.RolVO;

public class RolConverter {

	private RolConverter() {
		throw new IllegalStateException("Clase converter sin constructor");
	}
	
	public static List<RolVO> convertirDtoAVo(List<RolDTO> listaRolDto,boolean completo) {
		List<RolVO> listaRol = new ArrayList<>();
		if(listaRolDto != null)
			for(RolDTO rolDto :listaRolDto) {
				listaRol.add(convertir(rolDto,completo));
			}
		return listaRol;
	}
	
	public static RolVO convertir(RolDTO rolDto, boolean completo) {
		RolVO rol = new RolVO();
		rol.setId(rolDto.getId());
		rol.setNombre(rolDto.getNombre());
		rol.setDescripcion(rolDto.getDescripcion());
		if(completo) {
			rol.setListaRolPermiso(RolPermisoConverter.convertirDtoAVo(rolDto.getListaRolPermisoDto(),false));
			rol.setListaRolUsuario(RolUsuarioConverter.convertirDtoAVo(rolDto.getListaRolUsuarioDto(),false));
			rol.setProyecto(ProyectoConverter.convertir(rolDto.getProyectoDto(), false));
		}
		return rol;
	}
	
	public static List<RolDTO> convertirVoADto(List<RolVO> listaRol,boolean completo) {
		List<RolDTO> listaRolDto = new ArrayList<>();
		if(listaRol != null)
			for(RolVO rol :listaRol) {
				listaRolDto.add(convertir(rol,completo));
			}
		return listaRolDto;
	}
	
	public static RolDTO convertir(RolVO rol,boolean completo) {
		RolDTO rolDto = new RolDTO();
		rolDto.setId(rol.getId());
		rolDto.setNombre(rol.getNombre());
		rolDto.setDescripcion(rol.getDescripcion());
		if(completo) {
			rolDto.setListaRolPermisoDto(RolPermisoConverter.convertirVoADto(rol.getListaRolPermiso(),false));
			rolDto.setListaRolUsuarioDto(RolUsuarioConverter.convertirVoADto(rol.getListaRolUsuario(),false));
			rolDto.setProyectoDto(ProyectoConverter.convertir(rol.getProyecto(), false));
		}
		return rolDto;
	}
}
