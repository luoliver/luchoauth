package com.luchoauth.springbootauth.utilidades.converters;

import java.util.ArrayList;
import java.util.List;

import com.luchoauth.springbootauth.controller.dto.PermisoServiceUrlDTO;
import com.luchoauth.springbootauth.modelodatos.modelo.PermisoServiceUrlVO;

public class PermisoServiceUrlConverter {

	private PermisoServiceUrlConverter() {
		throw new IllegalStateException("Clase converter sin constructor");
	}
	
	public static List<PermisoServiceUrlVO> convertirDtoAVo(List<PermisoServiceUrlDTO> listaPermisoServiceUrlDto,boolean completo) {
		List<PermisoServiceUrlVO> listaPermisoServiceUrl = new ArrayList<>();
		if(listaPermisoServiceUrlDto != null)
			for(PermisoServiceUrlDTO permisoServiceUrlDto :listaPermisoServiceUrlDto) {
				listaPermisoServiceUrl.add(convertir(permisoServiceUrlDto,completo));
			}
		return listaPermisoServiceUrl;
	}
	
	public static PermisoServiceUrlVO convertir(PermisoServiceUrlDTO permisoServiceUrlDto,boolean completo) {
		PermisoServiceUrlVO permisoServiceUrl = new PermisoServiceUrlVO();
		permisoServiceUrl.setId(permisoServiceUrlDto.getId());
		permisoServiceUrl.setNombre(permisoServiceUrlDto.getNombre());
		permisoServiceUrl.setDescripcion(permisoServiceUrlDto.getDescripcion());
		permisoServiceUrl.setProtocoloService(permisoServiceUrlDto.getProtocoloService());
		permisoServiceUrl.setUrlService(permisoServiceUrlDto.getUrlService());
		if(completo) {
			permisoServiceUrl.setListaRolPermisoService(RolPermisoServiceConverter.convertirDtoAVo(permisoServiceUrlDto.getListaRolPermisoServiceDto(),false));
		}
		return permisoServiceUrl;
	}
	
	public static List<PermisoServiceUrlDTO> convertirVoADto(List<PermisoServiceUrlVO> listaPermisoServiceUrl,boolean completo) {
		List<PermisoServiceUrlDTO> listaPermisoServiceUrlDto = new ArrayList<>();
		if(listaPermisoServiceUrl != null)
			for(PermisoServiceUrlVO permisoServiceUrl :listaPermisoServiceUrl) {
				listaPermisoServiceUrlDto.add(convertir(permisoServiceUrl,completo));
			}
		return listaPermisoServiceUrlDto;
	}
	
	public static PermisoServiceUrlDTO convertir(PermisoServiceUrlVO permisoServiceUrl,boolean completo) {
		PermisoServiceUrlDTO permisoServiceUrlDto = new PermisoServiceUrlDTO();
		permisoServiceUrlDto.setId(permisoServiceUrl.getId());
		permisoServiceUrlDto.setNombre(permisoServiceUrl.getNombre());
		permisoServiceUrlDto.setDescripcion(permisoServiceUrl.getDescripcion());
		permisoServiceUrlDto.setProtocoloService(permisoServiceUrl.getProtocoloService());
		permisoServiceUrlDto.setUrlService(permisoServiceUrl.getUrlService());
		if(completo) {
			permisoServiceUrlDto.setListaRolPermisoServiceDto(RolPermisoServiceConverter.convertirVoADto(permisoServiceUrl.getListaRolPermisoService(),false));			
		}
		return permisoServiceUrlDto;
	}
}
