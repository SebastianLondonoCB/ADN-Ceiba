package com.ceiba.testdatabuilder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.ceiba.modelo.entidad.Cliente;

public class ClienteTestDataBuilder {

	private String identificacion;
	private String tipoIdentificacion;
	private String nombre;
	private String apellidos;
	private String tipoCliente;
	private String telefono;
	private String email;
	private Date fechaNacimiento;

	public ClienteTestDataBuilder() {

		this.identificacion = "1040756785";
		this.tipoIdentificacion = "Cedula de ciudadania";
		this.nombre = "Sebastian";
		this.apellidos = "Londoño Zapata";
		this.tipoCliente = "V.I.P";
		this.telefono = "2214527";
		this.email = "sebastianlondonozapata@gmail.com";

		Date fechaNacimiento = null;
		try {
			fechaNacimiento = new SimpleDateFormat("dd/MM/yyyy").parse("27/06/1998");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		this.fechaNacimiento = fechaNacimiento;

	}

	public ClienteTestDataBuilder conIdentificacion(String identificacion) {
		this.identificacion = identificacion;
		return this;
	}

	public ClienteTestDataBuilder conTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
		return this;
	}

	public ClienteTestDataBuilder conNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public ClienteTestDataBuilder conApellidos(String apellidos) {
		this.apellidos = apellidos;
		return this;
	}

	public ClienteTestDataBuilder conTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
		return this;
	}

	public ClienteTestDataBuilder conTelefono(String telefono) {
		this.telefono = telefono;
		return this;
	}

	public ClienteTestDataBuilder conEmail(String email) {
		this.email = email;
		return this;
	}

	public ClienteTestDataBuilder conFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
		return this;
	}

	public Cliente build() {
		return new Cliente(identificacion, tipoIdentificacion, nombre, apellidos, tipoCliente, telefono, email,
				fechaNacimiento);
	}
}
