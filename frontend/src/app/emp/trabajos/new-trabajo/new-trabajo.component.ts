import { Component, OnInit } from '@angular/core';
import {TrabajoService} from "../shared/trabajo.service";
import {Trabajo} from "../../../model/trabajo.model";
import {Router} from "@angular/router";

@Component({
  selector: 'app-new-trabajo',
  templateUrl: './new-trabajo.component.html',
  styleUrls: ['./new-trabajo.component.css']
})
export class NewTrabajoComponent implements OnInit {

  constructor(
    private trabajoService: TrabajoService,
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  createTrabajo(trabajo:Trabajo){
    this.trabajoService.createTrabajo(trabajo).subscribe(
      response => {
        //console.log(response)
        this.router.navigate(['/emp/home'])
      }
    )
  }

}
