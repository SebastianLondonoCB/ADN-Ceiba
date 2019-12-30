package com.ceiba.modelo.entidad;

public class DetalleFactura {

	// Datos obligatorios
	private static final String EL_PRECIO_UNITARIO_DEBE_SER_MAYOR_A_CERO = "El precio unitario debe ser mayor a 0.";
	private static final String LA_CANTIDAD_DEBE_SER_MAYOR_A_CERO = "La cantidad debe ser mayor a 0.";
	private static final String EL_PRECIO_TOTAL_DEBE_SER_MAYOR_A_CERO = "El precio total debe ser mayor a 0.";

	// Datos obligatorios
	private static final String EL_ID_DE_FACTURA_ES_UN_DATO_OBLIGATORIO = "El ID de factura es obligatorio.";
	private static final String EL_CODIGO_DEL_PRODUCTO_ES_UN_DATO_OBLIGATORIO = "El codigo del producto es un dato obligatorio.";
	private static final String LA_DESCRIPCION_DEL_PRODUCTO_ES_UN_DATO_OBLIGATORIO = "La descripcion del producto es un dato obligatorio.";
	private static final String LA_CANTIDAD_DEL_PRODUCTO_ES_UN_DATO_OBLIGATORIO = "La cantidad del producto es un dato obligatorio.";

	// Encabezado de la factura
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

	public DetalleFactura(String idFactura, String codigoProducto, String descripcionProducto, Double precioUnitario,
			Double cantidad, Integer porcentajeIva, Double precioIva, Double precioTotal, Double precioCompra,
			Double utilidad) {
		
		ValidadorArgumento.validarObligatorio(idFactura, EL_ID_DE_FACTURA_ES_UN_DATO_OBLIGATORIO);
		ValidadorArgumento.validarObligatorio(codigoProducto, EL_CODIGO_DEL_PRODUCTO_ES_UN_DATO_OBLIGATORIO);
		ValidadorArgumento.validarObligatorio(descripcionProducto, LA_DESCRIPCION_DEL_PRODUCTO_ES_UN_DATO_OBLIGATORIO);
		ValidadorArgumento.validarObligatorio(cantidad, LA_CANTIDAD_DEL_PRODUCTO_ES_UN_DATO_OBLIGATORIO);

		ValidadorArgumento.validarValorMayorACero(precioUnitario, EL_PRECIO_UNITARIO_DEBE_SER_MAYOR_A_CERO);
		ValidadorArgumento.validarValorMayorACero(cantidad, LA_CANTIDAD_DEBE_SER_MAYOR_A_CERO);
		ValidadorArgumento.validarValorMayorACero(precioTotal, EL_PRECIO_TOTAL_DEBE_SER_MAYOR_A_CERO);
			
		this.idFactura = idFactura;
		this.codigoProducto = codigoProducto;
		this.descripcionProducto = descripcionProducto;
		this.precioUnitario = precioUnitario;
		this.cantidad = cantidad;
		this.porcentajeIva = porcentajeIva;
		this.precioIva = precioIva;
		this.precioTotal = precioTotal;
		this.precioCompra = precioCompra;
		this.utilidad = utilidad;
	}

	public String getIdFactura() {
		return idFactura;
	}

	public String getCodigoProducto() {
		return codigoProducto;
	}

	public String getDescripcionProducto() {
		return descripcionProducto;
	}

	public Double getPrecioUnitario() {
		return precioUnitario;
	}

	public Double getCantidad() {
		return cantidad;
	}

	public Integer getPorcentajeIva() {
		return porcentajeIva;
	}

	public Double getPrecioIva() {
		return precioIva;
	}

	public Double getPrecioTotal() {
		return precioTotal;
	}

	public Double getPrecioCompra() {
		return precioCompra;
	}

	public Double getUtilidad() {
		return utilidad;
	}
}
