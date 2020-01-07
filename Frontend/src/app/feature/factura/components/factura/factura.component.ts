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
  selector: 'app-factura',
  templateUrl: './factura.component.html',
  styleUrls: ['./factura.component.css']
})

export class FacturaComponent implements OnInit {
 
  private clientes: Cliente[]; 
  private productos: Producto[];
  private facturaFormulario: FormGroup;
  private detalleFactura: FormArray;
  private factura: Factura; 
  private editSale:boolean 

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
      fechaFactura: this.factura == null? this.datePipe.transform(new Date(), "dd/MM/yyyy"):this.factura.fechaFactura,
      plazoFactura: this.factura == null? 0:this.factura.plazoFactura,
      fechaVencimiento: this.factura == null? this.datePipe.transform(new Date(), "dd/MM/yyyy"):this.factura.fechaVencimiento,
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
      itemsTabla.at(i).get("precioIva").setValue(iva);
      itemsTabla.at(i).get("precioTotal").setValue(subtotal + iva);

      subtotalGeneral = subtotalGeneral + subtotal;
      ivaGeneral = ivaGeneral + iva;
      descuentoGeneral = descuentoGeneral;
      totalGeneral = totalGeneral + subtotal + iva;
    }

    this.facturaFormulario.controls['subtotalFactura'].setValue(subtotalGeneral);
    this.facturaFormulario.controls['ivaFactura'].setValue(ivaGeneral);
    this.facturaFormulario.controls['descuentosFactura'].setValue(descuentoGeneral);
    this.facturaFormulario.controls['totalFactura'].setValue(totalGeneral);

    if (vacios == 0)
      this.addItem(); 
  }

  saveSale() {
    /*var datosFactura: Factura;

    datosFactura = {
      id: 0,
      nombreCliente: this.orderForm.controls['cliente'].value,
      fecha: this.orderForm.controls['fecha'].value,
      total: this.orderForm.controls['total'].value,
      details: this.getSaleDetails()
    }

    console.log(header);
    this.salesService.addSale(header).subscribe(data => {
      console.log(data);
      this.gotoSales();
    },
    error=>{
      this.error = error.error.message;
    }
    );*/
  } 

  addItem(): void {
    this.detalleFactura = this.facturaFormulario.get('detalleFactura') as FormArray;
    this.detalleFactura.push(this.createItem(null)); 
  }

  eliminarProducto(i: number): void {
    this.detalleFactura = this.facturaFormulario.get('detalleFactura') as FormArray;
    if (this.detalleFactura.length > 1) {
      this.detalleFactura.removeAt(i);
      this.calcularTabla();
    }
  }
}