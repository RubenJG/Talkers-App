import {Component, OnInit} from '@angular/core';
import {ITawk} from './tawk';
import {TawkService} from './tawk.service';

@Component({
  selector: 'pm-tawks',
  templateUrl: './tawk-list.component.html',
  styleUrls: ['./tawk-list.component.css']
})

export class TawkListComponent
  implements OnInit {
  pageTitle: string = 'Tawks';
  errorMessage: string;

  tawks: ITawk[] = [
    {
      'tawkId': 1,
      'tawkName': 'Leaf Rake',
      'date': 'March 19, 2016',
      'description': 'Leaf rake with 48-inch wooden handle.'
    }
  ];
  //any[] is used when you don't know what it is or you don't care

  //lifecycle hook
  ngOnInit(): void {
    this._tawkService.getTawks()
      .subscribe(tawks => {
          this.tawks = tawks;
        },
        error => this.errorMessage = <any>error);

  }

  constructor(private _tawkService: TawkService) {
  }

}
