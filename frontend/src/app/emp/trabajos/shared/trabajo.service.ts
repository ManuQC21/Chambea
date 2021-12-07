import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Trabajo} from "../../../model/trabajo.model";
import {environment} from "../../../../environments/environment";
import {Observable} from "rxjs";

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
}
