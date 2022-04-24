import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FuncionarioRoutingModule } from './funcionario-routing.module';
import { NovoFuncionarioComponent } from '../pages/novo-funcionario/novo-funcionario.component';
import { MaterialModule } from '../../material/material.module';
import { ListarFuncionarioComponent } from '../pages/listar-funcionario/listar-funcionario.component';
import { HttpClientModule } from '@angular/common/http';
import { FuncionarioHttpService } from '../services/funcionario-http.service';
import { ReactiveFormsModule } from '@angular/forms';
import { FuncionarioComponent } from '../pages/funcionario/funcionario.component';
import { IsNumberGuard } from '../guards/is-number.guard';
import { DialogComponent } from '../pages/dialog/dialog.component';


@NgModule({
  declarations: [
    NovoFuncionarioComponent,
    ListarFuncionarioComponent,
    FuncionarioComponent,
    DialogComponent
  ],
  imports: [
    CommonModule,
    FuncionarioRoutingModule,
    MaterialModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [
    FuncionarioHttpService,
    IsNumberGuard
  ]
})
export class FuncionarioModule { }
