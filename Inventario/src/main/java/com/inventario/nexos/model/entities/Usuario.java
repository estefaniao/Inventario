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
@Table(name = "tbl_usuario", schema = "inventario")
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idusuario")
	private Long idUsuario;
	
	@Column(name="nombre")
	private String nombreUsuario;
	
	@Column(name="edad")
	private Long edadUsuario;
	
	@Column(name="idcargo")
	private Long cargoUsuario;
	
	@Column(name="fecha_ingreso")
	private Date fechaIngreso;
}
