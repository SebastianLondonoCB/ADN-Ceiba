package com.ceiba.adaptador.repositorio;

import org.springframework.stereotype.Repository;

import com.ceiba.adaptador.datastore.ProductoDataStore;
import com.ceiba.modelo.entidad.Producto;
import com.ceiba.puerto.repositorio.RepositorioProducto;

@Repository
public class RepositorioProductoEnMemoria implements RepositorioProducto {
	
	/**
	 * Solo se debe usar data store para pruebas en un contexto real deberia usar una bd
	 *
	 */
	private final ProductoDataStore productoDataStore;
	
	public RepositorioProductoEnMemoria(ProductoDataStore productoDataStore) {
		this.productoDataStore = productoDataStore;
	}

	@Override
	public void crear(Producto producto) {
		productoDataStore.put(producto);
	}

	@Override
	public boolean existe(Producto producto) {
		return productoDataStore.get().stream().anyMatch(fila -> fila.getCodigo().equals(producto.getCodigo()));
	}
}
