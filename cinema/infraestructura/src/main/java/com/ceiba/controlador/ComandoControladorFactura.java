package com.ceiba.controlador;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.comando.ComandoFactura;
import com.ceiba.comando.manejador.ManejadorCrearFactura;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/facturas")
@Api(tags = { "Controlador facturas"})
public class ComandoControladorFactura {

	private final ManejadorCrearFactura manejadorCrearFactura;
	
	public ComandoControladorFactura(ManejadorCrearFactura manejadorCrearFactura) {
		this.manejadorCrearFactura = manejadorCrearFactura;
	}
	
	@PostMapping
	@ApiOperation("crear")
	public void crear(@RequestBody ComandoFactura comandoFactura) {
		this.manejadorCrearFactura.ejecutar(comandoFactura);
	}
}
