package com.luchoauth.springbootauth.modelodatos.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luchoauth.springbootauth.modelodatos.modelo.TipoDocumento;

public interface ITipoDocumentoDao extends JpaRepository<TipoDocumento, String> {

}
