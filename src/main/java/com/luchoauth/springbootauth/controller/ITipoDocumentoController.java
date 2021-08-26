package com.luchoauth.springbootauth.controller;

import java.util.List;

import com.luchoauth.springbootauth.controller.dto.TipoDocumentoDTO;

public interface ITipoDocumentoController {

	/**
	 * Metodo que se encarga de consultar todos los tipos de documento del sistema
	 * 
	 * @return List<TipoDocumentoDTO>
	 */
	public List<TipoDocumentoDTO> consultarTiposDocumento();

}
