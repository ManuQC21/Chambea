import {Component, OnDestroy, OnInit} from '@angular/core';
import {TrabajoService} from "../shared/trabajo.service";
import {Trabajo} from "../../../model/trabajo.model";
import {ActivatedRoute, NavigationEnd, NavigationStart, Router} from "@angular/router";
import {DetailTrabajoService} from "./detail-trabajo.service";
import {Subscription} from "rxjs";

@Component({
  selector: 'app-detail-trabajo',
  templateUrl: './detail-trabajo.component.html',
  styleUrls: ['./detail-trabajo.component.css'],
  providers: [ DetailTrabajoService ]
})
export class DetailTrabajoComponent implements OnInit, OnDestroy {

  trabajo?: Trabajo
  currentRoute: any
  routerSubscription = new Subscription()


  constructor(
    private trabajoService: TrabajoService,
    private detailService: DetailTrabajoService,
    private route: ActivatedRoute,
    private router: Router
  )
  {
    this.currentRoute = "";
    this.routerSubscription = this.router.events.subscribe((event) => {
      if (event instanceof NavigationStart) {
      }
      if (event instanceof NavigationEnd) {
        this.currentRoute = event.url.split('/').pop()
        this.getTrabajo()
      }
  });
  }

  ngOnInit(): void {
    this.getTrabajo();
  }


  getTrabajo() : void{
    const id = this.route.snapshot.paramMap.get('id')
    this.trabajoService.getById(Number(id))
      .subscribe(
        (data)=> {
          this.trabajo = data;
          this.enviarTrabajo(this.trabajo)
        }
      )
  }


  enviarTrabajo(trabajo:Trabajo){
    this.detailService.sendTrabajo(trabajo)
  }

  ngOnDestroy(): void {
    this.routerSubscription.unsubscribe();
  }

  /**
  announce() {
    if (this.trabajo){
      this.detailService.sendTrabajo(this.trabajo)
      console.log('Enviado!',this.trabajo)
    }

  }
   **/

}
