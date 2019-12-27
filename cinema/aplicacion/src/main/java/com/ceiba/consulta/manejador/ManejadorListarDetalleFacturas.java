package com.ceiba.consulta.manejador;

import java.util.Collection;

import org.springframework.stereotype.Component;

import com.ceiba.modelo.dto.DtoDetalleFactura;
import com.ceiba.puerto.dao.DaoDetalleFactura;

@Component
public class ManejadorListarDetalleFacturas {

	private final DaoDetalleFactura daoDetalleFactura;
	
	public ManejadorListarDetalleFacturas(DaoDetalleFactura daoDetalleFactura) {
		this.daoDetalleFactura = daoDetalleFactura;
	}
	
	public Collection<DtoDetalleFactura> ejecutar() {
		return this.daoDetalleFactura.listar();
	}
}
