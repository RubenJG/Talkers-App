import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';

import {AppComponent} from './app.component';
import {TawkListComponent} from './tawks/tawk-list.component';
import {ConvertToSpacesPipe} from './shared/convert-to-spaces.pipe';
import {StarComponent} from './shared/star.component';
import {HttpClientModule} from '@angular/common/http';
import {TawkDetailComponent} from './tawks/tawk-detail.component';
import {WelcomeComponent} from './home/welcome.component';
import {RouterModule} from '@angular/router';
import {TawkGuardService} from './tawks/tawk-guard.service';

@NgModule({
  //internal modules
  declarations: [
    AppComponent,
    TawkListComponent,
    ConvertToSpacesPipe,
    StarComponent,
    TawkDetailComponent,
    WelcomeComponent
  ],
  //external modules
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot([
        {path: 'tawkList', component: TawkListComponent},
        {
          path: 'tawks/:id',
          canActivate: [TawkGuardService],
          component: TawkDetailComponent
        },
        {path: 'welcome', component: TawkListComponent},
        {path: '', redirectTo: 'tawkList', pathMatch: 'full'},
        {path: '**', redirectTo: 'tawkList', pathMatch: 'full'}],
      {useHash: true})
  ],
  providers: [TawkGuardService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
