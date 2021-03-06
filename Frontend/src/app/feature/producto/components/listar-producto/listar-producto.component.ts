import { Component, OnInit } from '@angular/core';
import { ProductoService } from '../../shared/service/producto.service';
import { Producto } from '../../shared/model/producto';
import { Router } from '@angular/router';

@Component({
  selector: 'app-listar-producto',
  templateUrl: './listar-producto.component.html',
  styleUrls: ['./listar-producto.component.css']
})
export class ListarProductoComponent implements OnInit {

  productos:Producto[];

  constructor(protected productoService: ProductoService, private router:Router) { }

  ngOnInit() {

    this.productoService.setProducto(null);

    this.productoService.consultar()
    .subscribe(data=>{
      this.productos=data as Producto[];
    })
  }

  Editar(producto: Producto) {
    this.router.navigate(['/producto/crear']);
    this.productoService.setProducto(producto);
  }

  Delete(codigo: String) {

    alert("entro");
    this.productoService.eliminar(codigo);

    /*.subscribe(data=>{
      alert("Eliminado con exito");
    }) */
  }

}
