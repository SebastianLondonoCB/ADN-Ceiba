package com.ceiba.adaptador.dao;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import com.ceiba.adaptador.datastore.TerceroDataStore;
import com.ceiba.modelo.dto.DtoTercero;
import com.ceiba.puerto.dao.DaoCliente;

@Repository
public class DaoTerceroEnMemoria implements DaoCliente {
	
	/**
	 * Solo se debe usar data store para pruebas en un contexto real deberia usar una bd
	 *
	 */
	private final TerceroDataStore peliculaDataStore;
	
	public DaoTerceroEnMemoria(TerceroDataStore peliculaDataStore) {
		this.peliculaDataStore = peliculaDataStore;
	}

	@Override
	public Collection<DtoTercero> listar() {
		return peliculaDataStore.getAsDto();
	}
}
