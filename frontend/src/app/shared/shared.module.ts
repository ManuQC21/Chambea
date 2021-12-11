import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import {FlexLayoutModule} from "@angular/flex-layout";
import {MaterialModule} from "../material/material.module";

import {HeaderComponent} from "./header/header.component";
import {FooterComponent} from "./footer/footer.component";
import {IconsModule} from "../icons/icons.module";
import {RouterModule} from "@angular/router";


@NgModule({
  declarations: [
    HeaderComponent,
    FooterComponent
  ],
    imports: [
        CommonModule,
        FlexLayoutModule,
        MaterialModule,
        IconsModule,
        RouterModule
    ],
  exports: [
    HeaderComponent,
    FooterComponent
  ]
})
export class SharedModule { }
