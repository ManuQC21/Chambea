import { NgModule } from '@angular/core';
import {FaIconLibrary, FontAwesomeModule} from "@fortawesome/angular-fontawesome";

import { library} from "@fortawesome/fontawesome-svg-core";
import { fas } from "@fortawesome/free-solid-svg-icons"
import { fab } from "@fortawesome/free-brands-svg-icons"
import { far } from "@fortawesome/free-regular-svg-icons"

import { faStackOverflow, faGithub, faMedium } from '@fortawesome/free-brands-svg-icons';



@NgModule({
  declarations: [],
  imports: [
    FontAwesomeModule
  ],
  exports: [
    FontAwesomeModule
  ]
})
export class IconsModule {

  constructor(library: FaIconLibrary) {
    library.addIcons(faGithub);
    library.addIconPacks(fas, fab, far)

  }


}
