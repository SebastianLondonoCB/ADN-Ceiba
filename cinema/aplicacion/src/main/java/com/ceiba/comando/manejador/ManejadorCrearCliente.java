package com.ceiba.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.comando.ComandoCliente;
import com.ceiba.comando.fabrica.FabricaCliente;
import com.ceiba.modelo.entidad.Cliente;
import com.ceiba.servicio.ServicioCrearCliente;

@Component
public class ManejadorCrearCliente {

	private final ServicioCrearCliente servicioCrearTercero;
	private final FabricaCliente fabricaTercero;
	
	public ManejadorCrearCliente(ServicioCrearCliente servicioCrearTercero, FabricaCliente fabricaTercero) {
		this.servicioCrearTercero = servicioCrearTercero;
		this.fabricaTercero = fabricaTercero;
	}
	
	public void ejecutar(ComandoCliente comandoTercero) {
		Cliente tercero = this.fabricaTercero.crear(comandoTercero);
		this.servicioCrearTercero.ejecutar(tercero);
	}
	
}
