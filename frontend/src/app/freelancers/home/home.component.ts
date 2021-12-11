import { Component, OnInit } from '@angular/core';
import {UsuarioDto} from "../../model/usuarioDto";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  currentUser: UsuarioDto

  constructor() {
    this.currentUser = JSON.parse(<string>localStorage.getItem("user"));
  }

  ngOnInit(): void {
  }

}
