import {Component, Input, OnDestroy, OnInit} from '@angular/core';
import {Postulacion} from "../../../../model/postulacion.model";
import {Router} from "@angular/router";
import {PostulacionService} from "../../shared/postulacion.service";
import {Subscription} from "rxjs";
import {DetailPostulacionService} from "../detail-postulacion.service";

@Component({
  selector: 'app-postulacion-card',
  templateUrl: './postulacion-card.component.html',
  styleUrls: ['./postulacion-card.component.css']
})
export class PostulacionCardComponent implements OnInit, OnDestroy {

  @Input() postulacion?: Postulacion

  subscription: Subscription

  constructor(
    private router: Router,
    private postulacionService: PostulacionService,
    private detailService: DetailPostulacionService
  ) {
    this.subscription = this.detailService.postulacion$.subscribe(
      data => {
        this.postulacion = data;

      }
    )
  }

  ngOnInit(): void {
  }

  delete(idPostulacion: number) {
    const ok = confirm('¿Seguro de eliminar el trabajo?')
    if (ok){
      this.postulacionService.delete(idPostulacion).subscribe(
        () => this.router.navigate(['freelancers/home'])
      )
    }
  }

  ngOnDestroy(){
    this.subscription.unsubscribe();
  }

}


