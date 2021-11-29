import { Component, OnInit } from '@angular/core';
import {AuthService} from "../shared/auth.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(public authService: AuthService) { }

  ngOnInit(): void {
  }

  login(creds: any){
    console.log(creds)
    this.authService.logIn(creds.usuario, creds.password)
      .subscribe(
        (response) => {
          console.log(response)
        }
      )
  }

}
