package com.ceiba.testdatabuilder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ceiba.comando.ComandoCliente;
import com.ceiba.comando.ComandoFactura;
import com.ceiba.modelo.dto.DtoDetalleFactura;
import com.ceiba.modelo.entidad.Factura;

public class ComandoFacturaTestDataBuilder {

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

	public ComandoFacturaTestDataBuilder() {

		Date fechaFactura = null;
		try {
			fechaFactura = new SimpleDateFormat("dd/MM/yyyy").parse("28/12/2019");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Date fechaVencimiento = null;
		try {
			fechaVencimiento = new SimpleDateFormat("dd/MM/yyyy").parse("31/12/2019");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		List<DtoDetalleFactura> listado = new ArrayList<DtoDetalleFactura>();
		listado.add(new DtoDetalleFactura("FACT-22555", "01", "ESTUCHE SILI CONCASE VERDE", 20000.0, 1.0, 20000.0, 0, 0.0, 20000.0,
				16000.0, 4000.0));

		this.idFactura = "FACT-22555";
		this.identificacionCliente = "1010";
		this.fechaFactura = fechaFactura;
		this.plazoFactura = 2;
		this.fechaVencimiento = fechaVencimiento;
		this.subtotalFactura = 20000.0;
		this.ivaFactura = 0.0;
		this.descuentosFactura = 0.0;
		this.totalFactura = 20000.0;
		this.utilidadFactura = 4000.0;
		this.detalleFactura = listado;
	}

	public ComandoFacturaTestDataBuilder conIdFactura(String idFactura) {
		this.idFactura = idFactura;
		return this;
	}

	public ComandoFacturaTestDataBuilder conIdentificacionCliente(String identificacionCliente) {
		this.identificacionCliente = identificacionCliente;
		return this;
	}

	public ComandoFacturaTestDataBuilder conFechaFactura(Date fechaFactura) {
		this.fechaFactura = fechaFactura;
		return this;
	}

	public ComandoFacturaTestDataBuilder conPlazoFactura(Integer plazoFactura) {
		this.plazoFactura = plazoFactura;
		return this;
	}

	public ComandoFacturaTestDataBuilder conFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
		return this;
	}

	public ComandoFacturaTestDataBuilder conSubtotalFactura(Double subtotalFactura) {
		this.subtotalFactura = subtotalFactura;
		return this;
	}

	public ComandoFacturaTestDataBuilder conIvaFactura(Double ivaFactura) {
		this.ivaFactura = ivaFactura;
		return this;
	}

	public ComandoFacturaTestDataBuilder conDescuentosFactura(Double descuentosFactura) {
		this.subtotalFactura = descuentosFactura;
		return this;
	}

	public ComandoFacturaTestDataBuilder conTotalFactura(Double totalFactura) {
		this.totalFactura = totalFactura;
		return this;
	}

	public ComandoFacturaTestDataBuilder conUtilidadFactura(Double utilidadFactura) {
		this.utilidadFactura = utilidadFactura;
		return this;
	}

	public ComandoFacturaTestDataBuilder conDetalleFactura(List<DtoDetalleFactura> detalleFactura) {
		this.detalleFactura = detalleFactura;
		return this;
	}

	public ComandoFactura build() {
		return new ComandoFactura(idFactura, identificacionCliente, fechaFactura, plazoFactura, fechaVencimiento,
				subtotalFactura, ivaFactura, descuentosFactura, totalFactura, utilidadFactura, detalleFactura);
	}

}
