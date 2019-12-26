package com.ceiba.testdatabuilder;

import com.ceiba.modelo.entidad.Producto;

public class ProductoTestDataBuilder {

	private String codigo;
	private String descripcion;
	private String grupo;
	private Integer ivaVenta;
	private Double precioVenta;
	private Double precioCompra;

	public ProductoTestDataBuilder() {
		this.codigo = "01";
		this.descripcion = "ESTUCHE SILI CONCASE VERDE";
		this.grupo = "ESTUCHES";
		this.ivaVenta = 19;
		this.precioVenta = 40000.0;
		this.precioCompra = 30000.0;
	}

	public ProductoTestDataBuilder conCodigo(String codigo) {
		this.codigo = codigo;
		return this;
	}

	public ProductoTestDataBuilder conDescripcion(String descripcion) {
		this.descripcion = descripcion;
		return this;
	}

	public ProductoTestDataBuilder conGrupo(String grupo) {
		this.grupo = grupo;
		return this;
	}

	public ProductoTestDataBuilder conIva(Integer ivaVenta) {
		this.ivaVenta = ivaVenta;
		return this;
	}

	public ProductoTestDataBuilder conPrecioVenta(Double precioVenta) {
		this.precioVenta = precioVenta;
		return this;
	}

	public ProductoTestDataBuilder conPrecioCompra(Double precioCompra) {
		this.precioCompra = precioCompra;
		return this;
	}

	public Producto build() {
		return new Producto(codigo, descripcion, grupo, ivaVenta, precioVenta, precioCompra);
	}
}
