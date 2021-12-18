import { Component, OnInit } from '@angular/core';
import {Postulacion} from "../../../model/postulacion.model";
import {UsuarioDto} from "../../../model/usuarioDto";
import {PostulacionService} from "../shared/postulacion.service";

@Component({
  selector: 'app-postulaciones-list',
  templateUrl: './postulaciones-list.component.html',
  styleUrls: ['./postulaciones-list.component.css']
})
export class PostulacionesListComponent implements OnInit {

  postulaciones?: Postulacion[]
  currentUser?: UsuarioDto


  constructor(
    private postulacionService: PostulacionService
  ) {
    this.currentUser = JSON.parse(<string>localStorage.getItem("user"));

    this.getPostulaciones()
  }

  ngOnInit(): void {
  }

  getPostulaciones(){
    const id = this.currentUser?.idFreelancer
    if (id) {
      this.postulacionService.getByFreelancer(id).subscribe(
        data => {
          this.postulaciones = data;
        }
      )
    }
  }

}
