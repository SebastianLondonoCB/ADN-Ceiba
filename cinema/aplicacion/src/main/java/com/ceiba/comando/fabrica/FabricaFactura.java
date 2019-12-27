package com.ceiba.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.comando.ComandoFactura;
import com.ceiba.modelo.entidad.Factura;

@Component
public class FabricaFactura {

	public Factura crear(ComandoFactura comandoFactura) {		
		return new Factura(comandoFactura.getIdFactura(), comandoFactura.getIdentificacionCliente(), comandoFactura.getFechaFactura(),
				comandoFactura.getPlazoFactura(), comandoFactura.getFechaVencimiento(), comandoFactura.getSubtotalFactura(),
				comandoFactura.getIvaFactura(), comandoFactura.getDescuentosFactura(), comandoFactura.getTotalFactura(),
				comandoFactura.getUtilidadFactura(), comandoFactura.getDetalleFactura());
	}
}
