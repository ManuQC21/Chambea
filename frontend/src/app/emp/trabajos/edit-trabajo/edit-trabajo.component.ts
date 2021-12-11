import {Component, OnDestroy, OnInit} from '@angular/core';
import {TrabajoService} from "../shared/trabajo.service";
import {Trabajo} from "../../../model/trabajo.model";
import {DetailTrabajoService} from "../detail-trabajo/detail-trabajo.service";
import {Subscription} from "rxjs";
import {Route, Router} from "@angular/router";

@Component({
  selector: 'app-edit-trabajo',
  templateUrl: './edit-trabajo.component.html',
  styleUrls: ['./edit-trabajo.component.css']
})
export class EditTrabajoComponent implements OnInit, OnDestroy {

  trabajo?: Trabajo
  subscription: Subscription

  constructor(
    private trabajoService: TrabajoService,
    private detailService: DetailTrabajoService,
    private router: Router
  ) {
    this.subscription = this.detailService.trabajo$.subscribe(
      data =>{
        this.trabajo = data
        //console.log(data)
      }
    )
  }

  ngOnInit(): void {
  }

  updateTrabajo(trabajo: Trabajo){
    trabajo.idTrabajo = this.trabajo?.idTrabajo
    this.trabajoService.update(trabajo).subscribe(
      data => {
        trabajo = data;
        this.router.navigate([`emp/trabajo/${data.idTrabajo}/detail`])
      }
    )
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }
}
