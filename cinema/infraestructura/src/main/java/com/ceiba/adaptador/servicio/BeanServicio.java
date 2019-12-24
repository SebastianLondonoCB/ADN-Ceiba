package com.ceiba.adaptador.servicio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.adaptador.datastore.PeliculaDataStore;
import com.ceiba.adaptador.datastore.TerceroDataStore;
import com.ceiba.adaptador.datastore.ProductoDataStore;
import com.ceiba.adaptador.repositorio.RepositorioPeliculaEnMemoria;
import com.ceiba.adaptador.repositorio.RepositorioTerceroEnMemoria;
import com.ceiba.adaptador.repositorio.RepositorioProductoEnMemoria;
import com.ceiba.servicio.ServicioCrearPelicula;
import com.ceiba.servicio.ServicioCrearTercero;
import com.ceiba.servicio.ServicioCrearProducto;

@Configuration
public class BeanServicio {

	@Bean
	public ServicioCrearPelicula servicioCrearPelicula() {
		return new ServicioCrearPelicula(new RepositorioPeliculaEnMemoria(new PeliculaDataStore()));
	}
	
	@Bean
	public ServicioCrearTercero servicioCrearTercero() {
		return new ServicioCrearTercero(new RepositorioTerceroEnMemoria(new TerceroDataStore()));
	}
	
	@Bean
	public ServicioCrearProducto servicioCrearProducto() {
		return new ServicioCrearProducto(new RepositorioProductoEnMemoria(new ProductoDataStore()));
	}
}
