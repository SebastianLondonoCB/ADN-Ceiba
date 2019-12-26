package com.ceiba.controlador;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.comando.ComandoTercero;
import com.ceiba.comando.manejador.ManejadorCrearTercero;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/terceros")
@Api(tags = { "Controlador terceros"})
public class ComandoControladorTercero {

	private final ManejadorCrearTercero manejadorCrearTercero;
	
	public ComandoControladorTercero(ManejadorCrearTercero manejadorCrearTercero) {
		this.manejadorCrearTercero = manejadorCrearTercero;
	}
	
	@PostMapping
	@ApiOperation("crear")
	public void crear(@RequestBody ComandoTercero comandoTercero) {
		this.manejadorCrearTercero.ejecutar(comandoTercero);
	}
}