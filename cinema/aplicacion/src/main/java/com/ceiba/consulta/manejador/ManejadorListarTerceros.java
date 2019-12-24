package com.ceiba.consulta.manejador;

import java.util.Collection;

import org.springframework.stereotype.Component;

import com.ceiba.modelo.dto.DtoTercero;
import com.ceiba.puerto.dao.DaoTercero;

@Component
public class ManejadorListarTerceros {

	private final DaoTercero daoTercero;
	
	public ManejadorListarTerceros(DaoTercero daoTercero) {
		this.daoTercero = daoTercero;
	}
	
	public Collection<DtoTercero> ejecutar() {
		return this.daoTercero.listar();
	}
}
