package com.luchoauth.springbootauth.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luchoauth.springbootauth.controller.ITipoDocumentoController;

@RestController
@RequestMapping("/api/tipodocumento")
public class RestTipoDocumentoService {

	private static Logger LOGGER = LoggerFactory.getLogger(RestTipoDocumentoService.class);
	
	@Autowired
	private ITipoDocumentoController tipoDocumentoController;
	
	@GetMapping
	public ResponseEntity<?> listarTipoDocumentos(){
		try {
			return ResponseEntity.ok(tipoDocumentoController.consultarTiposDocumento());
		} catch(Exception excepcion) {
			LOGGER.error(excepcion.getMessage());
			return new ResponseEntity<>(excepcion.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
}
