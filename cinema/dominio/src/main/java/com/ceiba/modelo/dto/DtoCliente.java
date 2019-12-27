package com.ceiba.modelo.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class DtoCliente {
	private String identificacion;
	private String tipoIdentificacion;
	private String nombre;
	private String apellidos;
	private String tipoCliente;
	private String telefono;
	private String email;
	private Date fechaNacimiento;
}
