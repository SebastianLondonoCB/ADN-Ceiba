package com.ceiba.servicio;

import com.ceiba.excepcion.ExcepcionDuplicidad;
import com.ceiba.modelo.entidad.Cliente;
import com.ceiba.puerto.repositorio.RepositorioCliente;

public class ServicioCrearCliente {

	private static final String EL_TERCERO_YA_EXISTE_EN_EL_SISTEMA = "El tercero ya existe en el sistema";
	
	private RepositorioCliente repositorioTercero;
	
	public ServicioCrearCliente(RepositorioCliente repositorioTercero) {
		this.repositorioTercero = repositorioTercero;
	}
	
	public void ejecutar(Cliente tercero) {
	//	validarExistenciaPrevia(tercero);
		this.repositorioTercero.crear(tercero);
	}

	private void validarExistenciaPrevia(Cliente tercero) {
		/*boolean existe = this.repositorioTercero.existe(tercero);
		if(existe) {
			throw new ExcepcionDuplicidad(EL_TERCERO_YA_EXISTE_EN_EL_SISTEMA);
		}*/
	}
}
