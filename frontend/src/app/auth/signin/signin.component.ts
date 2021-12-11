import { Component, OnInit } from '@angular/core';
import {Usuario} from "../shared/usuario.model";
import {AuthService} from "../shared/auth.service";
import {CreateUserRequest} from "../shared/user-creation.model";
import {UsuarioDto} from "../../model/usuarioDto";

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent implements OnInit {

  constructor(private authService: AuthService) { }

  ngOnInit(): void {
  }

  signin(usuario: CreateUserRequest) {
    this.authService.signIn(usuario)
      .subscribe(
        ( res ) => {
          console.log(res)
        }
      )
  }

  signup(usuario: CreateUserRequest){
    this.authService.signIn(usuario)
      .subscribe(
        (res) => {

          console.log(res)
          this.saveUserData(res.body, res.headers.get("Authorization"));

          let user = localStorage.getItem("user")
          let token = localStorage.getItem("token")

          if (typeof user === "string") {
            console.log(JSON.parse(user))
          }
          console.log(localStorage.getItem("token"))
        }
      )
  }

  saveUserData(usuarioDTO: UsuarioDto, token:string){
    localStorage.setItem("user", JSON.stringify(usuarioDTO))
    localStorage.setItem("token", token)
  }
}
