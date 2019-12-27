package com.ceiba.adaptador.dao;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import com.ceiba.adaptador.datastore.DetalleFacturaDataStore;
import com.ceiba.modelo.dto.DtoDetalleFactura;
import com.ceiba.puerto.dao.DaoDetalleFactura;

@Repository
public class DaoDetalleFacturaEnMemoria implements DaoDetalleFactura {
	
	/**
	 * Solo se debe usar data store para pruebas en un contexto real deberia usar una bd
	 *
	 */
	
	private final DetalleFacturaDataStore detalleFacturaDataStore;
	
	public DaoDetalleFacturaEnMemoria(DetalleFacturaDataStore detalleFacturaDataStore) {
		this.detalleFacturaDataStore = detalleFacturaDataStore;
	}

	@Override
	public Collection<DtoDetalleFactura> listar() {
		return detalleFacturaDataStore.getAsDto();
	}
}
