import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, NavigationEnd, NavigationError, NavigationStart, ParamMap, Router} from "@angular/router";
import {Observable} from "rxjs";
import {map} from "rxjs/operators";

@Component({
  selector: 'app-breadcrumb',
  templateUrl: './breadcrumb.component.html',
  styleUrls: ['./breadcrumb.component.css']
})
export class BreadcrumbComponent implements OnInit {

  ubicacion: any
  currentRoute: string

  constructor(
    private activeRouter: ActivatedRoute,
    private router: Router
  ) {
    this.ubicacion = activeRouter.snapshot.children[0].url.toString();

    this.activeRouter.firstChild?.url.subscribe(
      url => {
        this.ubicacion= url
      }
    )

    console.log(activeRouter.snapshot.children[0].url.toString())


    this.currentRoute = "";
    this.router.events.subscribe((event) => {
      if (event instanceof NavigationStart) {
        // Show progress spinner or progress bar
        console.log('Route change detected');
      }

      if (event instanceof NavigationEnd) {
        // Hide progress spinner or progress bar
        this.currentRoute = event.url;
        this.ubicacion = event.url.split('/').pop()
        //console.log(event);
      }

      if (event instanceof NavigationError) {
        // Hide progress spinner or progress bar

        // Present error to user
        //console.log(event.error);
      }


    });

  }

  getUbicacion(){
  }

  ngOnInit(): void {
    // @ts-ignore


  }

}
