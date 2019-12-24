package com.ceiba.adaptador.dao;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import com.ceiba.adaptador.datastore.ProductoDataStore;
import com.ceiba.modelo.dto.DtoProducto;
import com.ceiba.puerto.dao.DaoProducto;

@Repository
public class DaoProductoEnMemoria implements DaoProducto {
	
	/**
	 * Solo se debe usar data store para pruebas en un contexto real deberia usar una bd
	 *
	 */
	private final ProductoDataStore productoDataStore;
	
	public DaoProductoEnMemoria(ProductoDataStore productoDataStore) {
		this.productoDataStore = productoDataStore;
	}

	@Override
	public Collection<DtoProducto> listar() {
		return productoDataStore.getAsDto();
	}
}
