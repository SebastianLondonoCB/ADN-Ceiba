package com.ceiba.modelo;

import org.junit.Test;

import com.ceiba.BasePrueba;
import com.ceiba.excepcion.ExcepcionLongitudValor;
import com.ceiba.excepcion.ExcepcionValorMayorMenor;
import com.ceiba.excepcion.ExcepcionValorObligatorio;
import com.ceiba.testdatabuilder.DetalleFacturaTestDataBuilder;
import com.ceiba.testdatabuilder.ProductoTestDataBuilder;

public class DetalleFacturaTest {

	/* VALIDAMOS LOS CAMPOS OBLIGATORIOS */
	@Test
	public void validarIdFacturaObligatorio() {
		// Arrange
		DetalleFacturaTestDataBuilder detalleFacturaTestDataBuilder = new DetalleFacturaTestDataBuilder();
		detalleFacturaTestDataBuilder.conIdFactura(null);
		// Act - Assert
		BasePrueba.assertThrows(() -> detalleFacturaTestDataBuilder.build(), ExcepcionValorObligatorio.class,
				"El ID de factura es obligatorio.");
	}
	
	@Test
	public void validarCodigoProductoObligatorio() {
		// Arrange
		DetalleFacturaTestDataBuilder detalleFacturaTestDataBuilder = new DetalleFacturaTestDataBuilder();
		detalleFacturaTestDataBuilder.conCodigoProducto(null);
		// Act - Assert
		BasePrueba.assertThrows(() -> detalleFacturaTestDataBuilder.build(), ExcepcionValorObligatorio.class,
				"El codigo del producto es un dato obligatorio.");
	}
	
	@Test
	public void validarDescripcionProductoObligatorio() {
		// Arrange
		DetalleFacturaTestDataBuilder detalleFacturaTestDataBuilder = new DetalleFacturaTestDataBuilder();
		detalleFacturaTestDataBuilder.conDescripcionProducto(null);
		// Act - Assert
		BasePrueba.assertThrows(() -> detalleFacturaTestDataBuilder.build(), ExcepcionValorObligatorio.class,
				"La descripcion del producto es un dato obligatorio.");
	}
	
	@Test
	public void validarCantidadProductoObligatorio() {
		// Arrange
		DetalleFacturaTestDataBuilder detalleFacturaTestDataBuilder = new DetalleFacturaTestDataBuilder();
		detalleFacturaTestDataBuilder.conCantidad(null);
		// Act - Assert
		BasePrueba.assertThrows(() -> detalleFacturaTestDataBuilder.build(), ExcepcionValorObligatorio.class,
				"La cantidad del producto es un dato obligatorio.");
	}
	/* FINALIZAMOS VALIDACIONES */

	/* VALIDAMOS LOS NUMEROS */
	@Test
	public void validarPrecioUnitario() {
		// Arrange
		DetalleFacturaTestDataBuilder detalleFacturaTestDataBuilder = new DetalleFacturaTestDataBuilder();
		detalleFacturaTestDataBuilder.conPrecioUnitario(0.0);
		// Act - Assert
		BasePrueba.assertThrows(() -> detalleFacturaTestDataBuilder.build(), ExcepcionValorMayorMenor.class,
				"El precio unitario debe ser mayor a 0.");
	}
	
	@Test
	public void validarCantidadMinimo() {
		// Arrange
		DetalleFacturaTestDataBuilder detalleFacturaTestDataBuilder = new DetalleFacturaTestDataBuilder();
		detalleFacturaTestDataBuilder.conCantidad(0.0);
		// Act - Assert
		BasePrueba.assertThrows(() -> detalleFacturaTestDataBuilder.build(), ExcepcionValorMayorMenor.class,
				"La cantidad debe ser mayor a 0.");
	}
	
	@Test
	public void validarPrecioTotal() {
		// Arrange
		DetalleFacturaTestDataBuilder detalleFacturaTestDataBuilder = new DetalleFacturaTestDataBuilder();
		detalleFacturaTestDataBuilder.conPrecioTotal(0.0);
		// Act - Assert
		BasePrueba.assertThrows(() -> detalleFacturaTestDataBuilder.build(), ExcepcionValorMayorMenor.class,
				"El precio total debe ser mayor a 0.");
	}
	/* FINALIZAMOS VALIDACIONES DE NUMEROS */
}
