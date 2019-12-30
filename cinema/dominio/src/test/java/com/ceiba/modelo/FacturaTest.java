package com.ceiba.modelo;

import org.junit.Test;

import com.ceiba.BasePrueba;
import com.ceiba.excepcion.ExcepcionLongitudValor;
import com.ceiba.excepcion.ExcepcionValorMayorMenor;
import com.ceiba.excepcion.ExcepcionValorObligatorio;
import com.ceiba.testdatabuilder.FacturaTestDataBuilder;
import com.ceiba.testdatabuilder.ProductoTestDataBuilder;

public class FacturaTest {

	/* VALIDAMOS LOS CAMPOS OBLIGATORIOS */
	@Test
	public void validarIdFacturaObligatorio() {
		// Arrange
		FacturaTestDataBuilder facturaTestDataBuilder = new FacturaTestDataBuilder();
		facturaTestDataBuilder.conIdFactura(null);
		// Act - Assert
		BasePrueba.assertThrows(() -> facturaTestDataBuilder.build(), ExcepcionValorObligatorio.class,
				"El ID de factura es obligatorio.");
	}

	public void validarIdentificacionClienteObligatorio() {
		// Arrange
		FacturaTestDataBuilder facturaTestDataBuilder = new FacturaTestDataBuilder();
		facturaTestDataBuilder.conIdentificacionCliente(null);
		// Act - Assert
		BasePrueba.assertThrows(() -> facturaTestDataBuilder.build(), ExcepcionValorObligatorio.class,
				"La identificacion del cliente es un dato obligatorio.");
	}
	
	public void validarFechaFacturaObligatorio() {
		// Arrange
		FacturaTestDataBuilder facturaTestDataBuilder = new FacturaTestDataBuilder();
		facturaTestDataBuilder.conFechaFactura(null);
		// Act - Assert
		BasePrueba.assertThrows(() -> facturaTestDataBuilder.build(), ExcepcionValorObligatorio.class,
				"La fecha factura es un dato obligatorio.");
	}
	
	public void validarPlazoObligatorio() {
		// Arrange
		FacturaTestDataBuilder facturaTestDataBuilder = new FacturaTestDataBuilder();
		facturaTestDataBuilder.conPlazoFactura(null);
		// Act - Assert
		BasePrueba.assertThrows(() -> facturaTestDataBuilder.build(), ExcepcionValorObligatorio.class,
				"El plazo es un dato obligatorio.");
	}
	
	public void validarDetalleFacturaObligatorio() {
		// Arrange
		FacturaTestDataBuilder facturaTestDataBuilder = new FacturaTestDataBuilder();
		facturaTestDataBuilder.conDetalleFactura(null);
		// Act - Assert
		BasePrueba.assertThrows(() -> facturaTestDataBuilder.build(), ExcepcionValorObligatorio.class,
				"El detalle de la factura es un dato obligatorio.");
	}
	/* FINALIZAMOS VALIDACIONES */
	
	/* VALIDAMOS LOS NUMEROS */
	@Test
	public void validarSubtotalMinimo() {
		// Arrange
		FacturaTestDataBuilder facturaTestDataBuilder = new FacturaTestDataBuilder();
		facturaTestDataBuilder.conSubtotalFactura(0.0);
		// Act - Assert
		BasePrueba.assertThrows(() -> facturaTestDataBuilder.build(), ExcepcionValorMayorMenor.class,
				"El subtotal debe ser mayor a 0.");
	}
	
	@Test
	public void validarTotalMinimo() {
		// Arrange
		FacturaTestDataBuilder facturaTestDataBuilder = new FacturaTestDataBuilder();
		facturaTestDataBuilder.conTotalFactura(0.0);
		// Act - Assert
		BasePrueba.assertThrows(() -> facturaTestDataBuilder.build(), ExcepcionValorMayorMenor.class,
				"El total debe ser mayor a 0.");
	}
	/* FINALIZAMOS VALIDACIONES DE NUMEROS */
	
}
