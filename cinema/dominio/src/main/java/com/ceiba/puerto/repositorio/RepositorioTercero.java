package com.ceiba.puerto.repositorio;

import com.ceiba.modelo.entidad.Tercero;

public interface RepositorioTercero {
	
	/**
	 * Permite crear las peliculas
	 * @param pelicula
	 */
	void crear(Tercero tercero);
	
	/**
	 * Permite determinar si previamente se registro la pelicula
	 * @param pelicula
	 * @return si existe o no
	 */
	boolean existe(Tercero tercero);
}
