package com.ceiba.adaptador.dao;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import com.ceiba.adaptador.datastore.TerceroDataStore;
import com.ceiba.modelo.dto.DtoCliente;
import com.ceiba.puerto.dao.DaoCliente;

@Repository
public class DaoTerceroEnMemoria implements DaoCliente {
	
	/**
	 * Solo se debe usar data store para pruebas en un contexto real deberia usar una bd
	 *
	 */
	private final TerceroDataStore terceroDataStore;
	
	public DaoTerceroEnMemoria(TerceroDataStore peliculaDataStore) {
		this.terceroDataStore = peliculaDataStore;
	}

	@Override
	public Collection<DtoCliente> listar() {
		return terceroDataStore.getAsDto();
	}
}
