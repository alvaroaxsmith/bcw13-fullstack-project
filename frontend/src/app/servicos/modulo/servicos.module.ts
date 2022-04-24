import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ServicosRoutingModule } from './servicos-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { ServicosComponent } from '../pages/servicos/servicos.component';
import { ServicosHttpService } from '../services/servico-http.service';







@NgModule({
  declarations: [
    ServicosComponent
  ],
  imports: [
    CommonModule,
    ServicosRoutingModule,
    HttpClientModule
  ],
  providers:[
    ServicosHttpService
  ]
})
export class ServicosModule { }
