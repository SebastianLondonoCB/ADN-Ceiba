package com.ceiba.puerto.dao;

import java.util.Collection;

import com.ceiba.modelo.dto.DtoTercero;

public interface DaoCliente {

	/**
	 * Permite listar los terceros
	 * @return
	 */
	Collection<DtoTercero> listar();
}
