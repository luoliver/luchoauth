package com.luchoauth.springbootauth.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luchoauth.springbootauth.controller.ITipoDocumentoController;
import com.luchoauth.springbootauth.modelodatos.dao.ITipoDocumentoDao;
import com.luchoauth.springbootauth.modelodatos.modelo.TipoDocumento;

@Service
public class TipoDocumentoController implements ITipoDocumentoController {

	@Autowired
	private ITipoDocumentoDao tipoDocumentoDao;
	
	@Override
	public List<TipoDocumento> consultarTiposDocumento() {
		return tipoDocumentoDao.findAll();
	}
}
