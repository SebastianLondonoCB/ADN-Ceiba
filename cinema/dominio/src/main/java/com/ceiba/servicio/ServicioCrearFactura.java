package com.ceiba.servicio;

import com.ceiba.excepcion.ExcepcionDuplicidad;
import com.ceiba.modelo.entidad.Factura;
import com.ceiba.puerto.repositorio.RepositorioFactura;

public class ServicioCrearFactura {
	
	private static final String LA_FACTURA_YA_EXISTE_EN_EL_SISTEMA = "La factura ya existe en el sistema";
	
	private RepositorioFactura repositorioFactura;
	
	public ServicioCrearFactura(RepositorioFactura repositorioFactura) {
		this.repositorioFactura = repositorioFactura;
	}
	
	public void ejecutar(Factura factura) {
		validarExistenciaPrevia(factura);
		this.repositorioFactura.crear(factura);
	}

	private void validarExistenciaPrevia(Factura factura) {
		boolean existe = this.repositorioFactura.existe(factura);
		if(existe) {
			throw new ExcepcionDuplicidad(LA_FACTURA_YA_EXISTE_EN_EL_SISTEMA);
		}
	}
}
