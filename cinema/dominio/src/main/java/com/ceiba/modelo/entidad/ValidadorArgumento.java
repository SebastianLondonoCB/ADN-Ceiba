package com.ceiba.modelo.entidad;

import com.ceiba.excepcion.ExcepcionLongitudValor;
import com.ceiba.excepcion.ExcepcionValorObligatorio;

public class ValidadorArgumento {

	private ValidadorArgumento() {
	}

	public static void validarObligatorio(Object valor, String mensaje) {
		if (valor == null) {
			if (!valor.equals("")) {
				throw new ExcepcionValorObligatorio(mensaje);
			}
		}
	}

	public static void validarLongitud(String valor, int longitud, String mensaje) {
		if (valor.length() < longitud) {
			throw new ExcepcionLongitudValor(mensaje);
		}
	}
}
