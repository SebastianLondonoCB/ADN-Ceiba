package com.ceiba.controlador;

import java.util.Collection;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.consulta.manejador.ManejadorListarTerceros;
import com.ceiba.modelo.dto.DtoTercero;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/terceros")
@Api(tags = { "Controlador terceros"})
public class ConsultaControladorTercero {
	
	private final ManejadorListarTerceros manejadorListarTerceros;
	
	public ConsultaControladorTercero(ManejadorListarTerceros manejadorListarTerceros) {
		this.manejadorListarTerceros = manejadorListarTerceros;
	}

	@RequestMapping(method=RequestMethod.GET)
	@ApiOperation("listar")
	public Collection<DtoTercero> listar() {
		return this.manejadorListarTerceros.ejecutar();
	}
}
