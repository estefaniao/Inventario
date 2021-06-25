package com.inventario.nexos.model.services;

import java.util.List;

import com.inventario.nexos.model.entities.Mercancia;

public interface IMercanciaService {

	public List<Mercancia> findAll();
	public Mercancia guardar(Mercancia mercancia);
	public void eliminar(Long mercancia);
	public Mercancia encontrarMercancia(Long mercancia);
}
