import {Component, Input, OnInit} from '@angular/core';
import {UsuarioDto} from "../../model/usuarioDto";
import {Router} from "@angular/router";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  @Input() currentUser? : UsuarioDto
  actualRol? : string

  constructor(
    private router: Router
  ) {
    this.actualRol = <string>localStorage.getItem("rol")
    console.log(this.actualRol)

  }

  ngOnInit(): void {
  }

  logout(){
    this.router.navigate(['auth/login'])
  }

  changeRol(rol: string){
    localStorage.setItem("rol", rol)
  }
}
