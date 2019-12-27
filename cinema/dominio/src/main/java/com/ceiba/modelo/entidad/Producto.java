package com.ceiba.modelo.entidad;

public class Producto {

	private static final int TAMANO_MINIMO_DESCRIPCION = 3;
	private static final int VALOR_MAXIMO_PORCENTAJE_IVA = 100;

	// Cantidad minimas
	private static final String LA_DESCRIPCION_DEBE_TENER_MINIMO_LETRAS = "La descripcion debe tener un minimo de letras.";

	// Cantidad maximas
	private static final String EL_PORCENTAJE_DEL_IVA_DEBE_SER_MAXIMO_CIEN = "El iva debe ser maximo 100.";
	private static final String EL_PRECIO_COMPRA_DEBE_SER_MAYOR_A_CERO = "El precio de compra debe ser mayor a 0.";
	private static final String EL_PRECIO_VENTA_DEBE_SER_MAYOR_A_CERO = "El precio de venta debe ser mayor a 0.";

	// Datos obligatorios
	private static final String EL_CODIGO_ES_UN_DATO_OBLIGATORIO = "El codigo es un dato obligatorio.";
	private static final String LA_DESCRIPCION_ES_UN_DATO_OBLIGATORIO = "La descripción es un dato obligatorio.";
	private static final String EL_IVA_ES_UN_DATO_OBLIGATORIO = "El iva es un dato obligatorio.";
	private static final String EL_PRECIO_DE_VENTA_ES_UN_DATO_OBLIGATORIO = "El precio de venta es un dato obligatorio.";
	private static final String EL_PRECIO_DE_COMPRA_ES_UN_DATO_OBLIGATORIO = "El precio de compra es un dato obligatorio.";

	// Establecemos atributos
	private String codigo;
	private String descripcion;
	private String grupo;
	private Integer ivaVenta;
	private Double precioVenta;
	private Double precioCompra;

	public Producto(String codigo, String descripcion, String grupo, Integer ivaVenta, Double precioVenta,
			Double precioCompra) {

		ValidadorArgumento.validarObligatorio(codigo, EL_CODIGO_ES_UN_DATO_OBLIGATORIO);
		ValidadorArgumento.validarObligatorio(descripcion, LA_DESCRIPCION_ES_UN_DATO_OBLIGATORIO);
		ValidadorArgumento.validarObligatorio(ivaVenta, EL_IVA_ES_UN_DATO_OBLIGATORIO);
		ValidadorArgumento.validarObligatorio(precioVenta, EL_PRECIO_DE_VENTA_ES_UN_DATO_OBLIGATORIO);
		ValidadorArgumento.validarObligatorio(precioCompra, EL_PRECIO_DE_COMPRA_ES_UN_DATO_OBLIGATORIO);

		ValidadorArgumento.validarLongitud(descripcion, TAMANO_MINIMO_DESCRIPCION,
				String.format(LA_DESCRIPCION_DEBE_TENER_MINIMO_LETRAS, TAMANO_MINIMO_DESCRIPCION));

		ValidadorArgumento.validarMenorACien(ivaVenta,
				String.format(EL_PORCENTAJE_DEL_IVA_DEBE_SER_MAXIMO_CIEN, VALOR_MAXIMO_PORCENTAJE_IVA));
		ValidadorArgumento.validarValorMayorACero(precioVenta, EL_PRECIO_VENTA_DEBE_SER_MAYOR_A_CERO);
		ValidadorArgumento.validarValorMayorACero(precioCompra, EL_PRECIO_COMPRA_DEBE_SER_MAYOR_A_CERO);

		this.codigo = codigo;
		this.descripcion = descripcion;
		this.grupo = grupo;
		this.ivaVenta = ivaVenta;
		this.precioVenta = precioVenta;
		this.precioCompra = precioCompra;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getGrupo() {
		return grupo;
	}

	public Integer getIvaVenta() {
		return ivaVenta;
	}

	public Double getPrecioVenta() {
		return precioVenta;
	}

	public Double getPrecioCompra() {
		return precioCompra;
	}

}
