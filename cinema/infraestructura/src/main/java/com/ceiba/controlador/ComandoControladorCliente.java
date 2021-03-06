package com.ceiba.controlador;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.comando.ComandoCliente;
import com.ceiba.comando.manejador.ManejadorCrearCliente;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/clientes")
@Api(tags = { "Controlador terceros"})
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST})

public class ComandoControladorCliente {

	private final ManejadorCrearCliente manejadorCrearTercero;
	
	public ComandoControladorCliente(ManejadorCrearCliente manejadorCrearTercero) {
		this.manejadorCrearTercero = manejadorCrearTercero;
	}
	
	@PostMapping
	@ApiOperation("crear")
	public void crear(@RequestBody ComandoCliente comandoTercero) {
		this.manejadorCrearTercero.ejecutar(comandoTercero);
	}
}
