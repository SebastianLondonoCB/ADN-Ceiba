import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ClienteService } from '../../shared/service/cliente.service';
import { Cliente } from '../../shared/model/cliente';

@Component({
  selector: 'app-crear-cliente',
  templateUrl: './crear-cliente.component.html',
  styleUrls: ['./crear-cliente.component.css']
})
export class CrearClienteComponent implements OnInit {

  private cliente: Cliente;
  private clienteFormulario: FormGroup;
  private error:string;

  constructor(private formBuilder: FormBuilder, protected clienteService: ClienteService,
    private router:Router) { }

  ngOnInit() {

    this.error = "";

    if (this.cliente == undefined || this.cliente.identificacion == undefined)
      this.cliente = { identificacion: '', tipoIdentificacion: '', nombre: '', apellidos: '', 
          tipoCliente: '', telefono: '', email: '', fechaNacimiento: null};

    this.clienteFormulario = this.formBuilder.group({
     
      identificacion: [this.cliente.identificacion, Validators.required],
      tipoIdentificacion: [this.cliente.tipoIdentificacion, Validators.required],
      nombre: [this.cliente.nombre, Validators.required],
      apellidos: [this.cliente.apellidos, Validators.required],
      tipoCliente: [this.cliente.tipoCliente, ''],
      telefono: [this.cliente.telefono, ''],
      email: [this.cliente.email, ''],
      fechaNacimiento: [this.cliente.fechaNacimiento, ''],
    })
  }

  get AddClienteFormCtrl() {
    return this.clienteFormulario.controls;
  }

  guardar() {
    if (this.clienteFormulario.invalid) {
      return;
    }

    this.cliente = {
      identificacion: this.AddClienteFormCtrl.identificacion.value,
      tipoIdentificacion: this.AddClienteFormCtrl.tipoIdentificacion.value,
      nombre: this.AddClienteFormCtrl.nombre.value,
      apellidos: this.AddClienteFormCtrl.apellidos.value,
      tipoCliente: this.AddClienteFormCtrl.tipoCliente.value,
      telefono: this.AddClienteFormCtrl.telefono.value,
      email: this.AddClienteFormCtrl.email.value,
      fechaNacimiento: this.AddClienteFormCtrl.fechaNacimiento.value,
    }

    this.clienteService.guardar(this.cliente).subscribe(data => {
      alert("Cliente registrado con exito");
      this.ListarClientes();
    },
      error => this.error = error.error.message
    );
  }

  ListarClientes() {
    this.router.navigate(['/cliente/listar']);
  }
}
