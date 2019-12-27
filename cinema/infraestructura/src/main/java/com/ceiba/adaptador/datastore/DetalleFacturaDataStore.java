package com.ceiba.adaptador.datastore;

import java.util.Collection;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.ceiba.modelo.dto.DtoDetalleFactura;
import com.ceiba.modelo.entidad.DetalleFactura;

/**
 * Solo se debe usar data store para pruebas en un contexto real deberia usar
 * una bd
 *
 */
@Component
public class DetalleFacturaDataStore {

	private static ConcurrentHashMap<String, DetalleFactura> detalleFacturas;

	static {
		detalleFacturas = new ConcurrentHashMap<>();
		detalleFacturas.put(UUID.randomUUID().toString(),
				new DetalleFactura("FACT-1", "01", "ESTUCHE SILI CONCASE VERDE", 20000.0, 1.0, 0, 0.0, 20000.0, 16000.0, 4000.0));
	}

	public Collection<DetalleFactura> get() {
		return detalleFacturas.values();
	}

	public Collection<DtoDetalleFactura> getAsDto() {
		return detalleFacturas.values().stream()
				.map(detalleFactura -> new DtoDetalleFactura(detalleFactura.getIdFactura(), detalleFactura.getCodigoProducto(),
						detalleFactura.getDescripcionProducto(), detalleFactura.getPrecioUnitario(), detalleFactura.getCantidad(),
						detalleFactura.getPorcentajeIva(), detalleFactura.getPrecioIva(), detalleFactura.getPrecioTotal(),
						detalleFactura.getPrecioCompra(), detalleFactura.getUtilidad()))
				.collect(Collectors.toList());
	}

	public void put(DetalleFactura detalleFactura) {
		detalleFacturas.put(UUID.randomUUID().toString(), detalleFactura);
	}
}
