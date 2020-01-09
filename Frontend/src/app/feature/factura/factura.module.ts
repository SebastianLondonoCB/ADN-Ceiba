import { NgModule } from '@angular/core';
import { FacturaRoutingModule } from './factura-routing.module';
import { FacturaComponent } from './components/factura/factura.component';
import { SharedModule } from 'src/app/shared/shared.module';
import { ReactiveFormsModule } from '@angular/forms';
import { FormsModule } from '@angular/forms';
import { ListarFacturaComponent } from './components/listar-factura/listar-factura.component';
import { CrearFacturaComponent } from './components/crear-factura/crear-factura.component';

@NgModule({
  declarations: [
    ListarFacturaComponent,
    FacturaComponent,
    CrearFacturaComponent
  ],
  imports: [
    FacturaRoutingModule,
    SharedModule,
    ReactiveFormsModule,
    FormsModule
  ]
})
export class FacturaModule { }
