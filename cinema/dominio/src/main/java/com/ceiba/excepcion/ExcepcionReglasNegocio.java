package com.ceiba.excepcion;

public class ExcepcionReglasNegocio extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
    public ExcepcionReglasNegocio(String message) {
        super(message);
    }
}
