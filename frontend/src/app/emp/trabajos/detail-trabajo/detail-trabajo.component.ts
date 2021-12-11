import { Component, OnInit } from '@angular/core';
import {TrabajoService} from "../shared/trabajo.service";
import {Trabajo} from "../../../model/trabajo.model";
import {ActivatedRoute, NavigationEnd, NavigationStart, Router} from "@angular/router";
import {DetailTrabajoService} from "./detail-trabajo.service";

@Component({
  selector: 'app-detail-trabajo',
  templateUrl: './detail-trabajo.component.html',
  styleUrls: ['./detail-trabajo.component.css'],
  providers: [ DetailTrabajoService ]
})
export class DetailTrabajoComponent implements OnInit {

  trabajo?: Trabajo
  currentRoute: any


  constructor(
    private trabajoService: TrabajoService,
    private detailService: DetailTrabajoService,
    private route: ActivatedRoute,
    private router: Router
  )
  {
    this.currentRoute = "";
    this.router.events.subscribe((event) => {
      if (event instanceof NavigationStart) {
      }
      if (event instanceof NavigationEnd) {
        this.currentRoute = event.url.split('/').pop()
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

  /**
  announce() {
    if (this.trabajo){
      this.detailService.sendTrabajo(this.trabajo)
      console.log('Enviado!',this.trabajo)
    }

  }
   **/

}
