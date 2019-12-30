import { Component, OnInit } from '@angular/core';
import { ClienteService } from '../../shared/service/cliente.service';
import { Cliente } from '../../shared/model/cliente';

@Component({
  selector: 'app-listar-cliente',
  templateUrl: './listar-cliente.component.html',
  styleUrls: ['./listar-cliente.component.css']
})
export class ListarClienteComponent implements OnInit {

  clientes:Cliente[];

  constructor(protected clienteService: ClienteService) { }

  ngOnInit() {
    this.clienteService.consultar()
    .subscribe(data=>{
      this.clientes=data;
    })
  }
}