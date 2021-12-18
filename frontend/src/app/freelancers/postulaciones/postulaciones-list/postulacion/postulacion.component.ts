import {Component, Input, OnInit} from '@angular/core';
import {Postulacion} from "../../../../model/postulacion.model";

@Component({
  selector: 'app-postulacion',
  templateUrl: './postulacion.component.html',
  styleUrls: ['./postulacion.component.css']
})
export class PostulacionComponent implements OnInit {

  @Input() postulacion?: Postulacion

  constructor() { }

  ngOnInit(): void {
  }

}
