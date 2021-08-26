package com.luchoauth.springbootauth.controller;

import java.util.List;

import com.luchoauth.springbootauth.controller.dto.ProyectoDTO;
import com.luchoauth.springbootauth.utilidades.excepciones.ExcepcionesPersonalizadas;

public interface IProyectoController {

	/**
	 * 
	 * @param proyectoDto
	 * @return
	 * @throws ExcepcionesPersonalizadas 
	 */
	public ProyectoDTO crearProyecto(ProyectoDTO proyectoDto) throws ExcepcionesPersonalizadas;
	
	/**
	 * 
	 * @return
	 */
	public List<ProyectoDTO> obtenerProyectos();
	
	/**
	 * 
	 * @param nombre
	 * @return
	 */
	public ProyectoDTO consultarProyectoPorNombre(String nombre);
}
