package com.luchoauth.springbootauth.modelodatos.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luchoauth.springbootauth.modelodatos.modelo.UsuarioVO;

public interface IUsuarioDAO extends JpaRepository<UsuarioVO, Integer>{

	public UsuarioVO findByUsuario(String usuario);
	
}
