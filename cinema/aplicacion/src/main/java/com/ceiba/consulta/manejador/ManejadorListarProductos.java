package com.ceiba.consulta.manejador;

import java.util.Collection;

import org.springframework.stereotype.Component;

import com.ceiba.modelo.dto.DtoProducto;
import com.ceiba.puerto.dao.DaoProducto;

@Component
public class ManejadorListarProductos {

	private final DaoProducto daoProducto;
	
	public ManejadorListarProductos(DaoProducto daoProducto) {
		this.daoProducto = daoProducto;
	}
	
	public Collection<DtoProducto> ejecutar() {
		return this.daoProducto.listar();
	}
}
