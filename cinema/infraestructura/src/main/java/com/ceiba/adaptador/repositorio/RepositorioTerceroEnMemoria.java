package com.ceiba.adaptador.repositorio;

import org.springframework.stereotype.Repository;

import com.ceiba.adaptador.datastore.TerceroDataStore;
import com.ceiba.modelo.entidad.Tercero;
import com.ceiba.puerto.repositorio.RepositorioTercero;

@Repository
public class RepositorioTerceroEnMemoria implements RepositorioTercero {
	
	/**
	 * Solo se debe usar data store para pruebas en un contexto real deberia usar una bd
	 *
	 */
	private final TerceroDataStore terceroDataStore;
	
	public RepositorioTerceroEnMemoria(TerceroDataStore terceroDataStore) {
		this.terceroDataStore = terceroDataStore;
	}

	@Override
	public void crear(Tercero tercero) {
		terceroDataStore.put(tercero);
	}

	@Override
	public boolean existe(Tercero tercero) {
		return terceroDataStore.get().stream().anyMatch(fila -> fila.getIdentificacion().equals(tercero.getIdentificacion()));
	}
}
