import {Component, Input, OnChanges, OnDestroy, OnInit} from '@angular/core';
import {Trabajo} from "../../../../model/trabajo.model";
import {DetailTrabajoService} from "../detail-trabajo.service";
import {Subscription} from "rxjs";

@Component({
  selector: 'app-trabajo-card',
  templateUrl: './trabajo-card.component.html',
  styleUrls: ['./trabajo-card.component.css']
})
export class TrabajoCardComponent implements OnInit, OnDestroy, OnChanges {

  @Input() trabajo?: Trabajo;
  subscription : Subscription

  constructor(
    private detailService: DetailTrabajoService
  ) {
    this.subscription = detailService.trabajo$.subscribe(
      data => {
        this.trabajo = data;
        console.log('Llego el trabajo')
      }
    )
  }

  ngOnChanges(){

  }

  ngOnInit(): void {
  }

  ngOnDestroy(){
    this.subscription.unsubscribe();
  }

}
