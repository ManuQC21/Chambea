import { Component, OnInit } from '@angular/core';
import {TrabajoService} from "../../../emp/trabajos/shared/trabajo.service";
import {Trabajo} from "../../../model/trabajo.model";
import {ActivatedRoute, Router} from "@angular/router";
import {Postulacion} from "../../../model/postulacion.model";
import {PostulacionService} from "../shared/postulacion.service";

@Component({
  selector: 'app-new-postulacion',
  templateUrl: './new-postulacion.component.html',
  styleUrls: ['./new-postulacion.component.css']
})
export class NewPostulacionComponent implements OnInit {

  trabajo?: Trabajo

  constructor(
    private trabajoService: TrabajoService,
    private route: ActivatedRoute,
    private postulacionService: PostulacionService,
    private router: Router
  ) {
    this.getTrabajo();
  }

  ngOnInit(): void {
  }

  getTrabajo() {
    let idTrabajo = this.route.snapshot.paramMap.get('id')
    this.trabajoService.getById(Number(idTrabajo)).subscribe(
      data => {
        this.trabajo = data;
      }
    )
  }

  createPostulacion(postulacion: Postulacion){
    this.postulacionService.createPostulacion(postulacion).subscribe(
      () => this.router.navigate(['/freelancers/home'])
    )
  }

}
