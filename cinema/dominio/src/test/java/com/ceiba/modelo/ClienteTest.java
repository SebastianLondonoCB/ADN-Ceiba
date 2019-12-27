package com.ceiba.modelo;

import org.junit.Test;

import com.ceiba.BasePrueba;
import com.ceiba.excepcion.ExcepcionLongitudValor;
import com.ceiba.excepcion.ExcepcionValorObligatorio;
import com.ceiba.testdatabuilder.ClienteTestDataBuilder;

public class ClienteTest {

	/* VALIDAMOS LOS CAMPOS OBLIGATORIOS */
	@Test
	public void validarIdentificacionObligatorio() {
		// Arrange
		ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder();
		clienteTestDataBuilder.conIdentificacion(null);
		// Act - Assert
		BasePrueba.assertThrows(() -> clienteTestDataBuilder.build(), ExcepcionValorObligatorio.class,
				"La identificacion es un dato obligatorio.");
	}

	@Test
	public void validarTipoIdentificacionObligatorio() {
		// Arrange
		ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder();
		clienteTestDataBuilder.conTipoIdentificacion(null);
		// Act - Assert
		BasePrueba.assertThrows(() -> clienteTestDataBuilder.build(), ExcepcionValorObligatorio.class,
				"El tipo de identificacion es un dato obligatorio.");
	} 

	@Test
	public void validarNombreObligatorio() {
		// Arrange
		ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder();
		clienteTestDataBuilder.conNombre(null);
		// Act - Assert
		BasePrueba.assertThrows(() -> clienteTestDataBuilder.build(), ExcepcionValorObligatorio.class,
				"El nombre es un dato obligatorio.");
	}

	@Test
	public void validarApellidoObligatorio() {
		// Arrange
		ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder();
		clienteTestDataBuilder.conApellidos(null);
		// Act - Assert
		BasePrueba.assertThrows(() -> clienteTestDataBuilder.build(), ExcepcionValorObligatorio.class,
				"El apellido es un dato obligatorio.");
	}
	/* FINALIZAMOS VALIDACIONES */

	/* VALIDAMOS LA LONGITUD DE LOS CAMPOS */
	@Test
	public void validarNombreCorto() {
		// Arrange
		ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder();
		clienteTestDataBuilder.conNombre("Se");
		// Act - Assert
		BasePrueba.assertThrows(() -> clienteTestDataBuilder.build(), ExcepcionLongitudValor.class,
				"El nombre debe tener un minimo de letras.");
	}
	
	@Test
	public void validarApellidoCorto() {
		// Arrange
		ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder();
		clienteTestDataBuilder.conApellidos("Lon");
		// Act - Assert
		BasePrueba.assertThrows(() -> clienteTestDataBuilder.build(), ExcepcionLongitudValor.class,
				"El apellido debe tener un minimo de letras.");
	}
	
	@Test
	public void validarIdentificacionCorto() {
		// Arrange
		ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder();
		clienteTestDataBuilder.conIdentificacion("1040");
		// Act - Assert
		BasePrueba.assertThrows(() -> clienteTestDataBuilder.build(), ExcepcionLongitudValor.class,
				"La identificacion debe tener un minimo de letras.");
	}
	/* FINALIZAMOS VALIDACIONES DE LONGITUD */
}
