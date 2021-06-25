package com.inventario.nexos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.inventario.nexos.model.controllers.MercanciaRestController;
import com.inventario.nexos.model.dao.IMercanciaDao;
import com.inventario.nexos.model.entities.Mercancia;
import com.inventario.nexos.model.services.MercanciaService;

@SpringBootTest
class InventarioServicesApplicationTests {
	
	@InjectMocks
	private MercanciaRestController mercanciaController;
	
	@Mock
	private MercanciaService mercanciaService;
	
	@Mock
	private IMercanciaDao mercanciaDao;
	
	@Mock
	private Mercancia mercancia;
	
	private List<Mercancia> productos;
	
	private Mercancia producto;
	
	private Long idMercancia;
	private Date fecha;
	
	@BeforeEach
	public void setUp() {
		idMercancia = 1L;
		fecha = new Date();
		producto = construirProducto();
	}

	@Test
	void debeConsultarProductos() {
		when(mercanciaService.findAll()).thenReturn(productos);
		mercanciaController.listarMercancia();
		verify(mercanciaService).findAll();
	}
	
	@Test
	void debeConsultarProductoPorID() {
		when(mercanciaService.encontrarMercancia(idMercancia)).thenReturn(producto);
		mercanciaController.encontrarMercancia(idMercancia);
		verify(mercanciaService).encontrarMercancia(idMercancia);
		assertNotNull(producto.toString());
		assertFalse(producto.equals(new Mercancia()));
		assertNotEquals(producto.hashCode(),0);
		assertEquals(producto, construirProducto());
	}
	
	@Test
	void debeGuardarProducto() {
		when(mercanciaService.guardar(mercancia)).thenReturn(producto);
		mercanciaController.guardar(mercancia);
		verify(mercanciaService).guardar(mercancia);
	}
	
	@Test
	void debeEliminarProducto() {
		when(mercanciaService.encontrarMercancia(mercancia.getIdMercancia())).thenReturn(producto);
		mercanciaController.eliminar(producto.getUsuarioRegistro(), producto.getIdMercancia());
		verify(mercanciaService).encontrarMercancia(idMercancia);
	}
	
	public Mercancia construirProducto() {
		Mercancia producto = new Mercancia();
		producto.setIdMercancia(idMercancia);
		producto.setCantidad(idMercancia);
		producto.setFechaIngreso(fecha);
		producto.setFechaPeticion(fecha);
		producto.setNombreProducto("ProductoTest");
		producto.setUsuarioPeticion(idMercancia);
		producto.setUsuarioRegistro(idMercancia);
		return producto;
	}
	
}
