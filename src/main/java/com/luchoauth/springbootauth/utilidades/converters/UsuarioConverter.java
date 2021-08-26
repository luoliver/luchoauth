package com.luchoauth.springbootauth.utilidades.converters;

import java.util.ArrayList;
import java.util.List;

import com.luchoauth.springbootauth.controller.dto.UsuarioDTO;
import com.luchoauth.springbootauth.modelodatos.modelo.UsuarioVO;

public class UsuarioConverter {

	private UsuarioConverter() {
		throw new IllegalStateException("Clase converter sin constructor");
	}
	
	public static List<UsuarioVO> convertirDtoAVo(List<UsuarioDTO> listaUsuarioDto,boolean completo) {
		List<UsuarioVO> listaUsuario = new ArrayList<>();
		if(listaUsuarioDto != null)
			for(UsuarioDTO UsuarioDto :listaUsuarioDto) {
				listaUsuario.add(convertir(UsuarioDto,completo));
			}
		return listaUsuario;
	}
	
	public static UsuarioVO convertir(UsuarioDTO usuarioDto, boolean completo) {
		UsuarioVO usuario = new UsuarioVO();
		usuario.setId(usuarioDto.getId());
		usuario.setUsuario(usuarioDto.getUsuario());
		usuario.setContrasena(usuarioDto.getContrasena());
		usuario.setCorreoElectronico(usuarioDto.getCorreoElectronico());
		usuario.setConfirmaCorreoElectronico(usuarioDto.getConfirmaCorreoElectronico());
		usuario.setFechaCambioContrasena(usuarioDto.getFechaCambioContrasena());
		if(completo) {
			usuario.setPersona(PersonaConverter.convertir(usuarioDto.getPersonaDto(),false));
			usuario.setListaRolUsuario(RolUsuarioConverter.convertirDtoAVo(usuarioDto.getListaRolUsuarioDto(),false));
		}
		return usuario;
	}
	
	public static List<UsuarioDTO> convertirVoADto(List<UsuarioVO> listaUsuario,boolean completo) {
		List<UsuarioDTO> listaUsuarioDto = new ArrayList<>();
		if(listaUsuario != null)
			for(UsuarioVO Usuario :listaUsuario) {
				listaUsuarioDto.add(convertir(Usuario,completo));
			}
		return listaUsuarioDto;
	}
	
	public static UsuarioDTO convertir(UsuarioVO usuario, boolean completo) {
		UsuarioDTO usuarioDto = new UsuarioDTO();
		usuarioDto.setId(usuario.getId());
		usuarioDto.setUsuario(usuario.getUsuario());
		usuarioDto.setContrasena(usuario.getContrasena());
		usuarioDto.setCorreoElectronico(usuario.getCorreoElectronico());
		usuarioDto.setConfirmaCorreoElectronico(usuario.getConfirmaCorreoElectronico());
		usuarioDto.setFechaCambioContrasena(usuario.getFechaCambioContrasena());
		if(completo) {
			usuarioDto.setPersonaDto(PersonaConverter.convertir(usuario.getPersona(),false));
			usuarioDto.setListaRolUsuarioDto(RolUsuarioConverter.convertirVoADto(usuario.getListaRolUsuario(),false));
		}
		return usuarioDto;
	}
}
