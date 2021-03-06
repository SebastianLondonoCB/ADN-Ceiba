import { Component } from '@angular/core';
import { Item } from '@ceiba/navbar';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app-base';
  public companies: Item[] = [
    { url: '/producto/listar', nombre: 'Productos' },
    { url: '/cliente/listar', nombre: 'Clientes' },
    { url: '/factura/listar', nombre: 'Facturas' },
  ];  
}
