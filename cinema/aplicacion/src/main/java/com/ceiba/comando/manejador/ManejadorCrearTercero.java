package com.ceiba.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.comando.ComandoTercero;
import com.ceiba.comando.fabrica.FabricaTercero;
import com.ceiba.modelo.entidad.Tercero;
import com.ceiba.servicio.ServicioCrearTercero;

@Component
public class ManejadorCrearTercero {

	private final ServicioCrearTercero servicioCrearTercero;
	private final FabricaTercero fabricaTercero;
	
	public ManejadorCrearTercero(ServicioCrearTercero servicioCrearTercero, FabricaTercero fabricaTercero) {
		this.servicioCrearTercero = servicioCrearTercero;
		this.fabricaTercero = fabricaTercero;
	}
	
	public void ejecutar(ComandoTercero comandoTercero) {
		Tercero tercero = this.fabricaTercero.crear(comandoTercero);
		this.servicioCrearTercero.ejecutar(tercero);
	}
	
}
