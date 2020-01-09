import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SecurityGuard } from './core/guard/security.guard';

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  //{ path: 'home', component: HomeComponent, canActivate: [SecurityGuard]  },
  { path: 'producto', loadChildren: () => import('./feature/producto/producto.module').then(mod => mod.ProductoModule) },
  { path: 'cliente', loadChildren: () => import('./feature/cliente/cliente.module').then(mod => mod.ClienteModule) },
  { path: 'factura', loadChildren: () => import('./feature/factura/factura.module').then(mod => mod.FacturaModule) }  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
