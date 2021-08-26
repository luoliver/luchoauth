package com.luchoauth.springbootauth.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luchoauth.springbootauth.controller.ITipoDocumentoController;
import com.luchoauth.springbootauth.controller.dto.TipoDocumentoDTO;
import com.luchoauth.springbootauth.modelodatos.dao.ITipoDocumentoDAO;
import com.luchoauth.springbootauth.utilidades.converters.TipoDocumentoConverter;

@Service
public class TipoDocumentoController implements ITipoDocumentoController {

	@Autowired
	private ITipoDocumentoDAO tipoDocumentoDao;
	
	@Override
	public List<TipoDocumentoDTO> consultarTiposDocumento() {
		return TipoDocumentoConverter.convertirVoADto(tipoDocumentoDao.findAll(),false);
	}
}
