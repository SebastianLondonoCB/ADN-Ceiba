package com.ceiba.adaptador.servicio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.adaptador.datastore.TerceroDataStore;
import com.ceiba.adaptador.datastore.ProductoDataStore;
import com.ceiba.adaptador.datastore.FacturaDataStore;
import com.ceiba.adaptador.datastore.DetalleFacturaDataStore;
import com.ceiba.adaptador.repositorio.RepositorioTerceroEnMemoria;
import com.ceiba.adaptador.repositorio.RepositorioProductoEnMemoria;
import com.ceiba.adaptador.repositorio.RepositorioFacturaEnMemoria;
import com.ceiba.adaptador.repositorio.RepositorioDetalleFacturaEnMemoria;
import com.ceiba.servicio.ServicioCrearCliente;
import com.ceiba.servicio.ServicioCrearProducto;
import com.ceiba.servicio.ServicioCrearFactura;
import com.ceiba.servicio.ServicioCrearDetalleFactura;

@Configuration
public class BeanServicio {
	
	@Bean
	public ServicioCrearCliente servicioCrearTercero() {
		return new ServicioCrearCliente(new RepositorioTerceroEnMemoria(new TerceroDataStore()));
	}
	
	@Bean
	public ServicioCrearProducto servicioCrearProducto() {
		return new ServicioCrearProducto(new RepositorioProductoEnMemoria(new ProductoDataStore()));
	}
	
	@Bean
	public ServicioCrearFactura servicioCrearFactura() {
		return new ServicioCrearFactura(new RepositorioFacturaEnMemoria(new FacturaDataStore()));
	}

	@Bean
	public ServicioCrearDetalleFactura servicioCrearDetalleFactura() {
		return new ServicioCrearDetalleFactura(new RepositorioDetalleFacturaEnMemoria(new DetalleFacturaDataStore()));
	}
}
