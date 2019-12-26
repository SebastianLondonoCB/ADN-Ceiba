package com.ceiba.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.comando.ComandoProducto;
import com.ceiba.modelo.entidad.Producto;

@Component
public class FabricaProducto {

	public Producto crear(ComandoProducto comandoProducto) {		
		return new Producto(comandoProducto.getCodigo(), comandoProducto.getDescripcion(), comandoProducto.getGrupo(),
				comandoProducto.getIvaVenta(), comandoProducto.getPrecioVenta(), comandoProducto.getPrecioCompra());
	}
	
}
