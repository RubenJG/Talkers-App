import {Component} from '@angular/core';
import {TawkService} from './tawks/tawk.service';

@Component({
  selector: 'pm-root',
  template: `
      <div>
      <nav class='navbar navbar-default'>
      <div class='container-fluid'>
          <a class='navbar-brand'>{{pageTitle}}</a>
          <ul class='nav navbar-nav'>
              <li><a [routerLink]="['/products']">Home</a></li>
          </ul>
          <ul class="nav navbar-nav pull-right">
          <li><a [routerLink]="['/products']">Hello, Gaudy!</a></li>          
          <li><a [routerLink]="['/products']">Logout</a></li>
          </ul>
      </div>
  </nav>
      <div class='container-fluid'>
          <router-outlet></router-outlet>
      </div>
    </div>
      `,
  providers: [TawkService]
})

export class AppComponent {
  pageTitle: string = 'Tawkers';
}
