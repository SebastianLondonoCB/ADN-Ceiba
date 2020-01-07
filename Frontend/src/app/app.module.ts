import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { HomeComponent } from './feature/home/home.component';
import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { CoreModule } from './core/core.module';
import { CookieService } from 'ngx-cookie-service';
import { ReactiveFormsModule } from '@angular/forms';
import { FormsModule } from '@angular/forms';
import { ProductoModule } from './feature/producto/producto.module';
import { FacturaModule } from './feature/factura/factura.module';
import { DatePipe } from '@angular/common';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ProductoModule,
    FacturaModule,
    CoreModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [CookieService, DatePipe],
    bootstrap: [AppComponent],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AppModule { }
