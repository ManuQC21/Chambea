import {Component, Input, OnInit} from '@angular/core';
import {Trabajo} from "../../../../model/trabajo.model";

@Component({
  selector: 'app-trabajo',
  templateUrl: './trabajo.component.html',
  styleUrls: ['./trabajo.component.css']
})
export class TrabajoComponent implements OnInit {

  @Input() trabajo?: Trabajo

  constructor() { }

  ngOnInit(): void {
  }

}
