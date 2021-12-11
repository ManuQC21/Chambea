import { Injectable } from '@angular/core';
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class DuracionService {

  private apiBase : string = `${environment.apiBase}/duracion`;

  constructor() { }
}
