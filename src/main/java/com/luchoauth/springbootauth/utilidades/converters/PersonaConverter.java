package com.luchoauth.springbootauth.utilidades.converters;

import java.util.ArrayList;
import java.util.List;

import com.luchoauth.springbootauth.controller.dto.PersonaDTO;
import com.luchoauth.springbootauth.modelodatos.modelo.PersonaVO;

public class PersonaConverter {

	private PersonaConverter() {
		throw new IllegalStateException("Clase converter sin constructor");
	}
	
	public static List<PersonaVO> convertirDtoAVo(List<PersonaDTO> listaPersonaDto,boolean completo) {
		List<PersonaVO> listaPersona = new ArrayList<>();
		if(listaPersonaDto != null)
			for(PersonaDTO personaDto :listaPersonaDto) {
				listaPersona.add(convertir(personaDto,completo));
			}
		return listaPersona;
	}
	
	public static PersonaVO convertir(PersonaDTO personaDto,boolean completo) {
		PersonaVO persona = new PersonaVO();
		persona.setId(personaDto.getId());
		persona.setNumeroDocumento(personaDto.getNumeroDocumento());
		persona.setPrimerApellido(personaDto.getPrimerApellido());
		persona.setPrimerNombre(personaDto.getPrimerNombre());
		persona.setSegundoApellido(personaDto.getSegundoApellido());
		persona.setSegundoNombre(personaDto.getSegundoNombre());
		if(completo) {
			persona.setTipoDocumento(TipoDocumentoConverter.convertir(personaDto.getTipoDocumentoDto(),false));
			persona.setUsuario(UsuarioConverter.convertir(personaDto.getUsuarioDto(),false));
		}
		return persona;
	}
	
	public static List<PersonaDTO> convertirVoADto(List<PersonaVO> listaPersona,boolean completo) {
		List<PersonaDTO> listaPersonaDto = new ArrayList<>();
		if(listaPersona != null)
			for(PersonaVO persona :listaPersona) {
				listaPersonaDto.add(convertir(persona,completo));
			}
		return listaPersonaDto;
	}
	
	public static PersonaDTO convertir(PersonaVO persona,boolean completo) {
		PersonaDTO personaDto = new PersonaDTO();
		personaDto.setId(personaDto.getId());
		personaDto.setNumeroDocumento(persona.getNumeroDocumento());
		personaDto.setPrimerApellido(persona.getPrimerApellido());
		personaDto.setPrimerNombre(persona.getPrimerNombre());
		personaDto.setSegundoApellido(persona.getSegundoApellido());
		personaDto.setSegundoNombre(persona.getSegundoNombre());
		if(completo) {
			personaDto.setTipoDocumentoDto(TipoDocumentoConverter.convertir(persona.getTipoDocumento(),false));
			personaDto.setUsuarioDto(UsuarioConverter.convertir(persona.getUsuario(),false));
		}		
		return personaDto;
	}
}
