import { Injectable } from '@angular/core';
import {BehaviorSubject, Subject} from "rxjs";
import {Trabajo} from "../../../model/trabajo.model";

@Injectable()
export class DetailTrabajoService {

  //private trabajoSource: Subject<Trabajo> = new Subject<Trabajo>();
  trabajoO$: Subject<Trabajo | null> = new BehaviorSubject<Trabajo | null>(null);


  private trabajoSource  = new BehaviorSubject<any>([]);

  private pruebaSource = new Subject<string>();


  trabajo$ = this.trabajoSource.asObservable();
  prueba$ = this.pruebaSource.asObservable()

  constructor() { }

  sendTrabajo(trabajo: Trabajo){
    this.trabajoSource.next(trabajo);
  }

  sendPrueba(trabajo: Trabajo){
    this.trabajoO$.next(trabajo)
  }
}
