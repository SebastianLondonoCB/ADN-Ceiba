import { NgModule } from '@angular/core';
import { ClienteRoutingModule } from './cliente-routing.module';
import { BorrarClienteComponent } from './components/borrar-cliente/borrar-cliente.component';
import { ListarClienteComponent } from './components/listar-cliente/listar-cliente.component';
import { CrearClienteComponent } from './components/crear-cliente/crear-cliente.component';
import { ClienteComponent } from './components/cliente/cliente.component';
import { SharedModule } from 'src/app/shared/shared.module';
import { ReactiveFormsModule } from '@angular/forms';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    CrearClienteComponent,
    ListarClienteComponent,
    BorrarClienteComponent,
    ClienteComponent
  ],
  imports: [
    ClienteRoutingModule,
    SharedModule,
    ReactiveFormsModule,
    FormsModule
  ]
})
export class ClienteModule { }
