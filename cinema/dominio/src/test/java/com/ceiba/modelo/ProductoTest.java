package com.ceiba.modelo;

import org.junit.Test;

import com.ceiba.BasePrueba;
import com.ceiba.excepcion.ExcepcionLongitudValor;
import com.ceiba.excepcion.ExcepcionValorObligatorio;
import com.ceiba.testdatabuilder.ProductoTestDataBuilder;

public class ProductoTest {

	@Test
	public void validarNombreObligatorio() {
		//Arrange
		ProductoTestDataBuilder peliculaTestDataBuilder = new ProductoTestDataBuilder();
		peliculaTestDataBuilder.conCodigo(null);
		//Act - Assert
		BasePrueba.assertThrows(() -> peliculaTestDataBuilder.build(),ExcepcionValorObligatorio.class,"El codigo es un dato obligatorio.");
	}
	
	@Test
	public void validarNombreCorto() {
		//Arrange
		ProductoTestDataBuilder peliculaTestDataBuilder = new ProductoTestDataBuilder();
		peliculaTestDataBuilder.conDescripcion("sa");
		//Act - Assert
		BasePrueba.assertThrows(() -> peliculaTestDataBuilder.build(),ExcepcionLongitudValor.class,"La descripción debe tener minimo 3 letras.");
	}
}
