package com.inventario.nexos.model.services;

import java.util.List;

import com.inventario.nexos.model.entities.Cargo;

public interface ICargoService {

	public Cargo findById(Long id);
	public List<Cargo> findAll();
	public Cargo guardar(Cargo cargo);
	public void eliminar(Long cargo);
	
}
