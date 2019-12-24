package com.ceiba.modelo.entidad;

import java.util.Date;

public class Tercero {

	private static final int TAMANO_MINIMO_NOMBRE = 2;
	private static final int TAMANO_MINIMO_APELLIDOS = 3;

	// Cantidad minimas
	private static final String EL_NOMBRE_DEBE_TENER_MINIMO_LETRAS = "El nombre debe tener mÃ­nimo %s letras.";
	private static final String EL_APELLIDO_DEBE_TENER_MINIMO_LETRAS = "El apellido debe tener mÃ­nimo %s letras.";

	// Datos obligatorios
	private static final String LA_IDENTIFICACION_ES_UN_DATO_OBLIGATORIO = "La identificación es un dato obligatorio.";
	private static final String EL_TIPO_IDENTIFICACION_ES_UN_DATO_OBLIGATORIO = "El tipo de identificación es un dato obligatorio.";
	private static final String EL_NOMBRE_ES_UN_DATO_OBLIGATORIO = "El nombre es un dato obligatorio.";
	private static final String EL_APELLIDO_ES_UN_DATO_OBLIGATORIO = "El apellido es un dato obligatorio.";
	private static final String EL_TIPO_CLIENTE_ES_UN_DATO_OBLIGATORIO = "El tipo de cliente es un dato obligatorio.";

	// Establecemos atributos
	private String identificacion;
	private String tipoIdentificacion;
	private String nombre;
	private String apellidos;
	private String tipoCliente;
	private String telefono;
	private String email;
	private Date fechaNacimiento;

	public Tercero(String identificacion, String tipoIdentificacion, String nombre, String apellidos,
			String tipoCliente, String telefono, String email, Date fechaNacimiento) {

		ValidadorArgumento.validarObligatorio(identificacion, LA_IDENTIFICACION_ES_UN_DATO_OBLIGATORIO);
		ValidadorArgumento.validarObligatorio(tipoIdentificacion, EL_TIPO_IDENTIFICACION_ES_UN_DATO_OBLIGATORIO);
		ValidadorArgumento.validarObligatorio(nombre, EL_NOMBRE_ES_UN_DATO_OBLIGATORIO);
		ValidadorArgumento.validarObligatorio(apellidos, EL_APELLIDO_ES_UN_DATO_OBLIGATORIO);
		ValidadorArgumento.validarObligatorio(tipoCliente, EL_TIPO_CLIENTE_ES_UN_DATO_OBLIGATORIO);

		ValidadorArgumento.validarLongitud(nombre, TAMANO_MINIMO_NOMBRE,
				String.format(EL_NOMBRE_DEBE_TENER_MINIMO_LETRAS, TAMANO_MINIMO_NOMBRE));

		ValidadorArgumento.validarLongitud(apellidos, TAMANO_MINIMO_APELLIDOS,
				String.format(EL_APELLIDO_DEBE_TENER_MINIMO_LETRAS, TAMANO_MINIMO_APELLIDOS));

		this.identificacion = identificacion;
		this.tipoIdentificacion = tipoIdentificacion;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.tipoCliente = tipoCliente;
		this.telefono = telefono;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public String getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public String getTipoCliente() {
		return tipoCliente;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getEmail() {
		return email;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
}
