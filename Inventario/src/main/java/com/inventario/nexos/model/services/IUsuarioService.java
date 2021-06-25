package com.inventario.nexos.model.services;

import java.util.List;
import com.inventario.nexos.model.entities.Usuario;

public interface IUsuarioService {

	public Usuario findById(Long id);
	public List<Usuario> findAll();
	public Usuario guardar(Usuario usuario);
	public void eliminar(Long usuario);
}
