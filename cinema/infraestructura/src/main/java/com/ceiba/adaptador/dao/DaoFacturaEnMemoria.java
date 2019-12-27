package com.ceiba.adaptador.dao;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import com.ceiba.adaptador.datastore.FacturaDataStore;
import com.ceiba.modelo.dto.DtoFactura;
import com.ceiba.puerto.dao.DaoFactura;

@Repository
public class DaoFacturaEnMemoria implements DaoFactura {
	
	/**
	 * Solo se debe usar data store para pruebas en un contexto real deberia usar una bd
	 *
	 */
	private final FacturaDataStore facturaDataStore;
	
	public DaoFacturaEnMemoria(FacturaDataStore facturaDataStore) {
		this.facturaDataStore = facturaDataStore;
	}

	@Override
	public Collection<DtoFactura> listar() {
		return facturaDataStore.getAsDto();
	}
}
