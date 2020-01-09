package com.ceiba.servicio;

import com.ceiba.excepcion.ExcepcionDuplicidad;
import com.ceiba.modelo.entidad.Producto;
import com.ceiba.puerto.repositorio.RepositorioProducto;

public class ServicioCrearProducto {

	private static final String EL_PRODUCTO_YA_EXISTE_EN_EL_SISTEMA = "El producto ya existe en el sistema";
		
	private RepositorioProducto repositorioProducto;
	
	public ServicioCrearProducto(RepositorioProducto repositorioProducto) {
		this.repositorioProducto = repositorioProducto;
	}
	
	public void ejecutar(Producto producto) {
		validarExistenciaPrevia(producto);
		this.repositorioProducto.crear(producto);
	}

	private void validarExistenciaPrevia(Producto producto) {
		boolean existe = this.repositorioProducto.existe(producto);
		if(existe) {
			throw new ExcepcionDuplicidad(EL_PRODUCTO_YA_EXISTE_EN_EL_SISTEMA);
		}
	}
}
