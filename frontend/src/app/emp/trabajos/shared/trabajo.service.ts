import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Trabajo} from "../../../model/trabajo.model";
import {environment} from "../../../../environments/environment";
import {Observable} from "rxjs";
import {Duracion} from "../../../model/duracion.model";

@Injectable({
  providedIn: 'root'
})
export class TrabajoService {

  private apiBase : string = `${environment.apiBase}/trabajos`;

  constructor(
    private http: HttpClient
  ) { }

  createTrabajo(trabajo: Trabajo) {
    return this.http.post(
      `${this.apiBase}`,
      trabajo
    )
  }

  get() : Observable<Trabajo[]>{
    return this.http.get<Trabajo[]>(
      `${this.apiBase}`
    )
  }

  getByEmpleador(id: number) : Observable<Trabajo[]>{
    let params = new HttpParams()
    params = params.set('empleador', id)
    return this.http.get<Trabajo[]>(
      `${this.apiBase}/byEmployer`,
      {
        params : params
      }
    )
  }

  getById(id: number) : Observable<Trabajo>{
    return this.http.get<Trabajo>(
      `${this.apiBase}/${id}`
    )
  }

  getDuraciones(): Observable<Duracion[]>{
    return this.http.get<Duracion[]>(
      `${this.apiBase}/duraciones`
    )
  }
}
