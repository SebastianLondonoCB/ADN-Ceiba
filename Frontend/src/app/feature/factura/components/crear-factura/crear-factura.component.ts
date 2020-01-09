import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormArray, FormControl, Validators } from '@angular/forms';
import { DatePipe } from '@angular/common';
import { FacturaService } from '../../shared/service/factura.service';
import { Router } from '@angular/router';
import { Factura } from '../../shared/model/factura';
import { ProductoService } from 'src/app/feature/producto/shared/service/producto.service';
import { Producto } from 'src/app/feature/producto/shared/model/producto';
import { DetalleFactura } from '../../shared/model/detalleFactura';
import { Cliente } from 'src/app/feature/cliente/shared/model/cliente';
import { ClienteService } from 'src/app/feature/cliente/shared/service/cliente.service';

@Component({
  selector: 'app-crear-factura',
  templateUrl: './crear-factura.component.html',
  styleUrls: ['./crear-factura.component.css']
})

export class CrearFacturaComponent implements OnInit {
 
  private clientes: Cliente[]; 
  private productos: Producto[];
  private facturaFormulario: FormGroup;
  private detalleFactura: FormArray;
  private factura: Factura; 
  private error: string;
  private editSale: boolean;

  constructor(
    private formBuilder: FormBuilder, 
    private router: Router,
    private facturaService: FacturaService, 
    private productoService: ProductoService,
    private clienteService: ClienteService,
    private datePipe: DatePipe) { }

  ngOnInit() {
    //this.factura = this.facturaService.getCurrentSale();

    this.facturaFormulario = this.formBuilder.group({
      idFactura: this.factura == null? '':this.factura.idFactura,
      identificacionCliente:  this.factura == null? '':this.factura.identificacionCliente,
      fechaFactura: this.factura == null? this.datePipe.transform(new Date(), "yyyy-MM-dd"):this.factura.fechaFactura,
      plazoFactura: this.factura == null? 0:this.factura.plazoFactura,
      fechaVencimiento: this.factura == null? this.datePipe.transform(new Date(), "yyyy-MM-dd"):this.factura.fechaVencimiento,
      subtotalFactura:  this.factura == null? 0:this.factura.subtotalFactura,
      ivaFactura:  this.factura == null? 0:this.factura.ivaFactura,
      descuentosFactura:  this.factura == null? 0:this.factura.descuentosFactura,
      totalFactura:  this.factura == null? 0:this.factura.totalFactura,
      utilidadFactura:  this.factura == null? 0:this.factura.utilidadFactura,
      detalleFactura: this.formBuilder.array([this.createItem(null)])
    });  
 
    this.productoService.consultar().subscribe((productos) => { 
      this.productos = productos; 
      if(null != this.factura)
        this.initItems(this.factura.detalleFactura);
    });
 
    this.clienteService.consultar().subscribe((clientes) => { 
      this.clientes = clientes; 
    });
  }

  initItems(details:DetalleFactura[]){
    // let detail:any;
     this.detalleFactura = this.facturaFormulario.get('detalleFactura') as FormArray;    
     this.detalleFactura.clear();
     details.forEach(detail=>{
       console.log("detail");
       console.log(detail);
       this.detalleFactura.push(this.createItem(detail));
     });    
   }

  createItem(item: DetalleFactura): FormGroup {
    return this.formBuilder.group({
      idFactura: item == null? '':new FormControl({ value: item.idFactura, disabled: true }),
      codigoProducto: item == null? '':new FormControl({ value: item.codigoProducto, disabled: true }),
      descripcionProducto: item == null? '':new FormControl({ value: item.descripcionProducto, disabled: true }),
      precioUnitario: item == null? 0:new FormControl({ value: item.precioUnitario, disabled: true }, Validators.required),
      cantidad: item == null? 1:new FormControl({ value: item.cantidad, disabled: true }),
      subtotal: item == null? 0:new FormControl({ value: item.subtotal, disabled: true }),
      porcentajeIva: item == null? 0:new FormControl({ value: item.porcentajeIva, disabled: true }),
      precioIva: item == null? 0:new FormControl({ value: item.precioIva, disabled: true }),
      precioTotal: new FormControl({ value:  item == null?null:item.precioTotal, disabled: true }, Validators.required),
      precioCompra: item == null? 0:new FormControl({ value: item.precioCompra, disabled: true }),
      utilidad: item == null? 0:new FormControl({ value: item.utilidad, disabled: true }),      
    });
  }
  
