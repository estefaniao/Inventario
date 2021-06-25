package com.inventario.nexos.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.inventario.nexos.model.entities.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long> {

}
