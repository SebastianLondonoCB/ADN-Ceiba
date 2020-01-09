package com.ceiba.testdatabuilder;

import com.ceiba.modelo.entidad.DetalleFactura;

public class DetalleFacturaTestDataBuilder {

	// Encabezado de la factura
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

	public DetalleFacturaTestDataBuilder() {
		this.idFactura = "FACT-1";
		this.codigoProducto = "01";
		this.descripcionProducto = "ESTUCHE SILI CONCASE VERDE";
		this.precioUnitario = 20000.0;
		this.cantidad = 1.0;
		this.subtotal = 20000.0;
		this.porcentajeIva = 0;
		this.precioIva = 0.0;
		this.precioTotal = 20000.0;
		this.precioCompra = 16000.0;
		this.utilidad = 4000.0;
	}

	public DetalleFacturaTestDataBuilder conIdFactura(String idFactura) {
		this.idFactura = idFactura;
		return this;
	}

	public DetalleFacturaTestDataBuilder conCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
		return this;
	}

	public DetalleFacturaTestDataBuilder conDescripcionProducto(String descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
		return this;
	}

	public DetalleFacturaTestDataBuilder conPrecioUnitario(Double precioUnitario) {
		this.precioUnitario = precioUnitario;
		return this;
	}

	public DetalleFacturaTestDataBuilder conCantidad(Double cantidad) {
		this.cantidad = cantidad;
		return this;
	}
	
	public DetalleFacturaTestDataBuilder conSubtotal(Double subtotal) {
		this.subtotal = subtotal;
		return this;
	}

	public DetalleFacturaTestDataBuilder conPorcentajeIva(Integer porcentajeIva) {
		this.porcentajeIva = porcentajeIva;
		return this;
	}

	public DetalleFacturaTestDataBuilder conPrecioIva(Double precioIva) {
		this.precioIva = precioIva;
		return this;
	}

	public DetalleFacturaTestDataBuilder conPrecioTotal(Double precioTotal) {
		this.precioTotal = precioTotal;
		return this;
	}

	public DetalleFacturaTestDataBuilder conPrecioCompra(Double precioCompra) {
		this.precioCompra = precioCompra;
		return this;
	}

	public DetalleFacturaTestDataBuilder conUtilidad(Double utilidad) {
		this.utilidad = utilidad;
		return this;
	}

	public DetalleFactura build() {
		return new DetalleFactura(idFactura, codigoProducto, descripcionProducto, precioUnitario, cantidad, subtotal,
				porcentajeIva, precioIva, precioTotal, precioCompra, utilidad);
	}
}
