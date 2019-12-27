package com.ceiba.consulta.manejador;

import java.util.Collection;

import org.springframework.stereotype.Component;

import com.ceiba.modelo.dto.DtoCliente;
import com.ceiba.puerto.dao.DaoCliente;

@Component
public class ManejadorListarClientes {

	private final DaoCliente daoTercero;
	
	public ManejadorListarClientes(DaoCliente daoTercero) {
		this.daoTercero = daoTercero;
	}
	
	public Collection<DtoCliente> ejecutar() {
		return this.daoTercero.listar();
	}
}
