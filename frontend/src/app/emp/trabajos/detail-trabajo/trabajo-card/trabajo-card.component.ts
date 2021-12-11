import {Component, Input, OnChanges, OnDestroy, OnInit} from '@angular/core';
import {Trabajo} from "../../../../model/trabajo.model";
import {DetailTrabajoService} from "../detail-trabajo.service";
import {Subscription} from "rxjs";
import {TrabajoService} from "../../shared/trabajo.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-trabajo-card',
  templateUrl: './trabajo-card.component.html',
  styleUrls: ['./trabajo-card.component.css']
})
export class TrabajoCardComponent implements OnInit, OnDestroy, OnChanges {

  @Input() trabajo?: Trabajo;
  subscription : Subscription

  constructor(
    private detailService: DetailTrabajoService,
    private trabajoService: TrabajoService,
    private router: Router
  ) {
    this.subscription = detailService.trabajo$.subscribe(
      data => {
        this.trabajo = data;
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

  ngOnChanges(){

  }

  ngOnInit(): void {
  }

  ngOnDestroy(){
    this.subscription.unsubscribe();
  }

}
