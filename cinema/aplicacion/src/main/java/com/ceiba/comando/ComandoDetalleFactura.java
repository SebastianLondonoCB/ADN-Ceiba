package com.ceiba.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoDetalleFactura {
	//Detalle de la factura
	private String idFactura;
	private String codigoProducto;
	private String descripcionProducto;
	private Double precioUnitario;
	private Double cantidad;
	private Integer porcentajeIva;
	private Double precioIva;
	private Double precioTotal;
	private Double precioCompra;
	private Double utilidad;
}

