import { Component, OnInit } from '@angular/core';
import { Factura } from '../../shared/model/factura';
import { FacturaService } from '../../shared/service/factura.service';

@Component({
  selector: 'app-listar-factura',
  templateUrl: './listar-factura.component.html',
  styleUrls: ['./listar-factura.component.css']
})
export class ListarFacturaComponent implements OnInit {

  facturas: Factura[];
  constructor(protected facturaService: FacturaService) { }

  ngOnInit() {
    this.facturaService.consultar()
    .subscribe(data=>{
      this.facturas=data;
    })
  }

}
