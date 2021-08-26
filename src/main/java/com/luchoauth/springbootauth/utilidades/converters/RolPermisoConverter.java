package com.luchoauth.springbootauth.utilidades.converters;

import java.util.ArrayList;
import java.util.List;

import com.luchoauth.springbootauth.controller.dto.RolPermisoDTO;
import com.luchoauth.springbootauth.modelodatos.modelo.RolPermisoVO;

public class RolPermisoConverter {

	private RolPermisoConverter() {
		throw new IllegalStateException("Clase converter sin constructor");
	}
	
	public static List<RolPermisoVO> convertirDtoAVo(List<RolPermisoDTO> listaRolPermisoDto,boolean completo) {
		List<RolPermisoVO> listaRolPermiso = new ArrayList<>();
		if(listaRolPermisoDto != null)
			for(RolPermisoDTO rolPermisoDto :listaRolPermisoDto) {
				listaRolPermiso.add(convertir(rolPermisoDto,completo));
			}
		return listaRolPermiso;
	}
	
	public static RolPermisoVO convertir(RolPermisoDTO rolPermisoDto,boolean completo) {
		RolPermisoVO rolPermiso = new RolPermisoVO();
		rolPermiso.setId(rolPermisoDto.getId());
		if(completo) {
			rolPermiso.setPermiso(PermisoConverter.convertir(rolPermisoDto.getPermisoDto(),false));
			rolPermiso.setRol(RolConverter.convertir(rolPermisoDto.getRolDto(),false));
		}
		return rolPermiso;
	}
	
	public static List<RolPermisoDTO> convertirVoADto(List<RolPermisoVO> listaRolPermiso,boolean completo) {
		List<RolPermisoDTO> listaRolPermisoDto = new ArrayList<>();
		if(listaRolPermiso != null)
			for(RolPermisoVO rolPermiso :listaRolPermiso) {
				listaRolPermisoDto.add(convertir(rolPermiso,completo));
			}
		return listaRolPermisoDto;
	}
	
	public static RolPermisoDTO convertir(RolPermisoVO rolPermiso,boolean completo) {
		RolPermisoDTO rolPermisoDto = new RolPermisoDTO();
		rolPermisoDto.setId(rolPermiso.getId());
		if(completo) {
			rolPermisoDto.setPermisoDto(PermisoConverter.convertir(rolPermiso.getPermiso(),false));
			rolPermisoDto.setRolDto(RolConverter.convertir(rolPermiso.getRol(),false));
		}
		return rolPermisoDto;
	}
}
