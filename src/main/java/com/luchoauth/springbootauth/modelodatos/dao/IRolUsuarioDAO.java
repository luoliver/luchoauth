package com.luchoauth.springbootauth.modelodatos.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luchoauth.springbootauth.modelodatos.modelo.RolUsuarioVO;
import com.luchoauth.springbootauth.modelodatos.modelo.UsuarioVO;

public interface IRolUsuarioDAO  extends JpaRepository<RolUsuarioVO, Integer>{

	public List<RolUsuarioVO> findByUsuario(UsuarioVO usuario);
}
