package com.ceiba.adaptador.datastore;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.logging.Level; 
import java.util.logging.Logger; 
import org.springframework.stereotype.Component;

import com.ceiba.modelo.dto.DtoCliente;
import com.ceiba.modelo.entidad.Cliente;

/**
 * Solo se debe usar data store para pruebas en un contexto real deberia usar una bd
 *
 */
@Component
public class TerceroDataStore {

	static Logger logger = Logger.getLogger(TerceroDataStore.class.getName()); 
	private static ConcurrentHashMap<String,Cliente> terceros;

	static {
		terceros = new ConcurrentHashMap<>();
		
	    Date fechaNacimiento = null;
		try {
			fechaNacimiento = new SimpleDateFormat("dd/MM/yyyy").parse("27/06/1998");
		} catch (ParseException e) {
			logger.log(Level.INFO, "Error en la fecha de nacimiento"); 
		} 
				
		terceros.put(UUID.randomUUID().toString(),new Cliente("00000", "Cédula de ciudadania", "Ventas", "de contado", "VIP",
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
