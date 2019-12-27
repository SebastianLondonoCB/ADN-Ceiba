package com.ceiba.adaptador.datastore;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.ceiba.modelo.dto.DtoCliente;
import com.ceiba.modelo.entidad.Cliente;

/**
 * Solo se debe usar data store para pruebas en un contexto real deberia usar una bd
 *
 */
@Component
public class TerceroDataStore {

	private static ConcurrentHashMap<String,Cliente> terceros;

	static {
		terceros = new ConcurrentHashMap<>();
		
	    Date fechaNacimiento = null;
		try {
			fechaNacimiento = new SimpleDateFormat("dd/MM/yyyy").parse("27/06/1998");
		} catch (ParseException e) {
			e.printStackTrace();
		} 
				
		terceros.put(UUID.randomUUID().toString(),new Cliente("1040756785", "C�dula de ciudadania", "Sebastian", "Londono Zapata", "VIP",
				"3104368735", "sebastianlondonozapata@gmail.com", fechaNacimiento));
	} 
	
	public Collection<Cliente> get() {
		return terceros.values();
	}
	
	public Collection<DtoCliente> getAsDto() {
		return terceros.values().stream()
				  				 .map(tercero -> new DtoCliente(tercero.getIdentificacion(), tercero.getTipoIdentificacion(),
				  						tercero.getNombre(), tercero.getApellidos(), tercero.getTipoCliente(), tercero.getTelefono(),
				  						tercero.getEmail(), tercero.getFechaNacimiento())).collect(Collectors.toList());
	}
	
	public void put(Cliente tercero) {
		terceros.put(UUID.randomUUID().toString(), tercero);
	}
}
