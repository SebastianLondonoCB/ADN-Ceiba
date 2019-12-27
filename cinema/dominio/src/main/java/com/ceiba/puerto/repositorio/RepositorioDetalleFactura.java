package com.ceiba.puerto.repositorio;

import com.ceiba.modelo.entidad.DetalleFactura;

public interface RepositorioDetalleFactura {
	
	/**
	 * Permite crear el detalle factura
	 * @param pelicula
	 */
	void crear(DetalleFactura detalleFactura);
	
}
