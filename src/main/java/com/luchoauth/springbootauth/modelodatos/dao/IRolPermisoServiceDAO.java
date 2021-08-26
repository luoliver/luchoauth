package com.luchoauth.springbootauth.modelodatos.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luchoauth.springbootauth.modelodatos.modelo.RolVO;
import com.luchoauth.springbootauth.modelodatos.modelo.RolPermisoServiceVO;

public interface IRolPermisoServiceDAO  extends JpaRepository<RolPermisoServiceVO, Integer>{

	public List<RolPermisoServiceVO> findByRol(RolVO rol);
}
