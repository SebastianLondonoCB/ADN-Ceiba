package com.ceiba.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class DtoDetalleFactura {
	//Detalle de la factura
	private String idFactura;
	private String codigoProducto;
	private String descripcionProducto;
	private Double precioUnitario;
	private Double cantidad;
	private Double subtotal;
	private Integer porcentajeIva;
	private Double precioIva;
	private Double precioTotal;
	private Double precioCompra;
	private Double utilidad;
	
	public DtoDetalleFactura() {
		// TODO Auto-generated constructor stub
	}
}
