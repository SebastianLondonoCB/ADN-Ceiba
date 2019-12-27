package com.ceiba.testdatabuilder;

import com.ceiba.comando.ComandoProducto;
import com.ceiba.modelo.entidad.Producto;

public class ComandoProductoTestDataBuilder {

	private String codigo;
	private String descripcion;
	private String grupo;
	private Integer ivaVenta;
	private Double precioVenta;
	private Double precioCompra;
	
	public ComandoProductoTestDataBuilder() {
		this.codigo = "01";
		this.descripcion = "ESTUCHE SILI CONCASE VERDE";
		this.grupo = "ESTUCHES";
		this.ivaVenta = 19;
		this.precioVenta = 40000.0;
		this.precioCompra = 30000.0;
	}
	
	
	public ComandoProductoTestDataBuilder conCodigo(String codigo) {
		this.codigo = codigo;
		return this;
	}

	public ComandoProductoTestDataBuilder conDescripcion(String descripcion) {
		this.descripcion = descripcion;
		return this;
	}

	public ComandoProductoTestDataBuilder conGrupo(String grupo) {
		this.grupo = grupo;
		return this;
	}

	public ComandoProductoTestDataBuilder conIva(Integer ivaVenta) {
		this.ivaVenta = ivaVenta;
		return this;
	}

	public ComandoProductoTestDataBuilder conPrecioVenta(Double precioVenta) {
		this.precioVenta = precioVenta;
		return this;
	}

	public ComandoProductoTestDataBuilder conPrecioCompra(Double precioCompra) {
		this.precioCompra = precioCompra;
		return this;
	}

	public ComandoProducto build() {
		return new ComandoProducto(codigo, descripcion, grupo, ivaVenta, precioVenta, precioCompra);
	}

}
