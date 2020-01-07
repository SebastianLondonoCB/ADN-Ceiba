import { Injectable } from '@angular/core';
import { BaseService } from 'src/app/core/services/base.service';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { DetalleFactura } from '../model/DetalleFactura';

@Injectable({
  providedIn: 'root'
})
export class DetalleFacturaService extends BaseService {

  constructor(protected http: HttpClient) { super(http); }

  public consultarCache() {
    return this.doGet<DetalleFactura[]>(`${environment.endpoint}facturas/facturas`, this.optsNameCache('consultar facturas con cache'));
  }

  public consultar() {
    return this.doGet<DetalleFactura[]>(`${environment.endpoint}/facturas`, this.optsName('consultar facturas'));
  }

  public guardar(detalleFactura: DetalleFactura) {
    return this.doPost<DetalleFactura, boolean>(`${environment.endpoint}/facturas`, detalleFactura, 
        this.optsName('crear/actualizar facturas'));
  }

  public eliminar(detalleFactura: DetalleFactura) {
    return this.doPost<DetalleFactura, boolean>(`${environment.endpoint}/facturas`, detalleFactura, 
        this.optsName('eliminar facturas'));
  }
}
