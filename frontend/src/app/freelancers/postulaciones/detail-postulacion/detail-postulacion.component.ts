import {Component, OnDestroy, OnInit} from '@angular/core';
import {PostulacionService} from "../shared/postulacion.service";
import {Postulacion} from "../../../model/postulacion.model";
import {ActivatedRoute, NavigationEnd, NavigationStart, Router} from "@angular/router";
import {Trabajo} from "../../../model/trabajo.model";
import {DetailPostulacionService} from "./detail-postulacion.service";
import {Subscription} from "rxjs";

@Component({
  selector: 'app-detail-postulacion',
  templateUrl: './detail-postulacion.component.html',
  styleUrls: ['./detail-postulacion.component.css'],
  providers: [ DetailPostulacionService ]

})
export class DetailPostulacionComponent implements OnInit, OnDestroy {

  postulacion?: Postulacion
  trabajo?: Trabajo
  routerSubscription = new Subscription()

  constructor(
    private route: ActivatedRoute,
    private postulacionService: PostulacionService,
    private detailService: DetailPostulacionService,
    private router: Router
  )
  {
    this.routerSubscription = this.router.events.subscribe((event) => {
      if (event instanceof NavigationStart) {
      }
      if (event instanceof NavigationEnd) {
        this.getPostulacion()
      }
    });
  }

  ngOnInit(): void {
    this.getPostulacion()
  }

  getPostulacion(){
    const id = this.route.snapshot.paramMap.get('id')
    this.postulacionService.getById(Number(id)).subscribe(
      (data) => {
        this.postulacion =  data
        this.trabajo = this.postulacion.trabajo
        this.enviarPostulacion(this.postulacion)
      }
    )
  }

  enviarPostulacion(postulacion:Postulacion){
    this.detailService.sendPostulacion(postulacion)
  }

  ngOnDestroy() {
    this.routerSubscription.unsubscribe();
  }

}
