package com.ceiba.controlador;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.comando.ComandoDetalleFactura;
import com.ceiba.comando.manejador.ManejadorCrearDetalleFactura;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/detalles_facturas")
@Api(tags = { "Controlador detalles facturas"})
public class ComandoControladorDetalleFactura {

	private final ManejadorCrearDetalleFactura manejadorCrearDetalleFactura;
	
	public ComandoControladorDetalleFactura(ManejadorCrearDetalleFactura manejadorCrearDetalleFactura) {
		this.manejadorCrearDetalleFactura = manejadorCrearDetalleFactura;
	}
	
	@PostMapping
	@ApiOperation("crear")
	public void crear(@RequestBody ComandoDetalleFactura comandoDetalleFactura) {
		this.manejadorCrearDetalleFactura.ejecutar(comandoDetalleFactura);
	}
}
