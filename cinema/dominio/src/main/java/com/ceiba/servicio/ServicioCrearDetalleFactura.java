package com.ceiba.servicio;

import com.ceiba.modelo.entidad.DetalleFactura;
import com.ceiba.puerto.repositorio.RepositorioDetalleFactura;

public class ServicioCrearDetalleFactura {

	private RepositorioDetalleFactura repositorioDetalleFactura;
	
	public ServicioCrearDetalleFactura(RepositorioDetalleFactura repositorioDetalleFactura) {
		this.repositorioDetalleFactura = repositorioDetalleFactura;
	}
	
	public void ejecutar(DetalleFactura detalleFactura) {
		this.repositorioDetalleFactura.crear(detalleFactura);
	}
}
