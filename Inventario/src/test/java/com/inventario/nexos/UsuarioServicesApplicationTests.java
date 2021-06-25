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

import com.inventario.nexos.model.controllers.UsuarioRestController;
import com.inventario.nexos.model.dao.IUsuarioDao;
import com.inventario.nexos.model.entities.Usuario;
import com.inventario.nexos.model.services.UsuarioService;



@SpringBootTest
class UsuarioServicesApplicationTests {
	
	@InjectMocks
	private UsuarioRestController usuarioController;
	
	@Mock
	private UsuarioService usuarioService;
	
	@Mock
	private IUsuarioDao usuarioDao;
	
	@Mock
	private Usuario usuario;
	
	private List<Usuario> usuarios;
	private Usuario usuarioActual;
	private Long idUsuario;
	private Date fecha;
	
	@BeforeEach
	public void setUp() {
		idUsuario = 1L;
		fecha = new Date();
		usuarioActual = construirUsuario();
	}

	@Test
	void debeConsultarUsuarios() {
		when(usuarioService.findAll()).thenReturn(usuarios);
		usuarioController.listarUsuarios();
		verify(usuarioService).findAll();
	}
	
	@Test
	void debeConsultarUsuarioPorID() {
		when(usuarioService.findById(idUsuario)).thenReturn(usuarioActual);
		usuarioController.encontrarUsuario(idUsuario);
		verify(usuarioService).findById(idUsuario);
		assertNotNull(usuarioActual.toString());
		assertFalse(usuarioActual.equals(new Usuario()));
		assertNotEquals(usuarioActual.hashCode(),0);
		assertEquals(usuarioActual, construirUsuario());
	}
	
	public Usuario construirUsuario() {
		Usuario usuario = new Usuario();
		usuario.setCargoUsuario(idUsuario);
		usuario.setEdadUsuario(idUsuario);
		usuario.setFechaIngreso(fecha);
		usuario.setIdUsuario(idUsuario);
		usuario.setNombreUsuario("UsuarioTest");
		return usuario;
	}
	
}
