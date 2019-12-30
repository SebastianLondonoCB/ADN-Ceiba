package com.ceiba.controlador;

import java.util.Collection;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.consulta.manejador.ManejadorListarDetalleFacturas;
import com.ceiba.modelo.dto.DtoDetalleFactura;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/detalles_facturas")
@Api(tags = { "Controlador detalles facturas"})
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST})

public class ConsultaControladorDetalleFactura {
	
	private final ManejadorListarDetalleFacturas manejadorListarDetalleFacturas;
	
	public ConsultaControladorDetalleFactura(ManejadorListarDetalleFacturas manejadorListarDetalleFacturas) {
		this.manejadorListarDetalleFacturas = manejadorListarDetalleFacturas;
	}

	@RequestMapping(method=RequestMethod.GET)
	@ApiOperation("listar")
	public Collection<DtoDetalleFactura> listar() {
		return this.manejadorListarDetalleFacturas.ejecutar();
	}
}
