package com.luchoauth.springbootauth.service;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.luchoauth.springbootauth.controller.IPermisoServiceUrlController;
import com.luchoauth.springbootauth.service.request.CrearProyectoRolPermisoUrlRequest;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/api/permisoUrl")
public class RestPermisoUrl extends RestValidatorHeader {

	private static Logger logger = LoggerFactory.getLogger(RestPermisoUrl.class);
	
	@Autowired
	private IPermisoServiceUrlController permisoServiceUrlController;
	
	@PostMapping
	public ResponseEntity<?> crearPermisoServiceUrl(@RequestBody CrearProyectoRolPermisoUrlRequest crearProyectoRolPermisoUrlRequest, HttpServletRequest request) {
		try {
			if (validarAutenticacion(request)) {
				return ResponseEntity.ok(permisoServiceUrlController.crearPermisoServiceUrl(crearProyectoRolPermisoUrlRequest.getPermisoServiceUrlDto(),crearProyectoRolPermisoUrlRequest.getRolDto()));
			} else {
				return new ResponseEntity<>("No tiene los permisos suficientes ", HttpStatus.UNAUTHORIZED);
			}
		} catch(Exception excepcion) {
			logger.error(excepcion.getMessage());
			return new ResponseEntity<>(excepcion.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value = "/rol", produces = MediaType.APPLICATION_JSON_VALUE, params = "rol")
	public ResponseEntity<?> consultarPermisosUrlRol(@RequestParam("rol") Integer id, HttpServletRequest request) {
		try {
			if (validarAutenticacion(request)) {
				return ResponseEntity.ok(permisoServiceUrlController.consultarPermisoServiceUrlPorRol(id));
			} else {
				return new ResponseEntity<>("No tiene los permisos suficientes ", HttpStatus.UNAUTHORIZED);
			}
		} catch(Exception excepcion) {
			logger.error(excepcion.getMessage());
			return new ResponseEntity<>(excepcion.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
