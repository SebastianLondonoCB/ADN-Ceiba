package com.ceiba.puerto.dao;

import java.util.Collection;

import com.ceiba.modelo.dto.DtoTercero;

public interface DaoTercero {

	/**
	 * Permite listar los terceros
	 * @return
	 */
	Collection<DtoTercero> listar();
}
