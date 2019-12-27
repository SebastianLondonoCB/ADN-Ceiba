package com.ceiba.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.comando.ComandoDetalleFactura;
import com.ceiba.modelo.entidad.DetalleFactura;

@Component
public class FabricaDetalleFactura {

	public DetalleFactura crear(ComandoDetalleFactura comandoDetalleFactura) {		
		return new DetalleFactura(comandoDetalleFactura.getIdFactura(), comandoDetalleFactura.getCodigoProducto(), 
				comandoDetalleFactura.getDescripcionProducto(), comandoDetalleFactura.getPrecioUnitario(),
				comandoDetalleFactura.getCantidad(), comandoDetalleFactura.getPorcentajeIva(), comandoDetalleFactura.getPrecioIva(),
				comandoDetalleFactura.getPrecioTotal(), comandoDetalleFactura.getPrecioCompra(), comandoDetalleFactura.getUtilidad());
	}
}
