package com.ceiba.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.comando.ComandoCliente;
import com.ceiba.modelo.entidad.Cliente;

@Component
public class FabricaCliente {

	public Cliente crear(ComandoCliente comandoTercero) {
		return new Cliente(comandoTercero.getIdentificacion(), comandoTercero.getTipoIdentificacion(), comandoTercero.getNombre(),
				comandoTercero.getApellidos(), comandoTercero.getTipoCliente(), comandoTercero.getTelefono(), comandoTercero.getEmail(),
				comandoTercero.getFechaNacimiento());
	}
}
