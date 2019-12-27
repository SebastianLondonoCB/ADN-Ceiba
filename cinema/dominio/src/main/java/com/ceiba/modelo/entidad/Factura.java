package com.ceiba.modelo.entidad;

import java.util.Date;
import java.util.List;

import com.ceiba.modelo.dto.DtoDetalleFactura;

public class Factura {

	// Datos obligatorios
	private static final String EL_SUBTOTAL_DEBE_SER_MAYOR_A_CERO = "El subtotal debe ser mayor a 0";
	private static final String EL_TOTAL_DEBE_SER_MAYOR_A_CERO = "El total debe ser mayor a 0";

	// Datos obligatorios
	private static final String EL_ID_DE_FACTURA_ES_UN_DATO_OBLIGATORIO = "El ID de factura es obligatorio.";
	private static final String LA_IDENTIFICACION_DEL_CLIENTE_ES_UN_DATO_OBLIGATORIO = "La identificacion del cliente es un dato obligatorio.";
	private static final String LA_FECHA_FACTURA_ES_UN_DATO_OBLIGATORIO = "La fecha factura es un dato obligatorio.";
	private static final String EL_PLAZO_ES_UN_DATO_OBLIGATORIO = "El plazo es un dato obligatorio.";
	private static final String EL_DETALLE_DE_FACTURA_ES_UN_DATO_OBLIGATORIO = "El detalle de la factura es un dato obligatorio.";

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

	public Factura(String idFactura, String identificacionCliente, Date fechaFactura, Integer plazoFactura,
			Date fechaVencimiento, Double subtotalFactura, Double ivaFactura, Double descuentosFactura,
			Double totalFactura, Double utilidadFactura, List<DtoDetalleFactura> detalleFactura) {
		
		ValidadorArgumento.validarObligatorio(idFactura, EL_ID_DE_FACTURA_ES_UN_DATO_OBLIGATORIO);
		ValidadorArgumento.validarObligatorio(identificacionCliente,
				LA_IDENTIFICACION_DEL_CLIENTE_ES_UN_DATO_OBLIGATORIO);
		ValidadorArgumento.validarObligatorio(fechaFactura, LA_FECHA_FACTURA_ES_UN_DATO_OBLIGATORIO);
		ValidadorArgumento.validarObligatorio(plazoFactura, EL_PLAZO_ES_UN_DATO_OBLIGATORIO);
		ValidadorArgumento.validarObligatorio(detalleFactura, EL_DETALLE_DE_FACTURA_ES_UN_DATO_OBLIGATORIO);

		ValidadorArgumento.validarValorMayorACero(subtotalFactura, EL_SUBTOTAL_DEBE_SER_MAYOR_A_CERO);
		ValidadorArgumento.validarValorMayorACero(totalFactura, EL_TOTAL_DEBE_SER_MAYOR_A_CERO);

		this.idFactura = idFactura;
		this.identificacionCliente = identificacionCliente;
		this.fechaFactura = fechaFactura;
		this.plazoFactura = plazoFactura;
		this.fechaVencimiento = fechaVencimiento;
		this.subtotalFactura = subtotalFactura;
		this.ivaFactura = ivaFactura;
		this.descuentosFactura = descuentosFactura;
		this.totalFactura = totalFactura;
		this.utilidadFactura = utilidadFactura;
		this.detalleFactura = detalleFactura;
	}

	public String getIdFactura() {
		return idFactura;
	}

	public String getIdentificacionCliente() {
		return identificacionCliente;
	}

	public Date getFechaFactura() {
		return fechaFactura;
	}

	public Integer getPlazoFactura() {
		return plazoFactura;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public Double getSubtotalFactura() {
		return subtotalFactura;
	}

	public Double getIvaFactura() {
		return ivaFactura;
	}

	public Double getDescuentosFactura() {
		return descuentosFactura;
	}

	public Double getTotalFactura() {
		return totalFactura;
	}

	public Double getUtilidadFactura() {
		return utilidadFactura;
	}

	public List<DtoDetalleFactura> getDetalleFactura() {
		return detalleFactura;
	}
}
