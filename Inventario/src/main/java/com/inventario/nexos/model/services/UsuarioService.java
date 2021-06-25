package com.inventario.nexos.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inventario.nexos.model.dao.IUsuarioDao;
import com.inventario.nexos.model.entities.Usuario;

@Service
public class UsuarioService implements IUsuarioService {

	@Autowired
	private IUsuarioDao usuarioDao;
	
	@Override
	@Transactional(readOnly = true)
	public Usuario findById(Long id) {
		return usuarioDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findAll() {
		return (List<Usuario>) usuarioDao.findAll();
	}

	@Override
	@Transactional
	public Usuario guardar(Usuario usuario) {
		return usuarioDao.save(usuario);
	}

	@Override
	@Transactional
	public void eliminar(Long usuario) {
		usuarioDao.deleteById(usuario);
	}

	
	
}
