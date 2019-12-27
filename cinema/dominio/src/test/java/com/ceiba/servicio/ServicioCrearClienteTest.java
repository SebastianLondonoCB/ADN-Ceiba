package com.ceiba.servicio;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.excepcion.ExcepcionDuplicidad;
import com.ceiba.modelo.entidad.Producto;
import com.ceiba.puerto.repositorio.RepositorioProducto;
import com.ceiba.testdatabuilder.ProductoTestDataBuilder;

public class ServicioCrearClienteTest {

	@Test
	public void validarExistenciaPrevia() {
		//Arrange
		Producto producto = new ProductoTestDataBuilder().build();
		RepositorioProducto repositorioProducto = Mockito.mock(RepositorioProducto.class);
		Mockito.when(repositorioProducto.existe(Mockito.any())).thenReturn(true);
		//Act
		ServicioCrearProducto servicioCrearProducto = new ServicioCrearProducto(repositorioProducto);
		//Assert
		BasePrueba.assertThrows(() -> servicioCrearProducto.ejecutar(producto), ExcepcionDuplicidad.class,"El producto ya existe en el sistema");
	}
}
