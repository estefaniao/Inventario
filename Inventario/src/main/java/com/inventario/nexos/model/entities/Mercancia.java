package com.inventario.nexos.model.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tbl_mercancia", schema = "inventario")
public class Mercancia implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idmercancia")
	private Long idMercancia;
	
	@Column(name="nombre")
	private String nombreProducto;
	
	@Column(name="cantidad")
	private Long cantidad;
	
	@Column(name="fecha_ingreso")
	private Date fechaIngreso;
	
	@Column(name="usuario_registro")
	private Long usuarioRegistro;
	
	@Column(name="usuario_peticion")
	private Long usuarioPeticion;
	
	@Column(name="fecha_peticion")
	private Date fechaPeticion;
	
}
