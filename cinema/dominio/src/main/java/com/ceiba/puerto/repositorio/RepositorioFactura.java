package com.ceiba.puerto.repositorio;

import com.ceiba.modelo.entidad.Factura;

public interface RepositorioFactura {
	
	/**
	 * Permite crear las peliculas
	 * @param pelicula
	 */
	void crear(Factura factura);
	
	/**
	 * Permite determinar si previamente se registro la pelicula
	 * @param pelicula
	 * @return si existe o no
	 */
	boolean existe(Factura factura);
}
