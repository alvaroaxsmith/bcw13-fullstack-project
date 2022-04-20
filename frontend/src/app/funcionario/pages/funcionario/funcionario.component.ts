import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-funcionario',
  templateUrl: './funcionario.component.html',
  styleUrls: ['./funcionario.component.css']
})
export class FuncionarioComponent implements OnInit {

  idFuncionario!: number | null

  constructor(
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.idFuncionario = parseInt(this.route.snapshot.paramMap.get('idFuncionario') || '')
  }
}
