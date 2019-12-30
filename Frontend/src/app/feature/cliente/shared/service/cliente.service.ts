import { Injectable } from '@angular/core';
import { BaseService } from 'src/app/core/services/base.service';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Cliente } from '../model/cliente';

@Injectable({
  providedIn: 'root'
})
export class ClienteService extends BaseService {

  constructor(protected http: HttpClient) { super(http); }

  public consultarCache() {
    return this.doGet<Cliente[]>(`${environment.endpoint}clientes/clientes`, this.optsNameCache('consultar clientes con cache'));
  }

  public consultar() {
    return this.doGet<Cliente[]>(`${environment.endpoint}/clientes`, this.optsName('consultar clientes'));
  }

  public guardar(cliente: Cliente) {
    return this.doPost<Cliente, boolean>(`${environment.endpoint}/clientes`, cliente, this.optsName('crear/actualizar clientes'));
  }

  public eliminar(cliente: Cliente) {
    return this.doPost<Cliente, boolean>(`${environment.endpoint}/clientes`, cliente, this.optsName('eliminar clientes'));
  }
}
