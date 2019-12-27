package com.ceiba.puerto.dao;

import java.util.Collection;

import com.ceiba.modelo.dto.DtoFactura;

public interface DaoFactura {

	/**
	 * Permite listar los terceros
	 * @return
	 */
	Collection<DtoFactura> listar();
}
