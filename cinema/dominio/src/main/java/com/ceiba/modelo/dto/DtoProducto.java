package com.ceiba.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class DtoProducto {
	private String codigo;
	private String descripcion;
	private String grupo;
	private Integer ivaVenta;
	private Double lista1;
	private Double lista2;
	private Double precioCompra;
}
