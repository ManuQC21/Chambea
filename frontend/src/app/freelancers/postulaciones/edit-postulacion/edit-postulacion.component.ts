import {Component, OnDestroy, OnInit} from '@angular/core';
import {DetailPostulacionService} from "../detail-postulacion/detail-postulacion.service";
import {Router} from "@angular/router";
import {PostulacionService} from "../shared/postulacion.service";
import {Postulacion} from "../../../model/postulacion.model";
import {Subscription} from "rxjs";

@Component({
  selector: 'app-edit-postulacion',
  templateUrl: './edit-postulacion.component.html',
  styleUrls: ['./edit-postulacion.component.css']
})
export class EditPostulacionComponent implements OnInit, OnDestroy {

  subscription: Subscription
  postulacion?: Postulacion

  constructor(
    private detailService: DetailPostulacionService,
    private router: Router,
    private postulacionService: PostulacionService
  ) {
    this.subscription = this.detailService.postulacion$.subscribe(
      data => {
        this.postulacion = data
      }
    )
  }

  ngOnInit(): void {
  }

  updatePostulacion(postulacion: Postulacion){
    this.postulacionService.update(postulacion).subscribe(
      (data) => {
        this.router.navigate([`/freelancers/home`])
      }
    )
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe()
  }

}
