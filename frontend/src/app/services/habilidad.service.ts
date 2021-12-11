import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Habilidad} from "../model/habilidad.model";
import {Observable} from "rxjs";
import {Trabajo} from "../model/trabajo.model";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class HabilidadService {

  private apiBase : string = `${environment.apiBase}/habilidades`;


  constructor(
    private http: HttpClient
  ) { }

  getAll() : Observable<Habilidad[]>{
    return this.http.get<Habilidad[]>(
      this.apiBase
    )
}
}
