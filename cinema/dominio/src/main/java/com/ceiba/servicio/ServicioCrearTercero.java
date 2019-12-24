package com.ceiba.servicio;

import com.ceiba.excepcion.ExcepcionDuplicidad;
import com.ceiba.modelo.entidad.Tercero;
import com.ceiba.puerto.repositorio.RepositorioTercero;

public class ServicioCrearTercero {

	private static final String EL_TERCERO_YA_EXISTE_EN_EL_SISTEMA = "El tercero ya existe en el sistema";
	
	private RepositorioTercero repositorioTercero;
	
	public ServicioCrearTercero(RepositorioTercero repositorioTercero) {
		this.repositorioTercero = repositorioTercero;
	}
	
	public void ejecutar(Tercero tercero) {
		validarExistenciaPrevia(tercero);
		this.repositorioTercero.crear(tercero);
	}

	private void validarExistenciaPrevia(Tercero tercero) {
		boolean existe = this.repositorioTercero.existe(tercero);
		if(existe) {
			throw new ExcepcionDuplicidad(EL_TERCERO_YA_EXISTE_EN_EL_SISTEMA);
		}
	}
}
