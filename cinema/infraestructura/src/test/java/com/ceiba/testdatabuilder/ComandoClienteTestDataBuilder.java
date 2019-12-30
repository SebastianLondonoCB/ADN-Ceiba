package com.ceiba.testdatabuilder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.ceiba.comando.ComandoCliente;
import com.ceiba.modelo.entidad.Cliente;

public class ComandoClienteTestDataBuilder {

	private String identificacion;
	private String tipoIdentificacion;
	private String nombre;
	private String apellidos;
	private String tipoCliente;
	private String telefono;
	private String email;
	private Date fechaNacimiento;

	public ComandoClienteTestDataBuilder() {

		this.identificacion = "1040756786";
		this.tipoIdentificacion = "Cedula de ciudadania";
		this.nombre = "Sebastian";
		this.apellidos = "Londoño Zapata";
		this.tipoCliente = "V.I.P";
		this.telefono = "3104368735";
		this.email = "sebastianlondonozapata@gmail.com";

		Date fechaNacimiento = null;
		try {
			fechaNacimiento = new SimpleDateFormat("dd/MM/yyyy").parse("27/06/1998");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.fechaNacimiento = fechaNacimiento;
	}

	public ComandoClienteTestDataBuilder conIdentificacion(String identificacion) {
		this.identificacion = identificacion;
		return this;
	}

	public ComandoClienteTestDataBuilder conTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
		return this;
	}

	public ComandoClienteTestDataBuilder conNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public ComandoClienteTestDataBuilder conApellidos(String apellidos) {
		this.apellidos = apellidos;
		return this;
	}

	public ComandoClienteTestDataBuilder conTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
		return this;
	}

	public ComandoClienteTestDataBuilder conTelefono(String telefono) {
		this.telefono = telefono;
		return this;
	}

	public ComandoClienteTestDataBuilder conEmail(String email) {
		this.email = email;
		return this;
	}

	public ComandoClienteTestDataBuilder conFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
		return this;
	}

	public ComandoCliente build() {
		return new ComandoCliente(identificacion, tipoIdentificacion, nombre, apellidos, tipoCliente, telefono, email,
				fechaNacimiento);
	}

}
