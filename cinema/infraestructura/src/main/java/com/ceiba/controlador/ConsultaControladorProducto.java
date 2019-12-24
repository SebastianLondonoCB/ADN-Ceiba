package com.ceiba.controlador;

import java.util.Collection;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.consulta.manejador.ManejadorListarProductos;
import com.ceiba.modelo.dto.DtoProducto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/productos")
@Api(tags = { "Controlador productos"})
public class ConsultaControladorProducto {
	
	private final ManejadorListarProductos manejadorListarProductos;
	
	public ConsultaControladorProducto(ManejadorListarProductos manejadorListarProductos) {
		this.manejadorListarProductos = manejadorListarProductos;
	}

	@RequestMapping(method=RequestMethod.GET)
	@ApiOperation("listar")
	public Collection<DtoProducto> listar() {
		return this.manejadorListarProductos.ejecutar();
	}
}
