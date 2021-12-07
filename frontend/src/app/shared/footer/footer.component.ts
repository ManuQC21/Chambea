import { Component, OnInit } from '@angular/core';
import {findIconDefinition, icon} from "@fortawesome/fontawesome-svg-core";

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent implements OnInit {

  constructor() {
    const facebook = findIconDefinition({prefix: 'fab', iconName: 'facebook'});
    const f = icon(facebook);
  }

  ngOnInit(): void {
  }

}
