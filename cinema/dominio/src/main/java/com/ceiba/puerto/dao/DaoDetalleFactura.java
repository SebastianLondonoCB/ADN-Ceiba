package com.ceiba.puerto.dao;

import java.util.Collection;

import com.ceiba.modelo.dto.DtoDetalleFactura;

public interface DaoDetalleFactura {

	/**
	 * Permite listar los terceros
	 * @return
	 */
	Collection<DtoDetalleFactura> listar();
}
