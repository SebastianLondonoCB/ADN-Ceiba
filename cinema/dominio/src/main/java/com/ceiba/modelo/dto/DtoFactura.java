package com.ceiba.modelo.dto;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class DtoFactura {
	//Encabezado de la factura
	private String idFactura;
	private String identificacionCliente;
	private Date fechaFactura;
	private Integer plazoFactura;
	private Date fechaVencimiento;
	private Double subtotalFactura;
	private Double ivaFactura;
	private Double descuentosFactura;
	private Double totalFactura;
	private Double utilidadFactura;
	
	//Detalle de la factura
	private List<DtoDetalleFactura> detalleFactura;
}
