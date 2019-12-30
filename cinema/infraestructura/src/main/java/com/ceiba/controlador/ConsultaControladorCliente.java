package com.ceiba.controlador;

import java.util.Collection;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.consulta.manejador.ManejadorListarClientes;
import com.ceiba.modelo.dto.DtoCliente;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/clientes")
@Api(tags = { "Controlador terceros"})
public class ConsultaControladorCliente {
	
	private final ManejadorListarClientes manejadorListarTerceros;
	
	public ConsultaControladorCliente(ManejadorListarClientes manejadorListarTerceros) {
		this.manejadorListarTerceros = manejadorListarTerceros;
	}

	@RequestMapping(method=RequestMethod.GET)
	@ApiOperation("listar")
	public Collection<DtoCliente> listar() {
		return this.manejadorListarTerceros.ejecutar();
	}
}
