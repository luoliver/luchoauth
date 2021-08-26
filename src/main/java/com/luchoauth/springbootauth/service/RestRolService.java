package com.luchoauth.springbootauth.service;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luchoauth.springbootauth.controller.IRolController;
import com.luchoauth.springbootauth.service.request.CrearProyectoRolPermisoUrlRequest;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/api/rol")
public class RestRolService extends RestValidatorHeader{

	private static Logger logger = LoggerFactory.getLogger(RestRolService.class);
	
	@Autowired
	private IRolController rolController;
	
	@PostMapping
	public ResponseEntity<?> crearRol(@RequestBody CrearProyectoRolPermisoUrlRequest crearProyectoRolPermisoUrlRequest, HttpServletRequest request){
		try {
			if (validarAutenticacion(request)) {
				crearProyectoRolPermisoUrlRequest.getRolDto().setProyectoDto(crearProyectoRolPermisoUrlRequest.getProyectoDto());
				return ResponseEntity.ok(rolController.crearRol(crearProyectoRolPermisoUrlRequest.getRolDto()));
			} else {
				return new ResponseEntity<>("No tiene los permisos suficientes ", HttpStatus.UNAUTHORIZED);
			}
		} catch(Exception excepcion) {
			logger.error(excepcion.getMessage());
			return new ResponseEntity<>(excepcion.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
