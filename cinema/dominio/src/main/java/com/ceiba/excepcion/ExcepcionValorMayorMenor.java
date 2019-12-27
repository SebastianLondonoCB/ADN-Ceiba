package com.ceiba.excepcion;

public class ExcepcionValorMayorMenor extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
    public ExcepcionValorMayorMenor(String message) {
        super(message);
    }
}
