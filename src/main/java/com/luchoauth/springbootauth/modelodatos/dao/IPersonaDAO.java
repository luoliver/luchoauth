package com.luchoauth.springbootauth.modelodatos.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luchoauth.springbootauth.modelodatos.modelo.PersonaVO;

public interface IPersonaDAO  extends JpaRepository<PersonaVO, Integer>{

}
