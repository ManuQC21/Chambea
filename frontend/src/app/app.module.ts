import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {HttpClientModule} from "@angular/common/http";
import { HeaderComponent } from './shared/header/header.component';
import { LayoutComponent } from './shared/layout/layout.component';
import {MaterialModule} from "./material/material.module";
import { MenuComponentComponent } from './shared/menu-component/menu-component.component';
import {FlexLayoutModule} from "@angular/flex-layout";
import { FooterComponent } from './shared/footer/footer.component';
import {IconsModule} from "./icons/icons.module";




@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    LayoutComponent,
    MenuComponentComponent,
    FooterComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    MaterialModule,
    FlexLayoutModule,
    IconsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
