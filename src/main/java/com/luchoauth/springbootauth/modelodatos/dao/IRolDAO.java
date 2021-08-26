package com.luchoauth.springbootauth.modelodatos.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luchoauth.springbootauth.modelodatos.modelo.ProyectoVO;
import com.luchoauth.springbootauth.modelodatos.modelo.RolVO;

public interface IRolDAO  extends JpaRepository<RolVO, Integer>{

	/**
	 * 
	 * @param nombre
	 * @return
	 */
	public List<RolVO> findByNombre(String nombre);
	
	/**
	 * 
	 * @param proyecto
	 * @return
	 */
	public List<RolVO> findByProyecto(ProyectoVO proyecto);
	
}
