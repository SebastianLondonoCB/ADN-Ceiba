package com.ceiba.modelo.entidad;

import com.ceiba.excepcion.ExcepcionLongitudValor;
import com.ceiba.excepcion.ExcepcionValorObligatorio;
import com.ceiba.excepcion.ExcepcionValorMayorMenor;

public class ValidadorArgumento {

	private ValidadorArgumento() {
	}

	public static void validarObligatorio(Object valor, String mensaje) {
		if (valor == null) {
			throw new ExcepcionValorObligatorio(mensaje);
		}
	}

	public static void validarValorMayorACero(Double valor, String mensaje) {
		if (valor <= 0) {			
			throw new ExcepcionValorMayorMenor(mensaje);
		}
	}
	
	public static void validarLongitud(String valor, int longitud, String mensaje) {
		if (valor.length() < longitud) {
			throw new ExcepcionLongitudValor(mensaje);
		}
	}
	
	public static void validarMenorACien(Integer valor, String mensaje) {
		if (valor >= 100) {
			throw new ExcepcionValorMayorMenor(mensaje);
		}
	}
}
