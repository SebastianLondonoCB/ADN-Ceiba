package com.ceiba.controlador;

import java.util.Collection;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.consulta.manejador.ManejadorListarFacturas;
import com.ceiba.modelo.dto.DtoFactura;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/facturas")
@Api(tags = { "Controlador facturas"})
public class ConsultaControladorFactura {
	
	private final ManejadorListarFacturas manejadorListarFacturas;
	
	public ConsultaControladorFactura(ManejadorListarFacturas manejadorListarFacturas) {
		this.manejadorListarFacturas = manejadorListarFacturas;
	}

	@RequestMapping(method=RequestMethod.GET)
	@ApiOperation("listar")
	public Collection<DtoFactura> listar() {
		return this.manejadorListarFacturas.ejecutar();
	}
}
