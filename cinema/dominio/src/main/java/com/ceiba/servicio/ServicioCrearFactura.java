package com.ceiba.servicio;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.ceiba.excepcion.ExcepcionDuplicidad;
import com.ceiba.excepcion.ExcepcionReglasNegocio;
import com.ceiba.modelo.entidad.Factura;
import com.ceiba.puerto.repositorio.RepositorioFactura;

public class ServicioCrearFactura {

	private static final String LA_FACTURA_YA_EXISTE_EN_EL_SISTEMA = "La factura ya existe en el sistema.";
	private static final String EL_DIA_DOMINGO_NO_SE_PRESTA_NINGUN_TIPO_DE_SERVICIO = "El dia domingo no se presta ningun tipo de servicio.";
	private static final String NO_SE_PUEDE_REALIZAR_LA_FACTURA_A_CLIENTES_NO_REGISTRADOS = "No se le puede realizar "
			+ "la factura a a clientes no registrados.";

	private RepositorioFactura repositorioFactura;

	public ServicioCrearFactura(RepositorioFactura repositorioFactura) {
		this.repositorioFactura = repositorioFactura;
	}

	public void ejecutar(Factura factura) {
		validarClienteYFormaPago(factura);
		validarDiaDescanso(factura);
		validarExistenciaPrevia(factura);
		this.repositorioFactura.crear(factura);
	}

	private void validarExistenciaPrevia(Factura factura) {
		boolean existe = this.repositorioFactura.existe(factura);
		if (existe) {
			throw new ExcepcionDuplicidad(LA_FACTURA_YA_EXISTE_EN_EL_SISTEMA);
		}
	}

	public void validarDiaDescanso(Factura factura) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String strDate = formato.format(factura.getFechaFactura());
		LocalDate date = LocalDate.parse(strDate, formatter);
		if (date.getDayOfWeek() == DayOfWeek.SUNDAY) {
			throw new ExcepcionReglasNegocio(EL_DIA_DOMINGO_NO_SE_PRESTA_NINGUN_TIPO_DE_SERVICIO);
		}
	}
	
	public void validarClienteYFormaPago(Factura factura) {
		String idCliente = factura.getIdentificacionCliente();
		Integer diasPlazo = factura.getPlazoFactura();
		if (diasPlazo > 0 && idCliente.equals("00000")) {
			throw new ExcepcionReglasNegocio(NO_SE_PUEDE_REALIZAR_LA_FACTURA_A_CLIENTES_NO_REGISTRADOS);
		}
	}

}
