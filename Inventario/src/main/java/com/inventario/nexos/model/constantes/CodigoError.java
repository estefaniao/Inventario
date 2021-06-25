package com.inventario.nexos.model.constantes;

public enum CodigoError {

	GENERIC("01","Productos","La operación no finalizó correctamente"),
	PRODUCTO_NOT_FOUND("02", "Productos", "Producto no encontrado"),
	PRODUCTO_EMPTY("03", "Productos", "Lista de productos vacía"),
	PRODUCTO_NOT_SAVED("04","Productos","Producto no guardado"),
	PRODUCTO_NOT_UPDATED("05","Productos","Producto no actualizado"),
	PRODUTO_NOT_DELETED("06","Productos","Producto no eliminado"),
	CARGO_EMPTY("03", "Productos", "Lista de cargos vacía"),
	USUARIO_EMPTY("03", "Productos", "Lista de usuarios vacía");
	
	private final String errorCode;
	private final String process;
	private final String description;
	
	private CodigoError(String errorCode, String process, String description) {
		this.errorCode = errorCode;
		this.process = process;
		this.description = description;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public String getProcess() {
		return process;
	}
	public String getDescription() {
		return description;
	}
}
