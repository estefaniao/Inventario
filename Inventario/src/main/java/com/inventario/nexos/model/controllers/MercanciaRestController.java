package com.inventario.nexos.model.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventario.nexos.model.constantes.CodigoError;
import com.inventario.nexos.model.entities.Mercancia;
import com.inventario.nexos.model.services.IMercanciaService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/productos")
public class MercanciaRestController {
	
	@Autowired
	private IMercanciaService mercanciaService;
	
	@GetMapping("/")
	public ResponseEntity<?> listarMercancia(){
		return respuesta(mercanciaService.findAll(), CodigoError.PRODUCTO_EMPTY, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> encontrarMercancia(@PathVariable Long id) {
		return respuesta(mercanciaService.encontrarMercancia(id), CodigoError.PRODUCTO_EMPTY, HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<?> guardar(@RequestBody Mercancia mercancia) {
		mercancia.setUsuarioRegistro(mercancia.getUsuarioPeticion());
		mercancia.setFechaPeticion(new Date());
		return respuesta(mercanciaService.guardar(mercancia), CodigoError.PRODUCTO_NOT_SAVED, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?>  editar(@RequestBody Mercancia mercancia, @PathVariable Long id) {
		mercancia.setIdMercancia(id);
		mercancia.setFechaPeticion(new Date());
		return respuesta(mercanciaService.guardar(mercancia), CodigoError.PRODUCTO_NOT_UPDATED, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}&{usuario}")
	public ResponseEntity<?> eliminar(@PathVariable Long usuario, @PathVariable Long id) {
		Mercancia mercanciaEliminada = mercanciaService.encontrarMercancia(id);
		if(mercanciaEliminada!=null && mercanciaEliminada.getUsuarioRegistro().equals(usuario)) {
			mercanciaService.eliminar(id);
		}else {
			mercanciaEliminada = null;
		}
		return respuesta(mercanciaEliminada, CodigoError.PRODUTO_NOT_DELETED, HttpStatus.OK);
	}
	
	private ResponseEntity<?> respuesta(Object obj, CodigoError errorRecibido, HttpStatus httpStatus){
			Map<String, Object> resultado = new HashMap<>();
			if(obj == null) {
				Map<String, String> error = new HashMap<>();
				error.put("errorCode", errorRecibido.getErrorCode());
				error.put("process", errorRecibido.getProcess());
				error.put("description", errorRecibido.getDescription());
				resultado.put("errors", error);
				resultado.put("status", false);
				resultado.put("data", null);
				httpStatus = HttpStatus.NOT_FOUND;
			}else {
				resultado.put("status", true);
				resultado.put("data", obj);
			}
			return new ResponseEntity<>(resultado, httpStatus);
	}
}
