import { Component, OnInit } from '@angular/core';
import { ProductoService } from '../../shared/service/producto.service';
import { Producto } from '../../shared/model/producto';

@Component({
  selector: 'app-listar-producto',
  templateUrl: './listar-producto.component.html',
  styleUrls: ['./listar-producto.component.css']
})
export class ListarProductoComponent implements OnInit {

  productos:Producto[];

  constructor(protected productoService: ProductoService) { }

  ngOnInit() {
    this.productoService.consultar()
    .subscribe(data=>{
      this.productos=data as Producto[];
    })
  }
}
