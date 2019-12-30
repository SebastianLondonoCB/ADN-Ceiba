package com.ceiba.testdatabuilder;

import com.ceiba.comando.ComandoDetalleFactura;
import com.ceiba.modelo.entidad.DetalleFactura;

public class ComandoDetalleFacturaTestDataBuilder {

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

	public ComandoDetalleFacturaTestDataBuilder() {
		this.idFactura = "FACT-1";
		this.codigoProducto = "01";
		this.descripcionProducto = "ESTUCHE SILI CONCASE VERDE";
		this.precioUnitario = 20000.0;
		this.cantidad = 1.0;
		this.porcentajeIva = 0;
		this.precioIva = 0.0;
		this.precioTotal = 20000.0;
		this.precioCompra = 16000.0;
		this.utilidad = 4000.0;
	}

	public ComandoDetalleFacturaTestDataBuilder conIdFactura(String idFactura) {
		this.idFactura = idFactura;
		return this;
	}

	public ComandoDetalleFacturaTestDataBuilder conCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
		return this;
	}

	public ComandoDetalleFacturaTestDataBuilder conDescripcionProducto(String descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
		return this;
	}

	public ComandoDetalleFacturaTestDataBuilder conPrecioUnitario(Double precioUnitario) {
		this.precioUnitario = precioUnitario;
		return this;
	}

	public ComandoDetalleFacturaTestDataBuilder conCantidad(Double cantidad) {
		this.cantidad = cantidad;
		return this;
	}

	public ComandoDetalleFacturaTestDataBuilder conPorcentajeIva(Integer porcentajeIva) {
		this.porcentajeIva = porcentajeIva;
		return this;
	}

	public ComandoDetalleFacturaTestDataBuilder conPrecioIva(Double precioIva) {
		this.precioIva = precioIva;
		return this;
	}

	public ComandoDetalleFacturaTestDataBuilder conPrecioTotal(Double precioTotal) {
		this.precioTotal = precioTotal;
		return this;
	}

	public ComandoDetalleFacturaTestDataBuilder conPrecioCompra(Double precioCompra) {
		this.precioCompra = precioCompra;
		return this;
	}

	public ComandoDetalleFacturaTestDataBuilder conUtilidad(Double utilidad) {
		this.utilidad = utilidad;
		return this;
	}

	public ComandoDetalleFactura build() {
		return new ComandoDetalleFactura(idFactura, codigoProducto, descripcionProducto, precioUnitario, cantidad,
				porcentajeIva, precioIva, precioTotal, precioCompra, utilidad);
	}

}
