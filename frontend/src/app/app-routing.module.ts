import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core'
import { RouterModule, Routes } from '@angular/router'

 const routes: Routes = [
  {
      path:'funcionario',
      loadChildren: () => import ('./funcionario/modulo/funcionario.module').then(m =>m.FuncionarioModule)
  },
  {

      path: 'servico',
      loadChildren: () => import('./servicos/modulo/servicos.module')
      .then(m => m.ServicosModule)

  },

]

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ],
  providers: []
})
export class AppRoutingModule {}
