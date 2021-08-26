package com.luchoauth.springbootauth.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.luchoauth.springbootauth.controller.IProyectoController;
import com.luchoauth.springbootauth.controller.IUsuarioController;
import com.luchoauth.springbootauth.controller.dto.ProyectoDTO;
import com.luchoauth.springbootauth.controller.dto.RolDTO;
import com.luchoauth.springbootauth.controller.dto.UsuarioDTO;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private IUsuarioController usuarioController;
	
	@Autowired
	private IProyectoController proyectoController;
	
	@Override
	public UserDetailsImpl loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			String[] temporalSubString = username.split(";"); 
			UsuarioDTO usuario = usuarioController.consultarPorUsuario(temporalSubString[0]);
			ProyectoDTO proyectoDto = proyectoController.consultarProyectoPorNombre(temporalSubString[2]);
			RolDTO rolDto = null;
			for(RolDTO rol :proyectoDto.getListaRolProyectoDto())
				if(rol.getNombre().equals(temporalSubString[1])) {
					rolDto = rol;
				}
			return UserDetailsImpl.build(usuario, rolDto,proyectoDto);
		}catch (Exception excepcion) {
			throw new UsernameNotFoundException("Error loadUserByUsername excepcion ",excepcion);
		}
	}

}
