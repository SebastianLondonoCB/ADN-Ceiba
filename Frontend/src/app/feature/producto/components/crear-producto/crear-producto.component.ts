import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Producto } from '../../shared/model/producto';
import { ProductoService } from '../../shared/service/producto.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-crear-producto',
  templateUrl: './crear-producto.component.html',
  styleUrls: ['./crear-producto.component.css']
})
export class CrearProductoComponent implements OnInit {

  private accion: string;
  private accionBoton: string;
  private producto: Producto;
  private productoFormulario: FormGroup;
  private error:string;
  private editando: boolean;

  constructor(private formBuilder: FormBuilder, protected productoService: ProductoService,
     private router:Router) { }

  ngOnInit() {
    
    this.accion = "REGISTRAR";
    this.accionBoton = "Guardar";
    this.editando = false;

    this.producto = this.productoService.getProducto();
    if(this.producto != null) {
      this.accion = "MODIFICAR";
      this.accionBoton = "Modificar";
      this.editando = true;
    } 

    this.error = "";

    if (this.producto == undefined || this.producto.codigo == undefined)
      this.producto = { codigo: '', descripcion: '', grupo: '', ivaVenta: 0, precioVenta: 0, precioCompra: 0};

    this.productoFormulario = this.formBuilder.group({
      codigo: [this.producto.codigo, Validators.required],
      descripcion: [this.producto.descripcion, Validators.required],
      grupo: [this.producto.grupo, ''],
      ivaVenta: [this.producto.ivaVenta == 0 ? '' : this.producto.ivaVenta, Validators.required],
      precioVenta: [this.producto.precioVenta == 0 ? '' : this.producto.precioVenta, Validators.required],
      precioCompra: [this.producto.precioCompra == 0 ? '' : this.producto.precioCompra, Validators.required],
    })

     

  }

  get AddProductoFormCtrl() {
    return this.productoFormulario.controls;
  }

  guardar() {

    if (this.productoFormulario.invalid) {
      return;
    }

    this.producto = {
      codigo: this.AddProductoFormCtrl.codigo.value,
      descripcion: this.AddProductoFormCtrl.descripcion.value,
      grupo: this.AddProductoFormCtrl.grupo.value,
      ivaVenta: this.AddProductoFormCtrl.ivaVenta.value,
      precioVenta: this.AddProductoFormCtrl.precioVenta.value,
      precioCompra: this.AddProductoFormCtrl.precioCompra.value,
    }

    if(this.editando) {

      alert("como se dijo")
      this.productoService.modificar(this.producto).subscribe(data => {
        alert("Producto modificado con exito");
        this.ListarProductos();
      },
        error => this.error = error.error.message
      );
    } else {
      this.productoService.guardar(this.producto).subscribe(data => {
        alert("Producto registrado con exito");
        this.ListarProductos();
      },
        error => this.error = error.error.message
      );
    }
  }

  ListarProductos() {
    this.router.navigate(['/producto/listar']);
  }

}
