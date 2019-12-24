package com.ceiba.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoProducto {
	private String codigo;
	private String descripcion;
	private String grupo;
	private Integer ivaVenta;
	private Double lista1;
	private Double lista2;
	private Double precioCompra;
}

