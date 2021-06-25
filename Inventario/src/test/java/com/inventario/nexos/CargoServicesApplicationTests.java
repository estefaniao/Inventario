package com.inventario.nexos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import com.inventario.nexos.model.controllers.CargoRestController;
import com.inventario.nexos.model.dao.ICargoDao;
import com.inventario.nexos.model.entities.Cargo;
import com.inventario.nexos.model.services.CargoService;


@SpringBootTest
class CargoServicesApplicationTests {
	
	@InjectMocks
	private CargoRestController cargoController;
	
	@Mock
	private CargoService cargoService;
	
	@Mock
	private ICargoDao cargoDao;
	
	@Mock
	private Cargo cargo;
	
	private List<Cargo> cargos;
	private Cargo cargoActual;
	private Long idCargo;
	
	@BeforeEach
	public void setUp() {
		idCargo = 1L;
		cargoActual = construirCargo();
	}

	@Test
	void debeConsultarCargos() {
		when(cargoService.findAll()).thenReturn(cargos);
		cargoController.listarCargos();
		verify(cargoService).findAll();
	}
	
	@Test
	void debeConsultarCargoPorID() {
		when(cargoService.findById(idCargo)).thenReturn(cargoActual);
		cargoController.encontrarCargo(idCargo);
		verify(cargoService).findById(idCargo);
		assertNotNull(cargoActual.toString());
		assertFalse(cargoActual.equals(new Cargo()));
		assertNotEquals(cargoActual.hashCode(),0);
		assertEquals(cargoActual, construirCargo());
	}
	
	public Cargo construirCargo() {
		Cargo cargo = new Cargo();
		cargo.setIdCargo(idCargo);
		cargo.setNombreCargo("CargoTest");
		return cargo;
	}
	
}
