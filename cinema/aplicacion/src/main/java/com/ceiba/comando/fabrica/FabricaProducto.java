package com.ceiba.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.comando.ComandoProducto;
import com.ceiba.modelo.entidad.Producto;

@Component
public class FabricaProducto {

	public Producto crear(ComandoProducto comandoProducto) {
		
		System.out.println("yo veo aver si es real o que");
		
		return new Producto(comandoProducto.getCodigo(), comandoProducto.getDescripcion(), comandoProducto.getGrupo(),
				comandoProducto.getIvaVenta(), comandoProducto.getLista1(), comandoProducto.getLista2(), comandoProducto.getPrecioCompra());
	}
	
}
