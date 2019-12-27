package com.ceiba.adaptador.repositorio;

import org.springframework.stereotype.Repository;

import com.ceiba.adaptador.datastore.FacturaDataStore;
import com.ceiba.modelo.entidad.Factura;
import com.ceiba.puerto.repositorio.RepositorioFactura;

@Repository
public class RepositorioFacturaEnMemoria implements RepositorioFactura {
	
	/**
	 * Solo se debe usar data store para pruebas en un contexto real deberia usar una bd
	 *
	 */
	private final FacturaDataStore facturaDataStore;
	
	public RepositorioFacturaEnMemoria(FacturaDataStore facturaDataStore) {
		this.facturaDataStore = facturaDataStore;
	}

	@Override
	public void crear(Factura factura) {
		facturaDataStore.put(factura);
	}

	@Override
	public boolean existe(Factura factura) {
		return facturaDataStore.get().stream().anyMatch(fila -> fila.getIdFactura().equals(factura.getIdFactura()));
	}
}
