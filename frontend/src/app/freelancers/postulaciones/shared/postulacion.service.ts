import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {environment} from "../../../../environments/environment";
import {Postulacion} from "../../../model/postulacion.model";
import {Observable} from "rxjs";


@Injectable({
  providedIn: 'root'
})
export class PostulacionService {

  private apiBase : string = `${environment.apiBase}/postulaciones`;

  constructor(
    private http: HttpClient
  ) { }

  createPostulacion(postulacion: Postulacion): Observable<Postulacion>{
    return this.http.post<Postulacion>(
      this.apiBase,
      postulacion
    )
  }

  getAll(): Observable<Postulacion[]>{
    return this.http.get<Postulacion[]>(
      this.apiBase
    )
  }

  getById(id: number): Observable<Postulacion>{
    return this.http.get<Postulacion>(
      `${this.apiBase}/${id}`
    )
  }

  update(postulacion: Postulacion): Observable<Postulacion>{
    return this.http.put<Postulacion>(
      this.apiBase,
      postulacion
    )
  }

  delete(id: number) {
    return this.http.delete(
      `${this.apiBase}/${id}`
    )
  }

  getByFreelancer(id: number): Observable<Postulacion[]>{
    let params = new HttpParams()
    params = params.set("freelancer",id)

    return this.http.get<Postulacion[]>(
      `${this.apiBase}/byFreelancer`,
      {
        params: params
      }
    )
  }

  getByTrabajo(id: number): Observable<Postulacion[]>{
    let params = new HttpParams()
    params = params.set("trabajo",id)

    return this.http.get<Postulacion[]>(
      `${this.apiBase}/byTrabajo`,
      {
        params: params
      }
    )
  }


}
