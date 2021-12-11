import { Component, OnInit } from '@angular/core';
import {AuthService} from "../shared/auth.service";
import {UsuarioDto} from "../../model/usuarioDto";
import {HttpResponse} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(
    public authService: AuthService,
    private router: Router
  ) { }

  ngOnInit(): void {
  }


  log(creds: any){
    console.log(creds)
    this.authService.log(creds)
      .subscribe(
        (res) => {

          this.saveUserData(res.body, res.headers.get("Authorization"));
          localStorage.setItem("rol", 'empleador')

          let user = localStorage.getItem("user")
          let token = localStorage.getItem("token")

          if (typeof user === "string") {
            console.log(JSON.parse(user))
          }
          console.log(localStorage.getItem("token"))

          this.router.navigate(['emp/home'])
        }
      )
  }

  saveUserData(usuarioDTO: UsuarioDto, token:string){
    localStorage.setItem("user", JSON.stringify(usuarioDTO))
    localStorage.setItem("token", token)
  }

}
