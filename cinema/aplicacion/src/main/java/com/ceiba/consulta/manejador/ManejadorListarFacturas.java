package com.ceiba.consulta.manejador;

import java.util.Collection;

import org.springframework.stereotype.Component;

import com.ceiba.modelo.dto.DtoFactura;
import com.ceiba.puerto.dao.DaoFactura;

@Component
public class ManejadorListarFacturas {

	private final DaoFactura daoFactura;
	
	public ManejadorListarFacturas(DaoFactura daoFactura) {
		this.daoFactura = daoFactura;
	}
	
	public Collection<DtoFactura> ejecutar() {
		return this.daoFactura.listar();
	}
}
