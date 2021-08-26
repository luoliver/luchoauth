package com.luchoauth.springbootauth.utilidades.converters;

import java.util.ArrayList;
import java.util.List;

import com.luchoauth.springbootauth.controller.dto.RolUsuarioDTO;
import com.luchoauth.springbootauth.modelodatos.modelo.RolUsuarioVO;

public class RolUsuarioConverter {

	private RolUsuarioConverter() {
		throw new IllegalStateException("Clase converter sin constructor");
	}
	
	public static List<RolUsuarioVO> convertirDtoAVo(List<RolUsuarioDTO> listaRolUsuarioDto, boolean completo) {
		List<RolUsuarioVO> listaRolUsuario = new ArrayList<>();
		if(listaRolUsuarioDto != null)
			for(RolUsuarioDTO rolUsuarioDto :listaRolUsuarioDto) {
				listaRolUsuario.add(convertir(rolUsuarioDto,completo));
			}
		return listaRolUsuario;
	}
	
	public static RolUsuarioVO convertir(RolUsuarioDTO rolUsuarioDto, boolean completo) {
		RolUsuarioVO rolUsuario = new RolUsuarioVO();
		rolUsuario.setId(rolUsuarioDto.getId());
		if(completo) {
			rolUsuario.setUsuario(UsuarioConverter.convertir(rolUsuarioDto.getUsuarioDto(),false));
			rolUsuario.setRol(RolConverter.convertir(rolUsuarioDto.getRolDto(),false));
		}
		return rolUsuario;
	}
	
	public static List<RolUsuarioDTO> convertirVoADto(List<RolUsuarioVO> listaRolUsuario,boolean completo) {
		List<RolUsuarioDTO> listaRolUsuarioDto = new ArrayList<>();
		if(listaRolUsuario != null)
			for(RolUsuarioVO rolUsuario :listaRolUsuario) {
				listaRolUsuarioDto.add(convertir(rolUsuario,completo));
			}
		return listaRolUsuarioDto;
	}
	
	public static RolUsuarioDTO convertir(RolUsuarioVO rolUsuario, boolean completo) {
		RolUsuarioDTO rolUsuarioDto = new RolUsuarioDTO();
		rolUsuarioDto.setId(rolUsuario.getId());
		if(completo) {
			rolUsuarioDto.setUsuarioDto(UsuarioConverter.convertir(rolUsuario.getUsuario(),false));
			rolUsuarioDto.setRolDto(RolConverter.convertir(rolUsuario.getRol(),false));
		}
		return rolUsuarioDto;
	}
}
