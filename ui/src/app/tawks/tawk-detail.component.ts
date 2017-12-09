import {Component, OnInit} from '@angular/core';

import {ITawk} from './tawk';
import {ActivatedRoute, Router} from '@angular/router';
import {TawkService} from './tawk.service';

@Component({
  selector: 'pm-tawk-detail',
  templateUrl: './tawk-detail.component.html',
  styleUrls: ['./tawk-detail.component.css']
})
export class TawkDetailComponent implements OnInit {

  pageTitle: string = 'Tawk Details';
  tawk: ITawk;
  errorMessage: string;

  constructor(private _route: ActivatedRoute, private _router: Router, private _tawkService: TawkService) {
  }

  ngOnInit(): void {
    let id = +this._route.snapshot.paramMap.get('id');

    this._tawkService.getTawk(id)
      .subscribe(tawk => {
          this.tawk = tawk;
        },
        error => this.errorMessage = <any>error);

  }

  onBack(): void {
    this._router.navigate(['/tawks']);
  }

}
