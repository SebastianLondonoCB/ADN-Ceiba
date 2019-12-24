package com.ceiba.adaptador.datastore;

import java.util.Collection;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.ceiba.modelo.dto.DtoProducto;
import com.ceiba.modelo.entidad.Producto;

/**
 * Solo se debe usar data store para pruebas en un contexto real deberia usar una bd
 *
 */
@Component
public class ProductoDataStore {

	private static ConcurrentHashMap<String,Producto> productos;

	static {		
		productos = new ConcurrentHashMap<>();
		productos.put(UUID.randomUUID().toString(), new Producto("01", "ESTUCHE SILI CONCASE VERDE", "ESTUCHES",
					19, 40000.0, 38000.0, 20000.0));	
	} 
	
	public Collection<Producto> get() {
		return productos.values();
	}
	
	public Collection<DtoProducto> getAsDto() {
		return productos.values().stream()
				  				 .map(producto -> new DtoProducto(producto.getCodigo(), producto.getDescripcion(), producto.getGrupo(),
				  						producto.getIvaVenta(), producto.getLista1(), producto.getLista2(), 
				  						producto.getPrecioCompra())).collect(Collectors.toList());
	}
	
	public void put(Producto producto) {
		productos.put(UUID.randomUUID().toString(), producto);
	}
}
