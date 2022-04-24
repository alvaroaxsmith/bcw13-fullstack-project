import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ServicosComponent } from '../pages/servicos/servicos.component';

const routes: Routes = [
  {
    path:'',
    pathMatch:'full',
    component: ServicosComponent
  },

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ServicosRoutingModule { }
