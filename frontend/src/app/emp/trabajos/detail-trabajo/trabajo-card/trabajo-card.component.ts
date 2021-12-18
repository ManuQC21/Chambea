import {Component, Input, OnChanges, OnDestroy, OnInit} from '@angular/core';
import {Trabajo} from "../../../../model/trabajo.model";
import {DetailTrabajoService} from "../detail-trabajo.service";
import {Subscription} from "rxjs";
import {TrabajoService} from "../../shared/trabajo.service";
import {Router} from "@angular/router";
import {PostulacionService} from "../../../../freelancers/postulaciones/shared/postulacion.service";
import {Postulacion} from "../../../../model/postulacion.model";

@Component({
  selector: 'app-trabajo-card',
  templateUrl: './trabajo-card.component.html',
  styleUrls: ['./trabajo-card.component.css']
})
export class TrabajoCardComponent implements OnInit, OnDestroy, OnChanges {

  @Input() trabajo?: Trabajo;
  postulaciones?: Postulacion[];

  subscription : Subscription

  constructor(
    private detailService: DetailTrabajoService,
    private trabajoService: TrabajoService,
    private postulacionService: PostulacionService,
    private router: Router
  ) {
    this.subscription = detailService.trabajo$.subscribe(
      data => {
        this.trabajo = data;
        this.getPostulaciones()
      }
    )

  }

  delete(id: number){
    const ok = confirm('¿Seguro de eliminar el trabajo?')
    if (ok){
      this.trabajoService.delete(id).subscribe(
        () => {
          this.subscription.unsubscribe()
          this.router.navigate(['emp/home'])
        }
      )
    }

  }

  getPostulaciones(){
    if (this.trabajo){
      this.postulacionService.getByTrabajo(<number>this.trabajo?.idTrabajo).subscribe(
        data => this.postulaciones = data
      )
    }
  }

  ngOnChanges(){

  }

  ngOnInit(): void {
  }

  ngOnDestroy(){
    this.subscription.unsubscribe();
  }

}
