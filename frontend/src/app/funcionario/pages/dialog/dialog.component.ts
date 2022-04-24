import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { Funcionario } from '../../models/funcionario';
import { FuncionarioHttpService } from '../../services/funcionario-http.service';

@Component({
  selector: 'app-dialog',
  templateUrl: './dialog.component.html',
  styleUrls: ['./dialog.component.css']
})
export class DialogComponent implements OnInit {


  id:number=0
  func!: Funcionario

  constructor(
    private msg : MatSnackBar,
    private funHttpService: FuncionarioHttpService,
    private router : Router


  ) { }

  ngOnInit(): void {

  }
  deletar():void{
    this.funHttpService.deleteFuncionarioById(this.id).subscribe((del) => {this.func = del})
    this.mensagem()
    this.router.navigateByUrl("")
    this.router.navigateByUrl("/funcionario")

 }
  mensagem():void{
    this.msg.open('Você excluiu um funcionário!!!', 'Fechar')
  }
}
