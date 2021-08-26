package com.luchoauth.springbootauth.utilidades.converters;

import java.util.ArrayList;
import java.util.List;

import com.luchoauth.springbootauth.controller.dto.RolPermisoServiceDTO;
import com.luchoauth.springbootauth.modelodatos.modelo.RolPermisoServiceVO;

public class RolPermisoServiceConverter {

	private RolPermisoServiceConverter() {
		throw new IllegalStateException("Clase converter sin constructor");
	}
	
	public static List<RolPermisoServiceVO> convertirDtoAVo(List<RolPermisoServiceDTO> listaRolPermisoServiceDto,boolean completo) {
		List<RolPermisoServiceVO> listaRolPermisoService = new ArrayList<>();
		if(listaRolPermisoServiceDto != null)
			for(RolPermisoServiceDTO rolPermisoServiceDto :listaRolPermisoServiceDto) {
				listaRolPermisoService.add(convertir(rolPermisoServiceDto,completo));
			}
		return listaRolPermisoService;
	}
	
	public static RolPermisoServiceVO convertir(RolPermisoServiceDTO rolPermisoServiceDto,boolean completo) {
		RolPermisoServiceVO rolPermisoService = new RolPermisoServiceVO();
		rolPermisoService.setId(rolPermisoServiceDto.getId());
		if(completo) {
			rolPermisoService.setPermisoService(PermisoServiceUrlConverter.convertir(rolPermisoServiceDto.getPermisoServiceDto(),false));
			rolPermisoService.setRol(RolConverter.convertir(rolPermisoServiceDto.getRolDto(),false));
		}
		return rolPermisoService;
	}
	
	public static List<RolPermisoServiceDTO> convertirVoADto(List<RolPermisoServiceVO> listaRolPermisoService,boolean completo) {
		List<RolPermisoServiceDTO> listaRolPermisoServiceDto = new ArrayList<>();
		if(listaRolPermisoService != null)
			for(RolPermisoServiceVO rolPermisoService :listaRolPermisoService) {
				listaRolPermisoServiceDto.add(convertir(rolPermisoService,completo));
			}
		return listaRolPermisoServiceDto;
	}
	
	public static RolPermisoServiceDTO convertir(RolPermisoServiceVO rolPermisoService,boolean completo) {
		RolPermisoServiceDTO rolPermisoServiceDto = new RolPermisoServiceDTO();
		rolPermisoServiceDto.setId(rolPermisoService.getId());
		if(completo) {
			rolPermisoServiceDto.setPermisoServiceDto(PermisoServiceUrlConverter.convertir(rolPermisoService.getPermisoService(),false));
			rolPermisoServiceDto.setRolDto(RolConverter.convertir(rolPermisoService.getRol(),false));
		}
		return rolPermisoServiceDto;
	}
}
