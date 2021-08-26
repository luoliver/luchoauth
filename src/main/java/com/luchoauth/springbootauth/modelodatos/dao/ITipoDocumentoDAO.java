package com.luchoauth.springbootauth.modelodatos.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luchoauth.springbootauth.modelodatos.modelo.TipoDocumentoVO;

public interface ITipoDocumentoDAO extends JpaRepository<TipoDocumentoVO, String> {

}