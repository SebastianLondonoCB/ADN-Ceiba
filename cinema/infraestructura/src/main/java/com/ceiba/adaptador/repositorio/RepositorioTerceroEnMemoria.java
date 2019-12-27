package com.ceiba.adaptador.repositorio;

import org.springframework.stereotype.Repository;

import com.ceiba.adaptador.datastore.TerceroDataStore;
import com.ceiba.modelo.entidad.Cliente;
import com.ceiba.puerto.repositorio.RepositorioCliente;

@Repository
public class RepositorioTerceroEnMemoria implements RepositorioCliente {
	
	/**
	 * Solo se debe usar data store para pruebas en un contexto real deberia usar una bd
	 *
	 */
	private final TerceroDataStore terceroDataStore;
	
	public RepositorioTerceroEnMemoria(TerceroDataStore terceroDataStore) {
		this.terceroDataStore = terceroDataStore;
	}

	@Override
	public void crear(Cliente tercero) {
		terceroDataStore.put(tercero);
	}

	@Override
	public boolean existe(Cliente tercero) {
		return terceroDataStore.get().stream().anyMatch(fila -> fila.getIdentificacion().equals(tercero.getIdentificacion()));
	}
}
