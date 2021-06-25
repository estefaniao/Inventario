package com.inventario.nexos.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inventario.nexos.model.dao.IMercanciaDao;
import com.inventario.nexos.model.entities.Mercancia;

@Service
public class MercanciaService implements IMercanciaService {

	@Autowired
	private IMercanciaDao mercanciaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Mercancia> findAll() {
		return (List<Mercancia>) mercanciaDao.findAll();
	}

	@Override
	@Transactional
	public Mercancia guardar(Mercancia mercancia) {
		return mercanciaDao.save(mercancia);
	}

	@Override
	@Transactional
	public void eliminar(Long mercancia) {
		mercanciaDao.deleteById(mercancia);
	}

	@Override
	@Transactional(readOnly = true)
	public Mercancia encontrarMercancia(Long mercancia) {
		return mercanciaDao.findById(mercancia).orElse(null);
	}

}
