package com.ceiba.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.comando.ComandoFactura;
import com.ceiba.comando.fabrica.FabricaFactura;
import com.ceiba.modelo.entidad.Factura;
import com.ceiba.servicio.ServicioCrearFactura;

@Component
public class ManejadorCrearFactura {

	private final ServicioCrearFactura servicioCrearFactura;
	private final FabricaFactura fabricaFactura;
	
	public ManejadorCrearFactura(ServicioCrearFactura servicioCrearFactura, FabricaFactura fabricaFactura) {
		this.servicioCrearFactura = servicioCrearFactura;
		this.fabricaFactura = fabricaFactura;
	}
	
	public void ejecutar(ComandoFactura comandoFactura) {
		Factura factura = this.fabricaFactura.crear(comandoFactura);
		this.servicioCrearFactura.ejecutar(factura);
	}
}
