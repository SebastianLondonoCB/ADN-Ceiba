package com.ceiba.modelo;

import org.junit.Test;

import com.ceiba.BasePrueba;
import com.ceiba.excepcion.ExcepcionLongitudValor;
import com.ceiba.excepcion.ExcepcionValorMayorMenor;
import com.ceiba.excepcion.ExcepcionValorObligatorio;
import com.ceiba.testdatabuilder.ProductoTestDataBuilder;

public class ProductoTest {

	/* VALIDAMOS LOS CAMPOS OBLIGATORIOS */
	@Test
	public void validarCodigoObligatorio() {
		// Arrange
		ProductoTestDataBuilder productoTestDataBuilder = new ProductoTestDataBuilder();
		productoTestDataBuilder.conCodigo(null);
		// Act - Assert
		BasePrueba.assertThrows(() -> productoTestDataBuilder.build(), ExcepcionValorObligatorio.class,
				"El codigo es un dato obligatorio.");
	}

	@Test
	public void validarDescripcionObligatorio() {
		// Arrange
		ProductoTestDataBuilder productoTestDataBuilder = new ProductoTestDataBuilder();
		productoTestDataBuilder.conDescripcion(null);
		// Act - Assert
		BasePrueba.assertThrows(() -> productoTestDataBuilder.build(), ExcepcionValorObligatorio.class,
				"La descripción es un dato obligatorio.");
	}
	
	@Test
	public void validarIvaObligatorio() {
		// Arrange
		ProductoTestDataBuilder productoTestDataBuilder = new ProductoTestDataBuilder();
		productoTestDataBuilder.conIva(null);
		// Act - Assert
		BasePrueba.assertThrows(() -> productoTestDataBuilder.build(), ExcepcionValorObligatorio.class,
				"El iva es un dato obligatorio.");
	}
	
	@Test
	public void validarPrecioVentaObligatorio() {
		// Arrange
		ProductoTestDataBuilder productoTestDataBuilder = new ProductoTestDataBuilder();
		productoTestDataBuilder.conPrecioVenta(null);
		// Act - Assert
		BasePrueba.assertThrows(() -> productoTestDataBuilder.build(), ExcepcionValorObligatorio.class,
				"El precio de venta es un dato obligatorio.");
	}
	
	@Test
	public void validarPrecioCompraObligatorio() {
		// Arrange
		ProductoTestDataBuilder productoTestDataBuilder = new ProductoTestDataBuilder();
		productoTestDataBuilder.conPrecioCompra(null);
		// Act - Assert
		BasePrueba.assertThrows(() -> productoTestDataBuilder.build(), ExcepcionValorObligatorio.class,
				"El precio de compra es un dato obligatorio.");
	} 
	/* FINALIZAMOS VALIDACIONES */

	/* VALIDAMOS LA LONGITUD DE LOS CAMPOS */
	@Test
	public void validarDescripcionCorta() {
		// Arrange
		ProductoTestDataBuilder productoTestDataBuilder = new ProductoTestDataBuilder();
		productoTestDataBuilder.conDescripcion("Es");
		// Act - Assert
		BasePrueba.assertThrows(() -> productoTestDataBuilder.build(), ExcepcionLongitudValor.class,
				"La descripcion debe tener un minimo de letras.");
	}
	/* FINALIZAMOS VALIDACIONES DE LONGITUD */
	
	/* VALIDAMOS LOS NUMEROS */
	@Test
	public void validarIvaMayor() {
		// Arrange
		ProductoTestDataBuilder productoTestDataBuilder = new ProductoTestDataBuilder();
		productoTestDataBuilder.conIva(100);
		// Act - Assert
		BasePrueba.assertThrows(() -> productoTestDataBuilder.build(), ExcepcionValorMayorMenor.class,
				"El iva debe ser maximo 100.");
	}
	
	@Test
	public void validarPrecioVentaMinimo() {
		// Arrange
		ProductoTestDataBuilder productoTestDataBuilder = new ProductoTestDataBuilder();
		productoTestDataBuilder.conPrecioVenta(0.0);
		// Act - Assert
		BasePrueba.assertThrows(() -> productoTestDataBuilder.build(), ExcepcionValorMayorMenor.class,
				"El precio de venta debe ser mayor a 0.");
	}
	
	@Test
	public void validarPrecioCompraMinimo() {
		// Arrange
		ProductoTestDataBuilder productoTestDataBuilder = new ProductoTestDataBuilder();
		productoTestDataBuilder.conPrecioCompra(0.0);
		// Act - Assert
		BasePrueba.assertThrows(() -> productoTestDataBuilder.build(), ExcepcionValorMayorMenor.class,
				"El precio de compra debe ser mayor a 0.");
	}
	/* FINALIZAMOS VALIDACIONES DE NUMEROS */
}
