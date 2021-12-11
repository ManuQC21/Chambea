import { Injectable } from '@angular/core';
import {HttpClient, HttpParams, HttpResponse} from "@angular/common/http";
import {environment} from "../../../environments/environment";
import {Observable} from "rxjs";
import {Usuario} from "./usuario.model";
import {UserLoginModel} from "./user-login.model";
import {UsuarioDto} from "../../model/usuarioDto";
import {CreateUserRequest} from "./user-creation.model";

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

  log(creds: UserLoginModel): Observable<any>{
    return this.http.post<any>(
      `${this.apiBase}/test`,
      creds,
      {observe : "response"}
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

  signIn(usuario: CreateUserRequest): Observable<any>{
    return this.http.post<any>(
      `${this.apiBase}/otroTest`,
      usuario,
      {observe : "response"}
    )
  }

}
