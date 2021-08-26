package com.luchoauth.springbootauth.utilidades.converters;

import java.util.ArrayList;
import java.util.List;

import com.luchoauth.springbootauth.controller.dto.TipoDocumentoDTO;
import com.luchoauth.springbootauth.modelodatos.modelo.TipoDocumentoVO;

public class TipoDocumentoConverter {

	private TipoDocumentoConverter() {
		throw new IllegalStateException("Clase converter sin constructor");
	}
	
	public static List<TipoDocumentoVO> convertirDtoAVo(List<TipoDocumentoDTO> listaTipoDocumentoDto,boolean completo) {
		List<TipoDocumentoVO> listaTipoDocumento = new ArrayList<>();
		if(listaTipoDocumentoDto != null)
			for(TipoDocumentoDTO tipoDocumentoDto :listaTipoDocumentoDto) {
				listaTipoDocumento.add(convertir(tipoDocumentoDto,completo));
			}
		return listaTipoDocumento;
	}
	
	public static TipoDocumentoVO convertir(TipoDocumentoDTO tipoDocumentoDto, boolean completo) {
		TipoDocumentoVO tipoDocumento = new TipoDocumentoVO();
		tipoDocumento.setCodigo(tipoDocumentoDto.getCodigo());
		tipoDocumento.setNombre(tipoDocumentoDto.getNombre());
		tipoDocumento.setDescripcion(tipoDocumentoDto.getDescripcion());
		if(completo)
			tipoDocumento.setListaPersonas(PersonaConverter.convertirDtoAVo(tipoDocumentoDto.getListaPersonasDto(),false));
		return tipoDocumento;
	}
	
	public static List<TipoDocumentoDTO> convertirVoADto(List<TipoDocumentoVO> listaTipoDocumento, boolean completo) {
		List<TipoDocumentoDTO> listaTipoDocumentoDto = new ArrayList<>();
		if(listaTipoDocumento != null)
			for(TipoDocumentoVO tipoDocumento :listaTipoDocumento) {
				listaTipoDocumentoDto.add(convertir(tipoDocumento,completo));
			}
		return listaTipoDocumentoDto;
	}
	
	public static TipoDocumentoDTO convertir(TipoDocumentoVO tipoDocumento, boolean completo) {
		TipoDocumentoDTO tipoDocumentoDto = new TipoDocumentoDTO();
		tipoDocumentoDto.setCodigo(tipoDocumento.getCodigo());
		tipoDocumentoDto.setNombre(tipoDocumento.getNombre());
		tipoDocumentoDto.setDescripcion(tipoDocumento.getDescripcion());
		if(completo)
			tipoDocumentoDto.setListaPersonasDto(PersonaConverter.convertirVoADto(tipoDocumento.getListaPersonas(),false));
		return tipoDocumentoDto;
	}
	
}
