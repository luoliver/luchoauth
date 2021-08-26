package com.luchoauth.springbootauth.controller;

import java.util.List;

import com.luchoauth.springbootauth.controller.dto.ProyectoDTO;
import com.luchoauth.springbootauth.controller.dto.RolDTO;
import com.luchoauth.springbootauth.utilidades.excepciones.ExcepcionesPersonalizadas;

public interface IRolController {

	/**
	 * 
	 * @param proyectoDto
	 * @return
	 */
	public List<RolDTO> consultarRolPorProyecto(ProyectoDTO proyectoDto);
	
	/**
	 * 
	 * @param rolDto
	 * @return
	 * @throws ExcepcionesPersonalizadas 
	 */
	public RolDTO crearRol(RolDTO rolDto) throws ExcepcionesPersonalizadas;
	
	/**
	 * 
	 * @param proyectoDto
	 * @param nombre
	 * @return
	 */
	public RolDTO consultarRolPorProyectoYNombre(ProyectoDTO proyectoDto, String nombre);
	
}
