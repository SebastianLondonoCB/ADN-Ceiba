package com.ceiba.servicio;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.excepcion.ExcepcionDuplicidad;
import com.ceiba.excepcion.ExcepcionReglasNegocio;
import com.ceiba.modelo.entidad.Factura;
import com.ceiba.puerto.repositorio.RepositorioFactura;
import com.ceiba.testdatabuilder.FacturaTestDataBuilder;

public class ServicioCrearFacturaTest {

	@Test
	public void validarExistenciaPrevia() {
		// Arrange
		Factura factura = new FacturaTestDataBuilder().build();
		RepositorioFactura repositorioFactura = Mockito.mock(RepositorioFactura.class);
		Mockito.when(repositorioFactura.existe(Mockito.any())).thenReturn(true);
		// Act
		ServicioCrearFactura servicioCrearFactura = new ServicioCrearFactura(repositorioFactura);
		// Assert
		BasePrueba.assertThrows(() -> servicioCrearFactura.ejecutar(factura), ExcepcionDuplicidad.class,
				"La factura ya existe en el sistema.");
	}
	
	@Test
	public void validarDiaDescanso() {
		// Arrange
		Factura factura = new FacturaTestDataBuilder().build();
		RepositorioFactura repositorioFactura = Mockito.mock(RepositorioFactura.class);
		Mockito.when(repositorioFactura.existe(Mockito.any())).thenReturn(true);
		// Act
		ServicioCrearFactura servicioCrearFactura = new ServicioCrearFactura(repositorioFactura);
		// Assert
		BasePrueba.assertThrows(() -> servicioCrearFactura.validarDiaDescanso(factura), ExcepcionReglasNegocio.class,
				"El dia domingo no se presta ningun tipo de servicio.");	
	}
	
	@Test
	public void validarClienteYFormaPago() {
		// Arrange
		Factura factura = new FacturaTestDataBuilder().build();
		RepositorioFactura repositorioFactura = Mockito.mock(RepositorioFactura.class);
		Mockito.when(repositorioFactura.existe(Mockito.any())).thenReturn(true);
		// Act
		ServicioCrearFactura servicioCrearFactura = new ServicioCrearFactura(repositorioFactura);
		// Assert
		BasePrueba.assertThrows(() -> servicioCrearFactura.validarClienteYFormaPago(factura), ExcepcionReglasNegocio.class,
				"No se le puede realizar la factura a a clientes no registrados.");	
	}
	
}
