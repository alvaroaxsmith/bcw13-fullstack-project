import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Servicos } from '../models/servicos';

@Injectable()

export class ServicosHttpService {

  private readonly baseURL = 'http://localhost:8080/servicos/servico'

  constructor(
    private http: HttpClient
  ) {}

  getServicos(): Observable<Servicos[]> {
    return this.http.get<Servicos[]>(this.baseURL)
  }
  getServicosById(id: number): Observable<Servicos>{
    return this.http.get<Servicos>('${this.baseURL}/${id}')
  }

}
