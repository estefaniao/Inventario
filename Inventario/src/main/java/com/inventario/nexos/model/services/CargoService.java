package com.inventario.nexos.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inventario.nexos.model.dao.ICargoDao;
import com.inventario.nexos.model.entities.Cargo;

@Service
public class CargoService implements ICargoService {

	@Autowired
	private ICargoDao cargoDao;
	
	@Override
	@Transactional(readOnly = true)
	public Cargo findById(Long id) {
		return cargoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cargo> findAll() {
		return (List<Cargo>) cargoDao.findAll();
	}

	@Override
	@Transactional
	public Cargo guardar(Cargo cargo) {
		return cargoDao.save(cargo);
	}

	@Override
	@Transactional
	public void eliminar(Long cargo) {
		cargoDao.deleteById(cargo);
		
	}

	
}
