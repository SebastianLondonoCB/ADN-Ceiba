import { Injectable } from '@angular/core';
import { BaseService } from 'src/app/core/services/base.service';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Producto } from '../model/producto';

@Injectable({
  providedIn: 'root'
})
export class ProductoService extends BaseService {

  constructor(protected http: HttpClient) { super(http); }

  private producto: Producto;

  setProducto (producto: Producto) {
    this.producto = producto;
  }

  getProducto () {
    return this.producto;
  }

  public consultarCache() {
    return this.doGet<Producto[]>(`${environment.endpoint}productos/productos`, this.optsNameCache('consultar productos con cache'));
  }

  public consultar() {
    return this.doGet<Producto[]>(`${environment.endpoint}/productos`, this.optsName('consultar productos'));
  }

  public guardar(producto: Producto) {
    return this.doPost<Producto, boolean>(`${environment.endpoint}/productos`, producto, this.optsName('crear/actualizar productos'));
  }

  public eliminar(codigo: String) {
    return this.doDelete<Producto, boolean>(`${environment.endpoint}/productos/`, codigo, this.optsName('eliminar productos'));
  }
}
