import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Funcionario } from '../../models/funcionario';
import { FuncionarioHttpService } from '../../services/funcionario-http.service';
import { DialogComponent } from '../dialog/dialog.component';

@Component({
  selector: 'app-listar-funcionario',
  templateUrl: './listar-funcionario.component.html',
  styleUrls: ['./listar-funcionario.component.css']
})
export class ListarFuncionarioComponent implements OnInit {

  funcionarios : Funcionario[]=[]
  columns: string[]= ['idFuncionario','nome','email','actions']

  constructor(
    private funHttpService: FuncionarioHttpService,
    public dialog: MatDialog,
     ) { }

  
  ngOnInit(): void {
    this.funHttpService.getFuncionarios().subscribe(
      (funcionarios) => {
        this.funcionarios =  funcionarios
      })

  }

   redirect():void{
    window.location.href = "http://localhost:4200/funcionario/novo-funcionario"
  }

  openDialog(id:number) {
    let dialogRef = this.dialog.open(DialogComponent);

    dialogRef.componentInstance.id=id
  }


}