  calcularTabla() {
    var itemsTabla: FormArray;
    itemsTabla = this.facturaFormulario.get('detalleFactura') as FormArray;
    
    let subtotalGeneral = 0;
    let ivaGeneral = 0;
    let descuentoGeneral = 0;
    let totalGeneral = 0;
    let utilidadFactura = 0;

    let vacios = 0;

    for (let i = 0; i < itemsTabla.length; i++) {
      var productos: Producto;
      productos = itemsTabla.at(i).get("codigoProducto").value;

      if (productos.codigo == undefined) {
        vacios++;
        continue;
      }

      let cantidad = itemsTabla.at(i).get("cantidad").value;
      let subtotal = cantidad * productos.precioVenta;
      itemsTabla.at(i).get("precioUnitario").setValue(productos.precioVenta);
      itemsTabla.at(i).get("subtotal").setValue(subtotal);
      itemsTabla.at(i).get("porcentajeIva").setValue(productos.ivaVenta);
                                            
      let iva =  subtotal * productos.ivaVenta / 100;
      let utilidad = (subtotal + iva) - (productos.precioCompra * cantidad);
      //itemsTabla.at(i).get("precioIva").setValue(iva);
      itemsTabla.at(i).get("precioTotal").setValue(subtotal + iva);
      itemsTabla.at(i).get("utilidad").setValue(utilidad);

      subtotalGeneral = subtotalGeneral + subtotal;
      ivaGeneral = ivaGeneral + iva;
      descuentoGeneral = descuentoGeneral;
      totalGeneral = totalGeneral + subtotal + iva;
      utilidadFactura = utilidadFactura + utilidad;
    }                                         

    this.facturaFormulario.controls['subtotalFactura'].setValue(subtotalGeneral);
    this.facturaFormulario.controls['ivaFactura'].setValue(ivaGeneral);
    this.facturaFormulario.controls['descuentosFactura'].setValue(descuentoGeneral);
    this.facturaFormulario.controls['totalFactura'].setValue(totalGeneral);
    this.facturaFormulario.controls['utilidadFactura'].setValue(utilidadFactura);

    if (vacios == 0)
      this.addItem(); 
  }

  sumarDiasAFecha(){
    var fecha = new Date();
    var dias = this.facturaFormulario.get('plazoFactura').value;
    fecha.setDate(fecha.getDate() + dias);
    this.facturaFormulario.controls['fechaVencimiento'].setValue(this.datePipe.transform(fecha, "yyyy-MM-dd"));
  }

  addItem(): void {
    this.detalleFactura = this.facturaFormulario.get('detalleFactura') as FormArray;
    this.detalleFactura.push(this.createItem(null)); 
  }

  irReimpresiones() {
    this.router.navigate(['factura/listar']);
  }

  cancelarVenta() {
    if (window.confirm('¿Esta seguro que desea cancelar la venta?'))
    this.irReimpresiones();
  }

  eliminarProducto(i: number): void {
    this.detalleFactura = this.facturaFormulario.get('detalleFactura') as FormArray;
    if (this.detalleFactura.length > 1) {
      this.detalleFactura.removeAt(i);
      this.calcularTabla();
    }
  }

  guardarVenta() {

    if (window.confirm('¿Esta seguro que desea guardar la venta?'))

    var factura: Factura;
    factura = {
      idFactura: this.facturaFormulario.controls['idFactura'].value,
      identificacionCliente: this.facturaFormulario.controls['identificacionCliente'].value.identificacion,
      fechaFactura: this.facturaFormulario.controls['fechaFactura'].value,
      plazoFactura: this.facturaFormulario.controls['plazoFactura'].value,
      fechaVencimiento: this.facturaFormulario.controls['fechaVencimiento'].value,
      subtotalFactura: this.facturaFormulario.controls['subtotalFactura'].value,
      ivaFactura: this.facturaFormulario.controls['ivaFactura'].value,
      descuentosFactura: this.facturaFormulario.controls['descuentosFactura'].value,
      totalFactura: this.facturaFormulario.controls['totalFactura'].value,
      utilidadFactura: this.facturaFormulario.controls['utilidadFactura'].value,
      detalleFactura:  this.getDetalleFactura()
    }

    this.facturaService.guardar(factura).subscribe(data => {
      this.irReimpresiones();
    },
    error=>{
      this.error = error.error.mensaje;
    });
  }

  getDetalleFactura(): DetalleFactura[] {
    var productos: FormArray;
    productos = this.facturaFormulario.get('detalleFactura') as FormArray;
    var producto: Producto;

    let detalles: DetalleFactura[];
    detalles = [];

    for (let i = 0; i < productos.length; i++) {
      producto = productos.at(i).get("codigoProducto").value;
      if (producto.codigo == undefined) {
        continue;
      }

      let cantidad = productos.at(i).get("cantidad").value;
      let subtotal = cantidad * producto.precioVenta;
      let iva =  subtotal * producto.ivaVenta / 100;
      let total = subtotal + iva;
      let utilidad = total - producto.precioCompra;

      detalles.push({
        idFactura: this.facturaFormulario.controls['idFactura'].value,
        codigoProducto: producto.codigo,
        descripcionProducto: producto.descripcion,
        precioUnitario: producto.precioVenta,
        cantidad: cantidad,
        subtotal: subtotal,
        porcentajeIva: producto.ivaVenta,
        precioIva: iva,
        precioTotal: total,
        precioCompra: producto.precioCompra,
        utilidad: utilidad
      });
    }
    return detalles;
  }
}