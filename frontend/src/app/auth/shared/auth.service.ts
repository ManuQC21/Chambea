import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {environment} from "../../../environments/environment";
import {Observable} from "rxjs";
import {Usuario} from "./usuario.model";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private apiBase : string = `${environment.apiBase}/auth`;

  constructor(private http: HttpClient) { }

  get(id: number): Observable<Usuario>{
    return this.http.get<Usuario>(
      `${this.apiBase}/${id}`
    )
  }

  logIn(username: string, password: string){

    let params = new HttpParams();
    params = params.append('usuario', username);
    params = params.append('password', password)

    console.log(params);

    return this.http.get(
      `${this.apiBase}/login`,
      {
        params: params
      }

    )
  }

  signIn(usuario: Usuario) {
    return this.http.post<Usuario>(
      `${this.apiBase}/signin`,
      usuario
    )
  }

}
