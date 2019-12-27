package com.ceiba.modelo;

import org.junit.Test;

import com.ceiba.BasePrueba;
import com.ceiba.excepcion.ExcepcionLongitudValor;
import com.ceiba.excepcion.ExcepcionValorObligatorio;
import com.ceiba.testdatabuilder.ProductoTestDataBuilder;

public class FacturaTest {

	@Test
	public void validarNombreObligatorio() {
		//Arrange
		ProductoTestDataBuilder productoTestDataBuilder = new ProductoTestDataBuilder();
		productoTestDataBuilder.conCodigo(null);
		//Act - Assert
		BasePrueba.assertThrows(() -> productoTestDataBuilder.build(),ExcepcionValorObligatorio.class,"El codigo es un dato obligatorio.");
	}
	
	@Test
	public void validarNombreCorto() {
		//Arrange
		ProductoTestDataBuilder productoTestDataBuilder = new ProductoTestDataBuilder();
		productoTestDataBuilder.conDescripcion("sa");
		//Act - Assert
		BasePrueba.assertThrows(() -> productoTestDataBuilder.build(),ExcepcionLongitudValor.class,"La descripción debe tener minimo 3 letras.");
	}
}
