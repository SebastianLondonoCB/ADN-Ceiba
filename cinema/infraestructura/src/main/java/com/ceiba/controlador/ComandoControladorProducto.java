package com.ceiba.controlador;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.comando.ComandoProducto;
import com.ceiba.comando.manejador.ManejadorCrearProducto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/productos")
@Api(tags = { "Controlador productos"})
public class ComandoControladorProducto {

	private final ManejadorCrearProducto manejadorCrearProducto;
	
	public ComandoControladorProducto(ManejadorCrearProducto manejadorCrearProducto) {
		this.manejadorCrearProducto = manejadorCrearProducto;
	}
	
	@PostMapping
	@ApiOperation("crear")
	public void crear(@RequestBody ComandoProducto comandoProducto) {
		this.manejadorCrearProducto.ejecutar(comandoProducto);
	}
}
