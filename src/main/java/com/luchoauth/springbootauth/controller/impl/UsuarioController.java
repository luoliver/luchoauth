package com.luchoauth.springbootauth.controller.impl;

import org.hibernate.collection.internal.PersistentBag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.luchoauth.springbootauth.controller.IUsuarioController;
import com.luchoauth.springbootauth.controller.dto.UsuarioDTO;
import com.luchoauth.springbootauth.modelodatos.dao.IRolUsuarioDAO;
import com.luchoauth.springbootauth.modelodatos.dao.IUsuarioDAO;
import com.luchoauth.springbootauth.modelodatos.modelo.UsuarioVO;
import com.luchoauth.springbootauth.utilidades.converters.RolUsuarioConverter;
import com.luchoauth.springbootauth.utilidades.converters.UsuarioConverter;

@Service
public class UsuarioController implements IUsuarioController{

	@Autowired
	private IUsuarioDAO usuarioDao;
	@Autowired
	private IRolUsuarioDAO rolUsuarioDao;
	
	@Override
	public UsuarioDTO consultarPorUsuario(String usuario) {
		UsuarioVO resultado = usuarioDao.findByUsuario(usuario);
		if(resultado == null)
			throw new UsernameNotFoundException("No se encontro usuario con el nombre de usuario : " + usuario);
		if(resultado.getListaRolUsuario().getClass().equals(PersistentBag.class))
			resultado.setListaRolUsuario(rolUsuarioDao.findByUsuario(resultado));
		UsuarioDTO usuarioDto = UsuarioConverter.convertir(resultado,true);
		usuarioDto.setListaRolUsuarioDto(RolUsuarioConverter.convertirVoADto(resultado.getListaRolUsuario(),true));
		return usuarioDto;
	}

}
