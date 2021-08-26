package com.luchoauth.springbootauth.controller;

import com.luchoauth.springbootauth.controller.dto.UsuarioDTO;

public interface IUsuarioController {

	/**
	 * 
	 * @param usuario
	 * @return
	 */
	public UsuarioDTO consultarPorUsuario(String usuario);
	
}
