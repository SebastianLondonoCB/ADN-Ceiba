package com.ceiba.modelo.entidad;

import java.util.Date;

public class Producto {

	private static final int TAMANO_MINIMO_DESCRIPCION = 3;

	// Cantidad minimas
	private static final String LA_DESCRIPCION_DEBE_TENER_MINIMO_LETRAS = "El nombre debe tener mínimo %s letras.";

	// Datos obligatorios
	private static final String EL_CODIGO_ES_UN_DATO_OBLIGATORIO = "El codigo es un dato obligatorio.";
	private static final String LA_DESCRIPCION_ES_UN_DATO_OBLIGATORIO = "La descripci�n es un dato obligatorio.";
	private static final String EL_IVA_ES_UN_DATO_OBLIGATORIO = "El iva es un dato obligatorio.";
	private static final String LA_LISTA_1_ES_UN_DATO_OBLIGATORIO = "La lista 1 es un dato obligatorio.";
	private static final String LA_LISTA_2_ES_UN_DATO_OBLIGATORIO = "La lista 2 es un dato obligatorio.";
	private static final String EL_PRECIO_DE_COMPRA_ES_UN_DATO_OBLIGATORIO = "El precio de compra es un dato obligatorio.";

	// Establecemos atributos
	private String codigo;
	private String descripcion;
	private String grupo;
	private Integer ivaVenta;
	private Double lista1;
	private Double lista2;
	private Double precioCompra;

	public Producto(String codigo, String descripcion, String grupo, Integer ivaVenta, Double lista1, Double lista2,
			Double precioCompra) {

		ValidadorArgumento.validarObligatorio(codigo, EL_CODIGO_ES_UN_DATO_OBLIGATORIO);
		ValidadorArgumento.validarObligatorio(descripcion, LA_DESCRIPCION_ES_UN_DATO_OBLIGATORIO);
		ValidadorArgumento.validarObligatorio(ivaVenta, EL_IVA_ES_UN_DATO_OBLIGATORIO);
		ValidadorArgumento.validarObligatorio(lista1, LA_LISTA_1_ES_UN_DATO_OBLIGATORIO);
		ValidadorArgumento.validarObligatorio(lista2, LA_LISTA_2_ES_UN_DATO_OBLIGATORIO);
		ValidadorArgumento.validarObligatorio(precioCompra, EL_PRECIO_DE_COMPRA_ES_UN_DATO_OBLIGATORIO);

		ValidadorArgumento.validarLongitud(descripcion, TAMANO_MINIMO_DESCRIPCION,
				String.format(LA_DESCRIPCION_DEBE_TENER_MINIMO_LETRAS, TAMANO_MINIMO_DESCRIPCION));


		this.codigo = codigo;
		this.descripcion = descripcion;
		this.grupo = grupo;
		this.ivaVenta = ivaVenta;
		this.lista1 = lista1;
		this.lista2 = lista2;
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

	public Double getLista1() {
		return lista1;
	}

	public Double getLista2() {
		return lista2;
	}

	public Double getPrecioCompra() {
		return precioCompra;
	}

}
