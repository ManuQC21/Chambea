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
      `${this.apiBase}/login`,
      creds,
      {observe : "response"}
    )
  }


  signIn(usuario: CreateUserRequest): Observable<any>{
    return this.http.post<any>(
      `${this.apiBase}/signup`,
      usuario,
      {observe : "response"}
    )
  }

}
