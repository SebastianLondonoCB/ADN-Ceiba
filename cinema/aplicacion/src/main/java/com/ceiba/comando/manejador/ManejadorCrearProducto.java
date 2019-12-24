package com.ceiba.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.comando.ComandoProducto;
import com.ceiba.comando.fabrica.FabricaProducto;
import com.ceiba.modelo.entidad.Producto;
import com.ceiba.servicio.ServicioCrearProducto;

@Component
public class ManejadorCrearProducto {

	private final ServicioCrearProducto servicioCrearProducto;
	private final FabricaProducto fabricaProducto;
	
	public ManejadorCrearProducto(ServicioCrearProducto servicioCrearProducto, FabricaProducto fabricaProducto) {
		this.servicioCrearProducto = servicioCrearProducto;
		this.fabricaProducto = fabricaProducto;
	}
	
	public void ejecutar(ComandoProducto comandoProducto) {
		Producto producto = this.fabricaProducto.crear(comandoProducto);
		this.servicioCrearProducto.ejecutar(producto);
	}
	
}
