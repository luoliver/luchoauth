package com.luchoauth.springbootauth.modelodatos.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luchoauth.springbootauth.modelodatos.modelo.PermisoVO;

public interface IPermisoDAO extends JpaRepository<PermisoVO, Integer>{

}
