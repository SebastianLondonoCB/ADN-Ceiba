package com.ceiba.adaptador.repositorio;

import org.springframework.stereotype.Repository;

import com.ceiba.adaptador.datastore.DetalleFacturaDataStore;
import com.ceiba.modelo.entidad.DetalleFactura;
import com.ceiba.modelo.entidad.Factura;
import com.ceiba.puerto.repositorio.RepositorioDetalleFactura;

@Repository
public class RepositorioDetalleFacturaEnMemoria implements RepositorioDetalleFactura {
	
	/**
	 * Solo se debe usar data store para pruebas en un contexto real deberia usar una bd
	 *
	 */
	private final DetalleFacturaDataStore detalleFacturaDataStore;
	
	public RepositorioDetalleFacturaEnMemoria(DetalleFacturaDataStore detalleFacturaDataStore) {
		this.detalleFacturaDataStore = detalleFacturaDataStore;
	}

	@Override
	public void crear(DetalleFactura detalleFactura) {
		detalleFacturaDataStore.put(detalleFactura);
	}
}
