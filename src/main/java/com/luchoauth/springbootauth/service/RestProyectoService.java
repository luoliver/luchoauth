package com.luchoauth.springbootauth.service;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luchoauth.springbootauth.controller.IProyectoController;
import com.luchoauth.springbootauth.controller.dto.ProyectoDTO;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/api/proyecto")
public class RestProyectoService extends RestValidatorHeader{

	private static Logger logger = LoggerFactory.getLogger(RestProyectoService.class);
	
	@Autowired
	private IProyectoController proyectoController;
	
	@PostMapping
	public ResponseEntity<?> crearProyecto(@RequestBody ProyectoDTO proyectoDto,HttpServletRequest request) {
		try {
			if (validarAutenticacion(request)) {
				return ResponseEntity.ok(proyectoController.crearProyecto(proyectoDto));
			} else {
				return new ResponseEntity<>("No tiene los permisos suficientes ", HttpStatus.UNAUTHORIZED);
			}
		} catch(Exception excepcion) {
			logger.error(excepcion.getMessage());
			return new ResponseEntity<>(excepcion.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping
	public ResponseEntity<?> obtenerProyectos(HttpServletRequest request) {
		try {
			if (validarAutenticacion(request)) {
				return ResponseEntity.ok(proyectoController.obtenerProyectos());
			} else {
				return new ResponseEntity<>("No tiene los permisos suficientes ", HttpStatus.UNAUTHORIZED);
			}
		} catch(Exception excepcion) {
			logger.error(excepcion.getMessage());
			return new ResponseEntity<>(excepcion.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
