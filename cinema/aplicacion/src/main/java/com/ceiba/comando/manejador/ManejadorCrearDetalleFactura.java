package com.ceiba.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.comando.ComandoDetalleFactura;
import com.ceiba.comando.fabrica.FabricaDetalleFactura;
import com.ceiba.modelo.entidad.DetalleFactura;
import com.ceiba.servicio.ServicioCrearDetalleFactura;

@Component
public class ManejadorCrearDetalleFactura {

	private final ServicioCrearDetalleFactura servicioCrearDetalleFactura;
	private final FabricaDetalleFactura fabricaDetalleFactura;
	
	public ManejadorCrearDetalleFactura(ServicioCrearDetalleFactura servicioCrearFactura, FabricaDetalleFactura fabricaFactura) {
		this.servicioCrearDetalleFactura = servicioCrearFactura;
		this.fabricaDetalleFactura = fabricaFactura;
	}
	
	public void ejecutar(ComandoDetalleFactura comandoDetalleFactura) {
		DetalleFactura detalleFactura = this.fabricaDetalleFactura.crear(comandoDetalleFactura);
		this.servicioCrearDetalleFactura.ejecutar(detalleFactura);
	}
	
}
