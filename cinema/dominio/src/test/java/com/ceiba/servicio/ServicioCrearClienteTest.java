package com.ceiba.servicio;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.excepcion.ExcepcionDuplicidad;
import com.ceiba.modelo.entidad.Cliente;
import com.ceiba.puerto.repositorio.RepositorioCliente;
import com.ceiba.testdatabuilder.ClienteTestDataBuilder;

public class ServicioCrearClienteTest {

	@Test
	public void validarExistenciaPrevia() {
		// Arrange
		Cliente cliente = new ClienteTestDataBuilder().build();
		RepositorioCliente repositorioCliente = Mockito.mock(RepositorioCliente.class);
		Mockito.when(repositorioCliente.existe(Mockito.any())).thenReturn(true);
		// Act
		ServicioCrearCliente servicioCrearCliente = new ServicioCrearCliente(repositorioCliente);
		// Assert
		BasePrueba.assertThrows(() -> servicioCrearCliente.ejecutar(cliente), ExcepcionDuplicidad.class,
				"El cliente ya existe en el sistema");
	}
}
