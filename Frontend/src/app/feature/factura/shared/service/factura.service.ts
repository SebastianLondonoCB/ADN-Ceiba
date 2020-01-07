import { Injectable } from '@angular/core';
import { BaseService } from 'src/app/core/services/base.service';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Factura } from '../model/factura';

@Injectable({
  providedIn: 'root'
})
export class FacturaService extends BaseService {

  constructor(protected http: HttpClient) { super(http); }

  public consultarCache() {
    return this.doGet<Factura[]>(`${environment.endpoint}facturas/facturas`, this.optsNameCache('consultar facturas con cache'));
  }

  public consultar() {
    return this.doGet<Factura[]>(`${environment.endpoint}/facturas`, this.optsName('consultar facturas'));
  }

  public guardar(factura: Factura) {
    return this.doPost<Factura, boolean>(`${environment.endpoint}/facturas`, factura, this.optsName('crear/actualizar facturas'));
  }

  public eliminar(factura: Factura) {
    return this.doPost<Factura, boolean>(`${environment.endpoint}/facturas`, factura, this.optsName('eliminar facturas'));
  }
}
