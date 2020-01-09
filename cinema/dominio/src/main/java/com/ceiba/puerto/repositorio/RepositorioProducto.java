package com.ceiba.puerto.repositorio;

import com.ceiba.modelo.entidad.Producto;

public interface RepositorioProducto {
	
	/**
	 * Permite crear las peliculas
	 * @param pelicula
	 */
	void crear(Producto producto);
	
	/**
	 * Permite determinar si previamente se registro la pelicula
	 * @param pelicula
	 * @return si existe o no
	 */
	boolean existe(Producto producto);
	
	/**
	 * Permite determinar si previamente se registro la pelicula
	 * @param pelicula
	 * @return si existe o no
	 */
	void modificar(Producto producto);
}
