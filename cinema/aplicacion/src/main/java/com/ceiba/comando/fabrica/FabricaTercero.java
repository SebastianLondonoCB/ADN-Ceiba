package com.ceiba.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.comando.ComandoTercero;
import com.ceiba.modelo.entidad.Tercero;

@Component
public class FabricaTercero {

	public Tercero crear(ComandoTercero comandoTercero) {
		return new Tercero(comandoTercero.getIdentificacion(), comandoTercero.getTipoIdentificacion(), comandoTercero.getNombre(),
				comandoTercero.getApellidos(), comandoTercero.getTipoCliente(), comandoTercero.getTelefono(), comandoTercero.getEmail(),
				comandoTercero.getFechaNacimiento());
	}
}
