package com.ceiba.puerto.repositorio;

import com.ceiba.modelo.entidad.Cliente;

public interface RepositorioCliente {
	
	/**
	 * Permite crear las peliculas
	 * @param pelicula
	 */
	void crear(Cliente tercero);
	
	/**
	 * Permite determinar si previamente se registro la pelicula
	 * @param pelicula
	 * @return si existe o no
	 */
	boolean existe(Cliente tercero);
}