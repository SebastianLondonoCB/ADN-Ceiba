package com.ceiba.consulta.manejador;

import java.util.Collection;

import org.springframework.stereotype.Component;

import com.ceiba.modelo.dto.DtoTercero;
import com.ceiba.puerto.dao.DaoCliente;

@Component
public class ManejadorListarTerceros {

	private final DaoCliente daoTercero;
	
	public ManejadorListarTerceros(DaoCliente daoTercero) {
		this.daoTercero = daoTercero;
	}
	
	public Collection<DtoTercero> ejecutar() {
		return this.daoTercero.listar();
	}
}
