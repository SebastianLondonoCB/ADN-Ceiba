package com.ceiba.puerto.dao;

import java.util.Collection;

import com.ceiba.modelo.dto.DtoProducto;

public interface DaoProducto {

	/**
	 * Permite listar los terceros
	 * @return
	 */
	Collection<DtoProducto> listar();
}
