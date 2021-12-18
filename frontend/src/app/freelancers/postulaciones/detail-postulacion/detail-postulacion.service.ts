import { Injectable } from '@angular/core';
import {BehaviorSubject, Subject} from "rxjs";
import {Postulacion} from "../../../model/postulacion.model";

@Injectable()
export class DetailPostulacionService {


  postulacion0$: Subject<Postulacion | null> = new BehaviorSubject<Postulacion | null>(null);


  private postulacionSource  = new BehaviorSubject<any>([]);

  private pruebaSource = new Subject<string>();


  postulacion$ = this.postulacionSource.asObservable();
  prueba$ = this.pruebaSource.asObservable()

  constructor() { }

  sendPostulacion(postulacion: Postulacion){
    this.postulacionSource.next(postulacion);
  }

  sendPrueba(postulacion: Postulacion){
    this.postulacion0$.next(postulacion)
  }
}
