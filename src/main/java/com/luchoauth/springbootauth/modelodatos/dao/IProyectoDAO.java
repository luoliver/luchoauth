package com.luchoauth.springbootauth.modelodatos.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luchoauth.springbootauth.modelodatos.modelo.ProyectoVO;

public interface IProyectoDAO  extends JpaRepository<ProyectoVO, Integer>{

	/**
	 * 
	 * @param nombre
	 * @return
	 */
	public ProyectoVO findByNombre(String nombre);
	
}
