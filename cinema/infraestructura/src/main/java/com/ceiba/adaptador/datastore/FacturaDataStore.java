package com.ceiba.adaptador.datastore;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.ceiba.modelo.dto.DtoDetalleFactura;
import com.ceiba.modelo.dto.DtoFactura;
import com.ceiba.modelo.entidad.Factura;

/**
 * Solo se debe usar data store para pruebas en un contexto real deberia usar
 * una bd
 *
 */
@Component
public class FacturaDataStore {

	private static ConcurrentHashMap<String, Factura> facturas;

	static {
		Date fechaFactura = null;
		try {
			fechaFactura = new SimpleDateFormat("dd/MM/yyyy").parse("27/12/2019");
		} catch (ParseException e) {
			System.err.println(e);
		}
		
		Date fechaVencimiento = null;
		try {
			fechaVencimiento = new SimpleDateFormat("dd/MM/yyyy").parse("30/12/2019");
		} catch (ParseException e) {
			System.err.println(e);
		}
				
		List<DtoDetalleFactura> listado = new ArrayList<DtoDetalleFactura>(); 
		listado.add(new DtoDetalleFactura("FACT-1", "01", "ESTUCHE SILI CONCASE VERDE", 20000.0, 1.0, 
				0, 0.0, 20000.0, 16000.0, 4000.0));
		
		facturas = new ConcurrentHashMap<>();
		facturas.put(UUID.randomUUID().toString(),
				new Factura("FACT-1", "1040756785", fechaFactura, 3, fechaVencimiento, 20000.0, 0.0, 0.0, 20000.0, 
						4000.0, listado));
	}

	public Collection<Factura> get() {
		return facturas.values();
	}

	public Collection<DtoFactura> getAsDto() {
		return facturas.values().stream()
				.map(factura -> new DtoFactura(factura.getIdFactura(), factura.getIdentificacionCliente(), factura.getFechaFactura(),
						factura.getPlazoFactura(), factura.getFechaVencimiento(), factura.getSubtotalFactura(), factura.getIvaFactura(),
						factura.getDescuentosFactura(), factura.getTotalFactura(), factura.getUtilidadFactura(), factura.getDetalleFactura()))
				.collect(Collectors.toList());
	}

	public void put(Factura factura) {
		facturas.put(UUID.randomUUID().toString(), factura);
	}
}
