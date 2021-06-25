package com.inventario.nexos.model.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventario.nexos.model.constantes.CodigoError;
import com.inventario.nexos.model.services.ICargoService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/cargo")
public class CargoRestController {

	@Autowired
	private ICargoService cargoService;
	
	@GetMapping("/")
	public ResponseEntity<?> listarCargos(){
		return respuesta(cargoService.findAll(), CodigoError.CARGO_EMPTY, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> encontrarCargo(@PathVariable Long id) {
		return respuesta(cargoService.findById(id), CodigoError.PRODUCTO_EMPTY, HttpStatus.OK);
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
