package com.luchoauth.springbootauth.controller;

import java.util.List;

import com.luchoauth.springbootauth.modelodatos.modelo.TipoDocumento;

public interface ITipoDocumentoController {

	/**
	 * Metodo que se encarga de consultar todos los tipos de documento del sistema
	 * 
	 * @return List<TipoDocumento>
	 */
	public List<TipoDocumento> consultarTiposDocumento();

}
