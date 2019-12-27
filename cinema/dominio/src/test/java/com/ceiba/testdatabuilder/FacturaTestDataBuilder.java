package com.ceiba.testdatabuilder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.ceiba.modelo.dto.DtoDetalleFactura;
import com.ceiba.modelo.entidad.Factura;

public class FacturaTestDataBuilder {

	// Encabezado de la factura
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

	// Detalle de la factura
	private List<DtoDetalleFactura> detalleFactura;

	public FacturaTestDataBuilder() {

		Date fechaFactura = null;
		try {
			fechaFactura = new SimpleDateFormat("dd/MM/yyyy").parse("27/12/2019");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Date fechaVencimiento = null;
		try {
			fechaVencimiento = new SimpleDateFormat("dd/MM/yyyy").parse("30/12/2019");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		this.idFactura = "FACT-1";
		this.identificacionCliente = "1040756785";
		this.fechaFactura = fechaFactura;
		this.plazoFactura = 3;
		this.fechaVencimiento = fechaVencimiento;
		this.subtotalFactura = 20000.0;
		this.ivaFactura = 0.0;
		this.descuentosFactura = 0.0;
		this.totalFactura = 20000.0;
		this.utilidadFactura = 4000.0;
		this.detalleFactura = null;
	}

	public FacturaTestDataBuilder conIdFactura(String idFactura) {
		this.idFactura = idFactura;
		return this;
	}

	public FacturaTestDataBuilder conIdentificacionCliente(String identificacionCliente) {
		this.identificacionCliente = identificacionCliente;
		return this;
	}

	public FacturaTestDataBuilder conFechaFactura(Date fechaFactura) {
		this.fechaFactura = fechaFactura;
		return this;
	}

	public FacturaTestDataBuilder conPlazoFactura(Integer plazoFactura) {
		this.plazoFactura = plazoFactura;
		return this;
	}

	public FacturaTestDataBuilder conFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
		return this;
	}

	public FacturaTestDataBuilder conSubtotalFactura(Double subtotalFactura) {
		this.subtotalFactura = subtotalFactura;
		return this;
	}

	public FacturaTestDataBuilder conIvaFactura(Double ivaFactura) {
		this.ivaFactura = ivaFactura;
		return this;
	}

	public FacturaTestDataBuilder conDescuentosFactura(Double descuentosFactura) {
		this.descuentosFactura = descuentosFactura;
		return this;
	}

	public FacturaTestDataBuilder conTotalFactura(Double totalFactura) {
		this.totalFactura = totalFactura;
		return this;
	}

	public FacturaTestDataBuilder conUtilidadFactura(Double utilidadFactura) {
		this.utilidadFactura = utilidadFactura;
		return this;
	}

	public Factura build() {
		return new Factura(idFactura, identificacionCliente, fechaFactura, plazoFactura, fechaVencimiento,
				subtotalFactura, ivaFactura, descuentosFactura, totalFactura, utilidadFactura, detalleFactura);
	}
}
