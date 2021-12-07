import { Component, OnInit } from '@angular/core';
import {MatMenu} from "@angular/material/menu";
import {UsuarioDto} from "../../model/usuarioDto";

@Component({
  selector: 'app-layout',
  templateUrl: './layout.component.html',
  styleUrls: ['./layout.component.css']
})
export class LayoutComponent implements OnInit {

  currentUser : UsuarioDto

  constructor() {
    this.currentUser = JSON.parse(<string>localStorage.getItem("user"));

  }

  ngOnInit(): void {
    MatMenu
  }

}
