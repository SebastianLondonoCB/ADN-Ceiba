package com.ceiba.adaptador.datastore;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.ceiba.modelo.dto.DtoTercero;
import com.ceiba.modelo.entidad.Tercero;

/**
 * Solo se debe usar data store para pruebas en un contexto real deberia usar una bd
 *
 */
@Component
public class TerceroDataStore {

	private static ConcurrentHashMap<String,Tercero> terceros;

	static {
		terceros = new ConcurrentHashMap<>();
		
	    Date fechaNacimiento = null;
		try {
			fechaNacimiento = new SimpleDateFormat("dd/MM/yyyy").parse("27/06/1998");
		} catch (ParseException e) {
			e.printStackTrace();
		} 
				
		terceros.put(UUID.randomUUID().toString(),new Tercero("1040756785", "Cédula de ciudadania", "Sebastian", "Londoño Zapata", "VIP",
				"3104368735", "sebastianlondonozapata@gmail.com", fechaNacimiento));
	} 
	
	public Collection<Tercero> get() {
		return terceros.values();
	}
	
	public Collection<DtoTercero> getAsDto() {
		return terceros.values().stream()
				  				 .map(tercero -> new DtoTercero(tercero.getIdentificacion(), tercero.getTipoIdentificacion(),
				  						tercero.getNombre(), tercero.getApellidos(), tercero.getTipoCliente(), tercero.getTelefono(),
				  						tercero.getEmail(), tercero.getFechaNacimiento())).collect(Collectors.toList());
	}
	
	public void put(Tercero tercero) {
		terceros.put(UUID.randomUUID().toString(), tercero);
	}
}
