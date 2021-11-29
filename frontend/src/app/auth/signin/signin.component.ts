import { Component, OnInit } from '@angular/core';
import {Usuario} from "../shared/usuario.model";
import {AuthService} from "../shared/auth.service";

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent implements OnInit {

  constructor(private authService: AuthService) { }

  ngOnInit(): void {
  }

  signin(usuario: Usuario) {
    this.authService.signIn(usuario)
      .subscribe(
        ( res ) => {
          console.log(res)
        }
      )
  }
}
