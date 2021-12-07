import {Component, ViewEncapsulation} from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  //Maintain same background color across all componentes
  encapsulation: ViewEncapsulation.None
})
export class AppComponent {
  title = 'frontend';
}
