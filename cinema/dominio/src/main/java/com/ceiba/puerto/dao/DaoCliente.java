package com.ceiba.puerto.dao;

import java.util.Collection;

import com.ceiba.modelo.dto.DtoCliente;

public interface DaoCliente {

	/**
	 * Permite listar los terceros
	 * @return
	 */
	Collection<DtoCliente> listar();
}
