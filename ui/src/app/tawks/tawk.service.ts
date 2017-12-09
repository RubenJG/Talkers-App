import {Injectable} from '@angular/core';
import {ITawk} from './tawk';
import {HttpClient, HttpErrorResponse} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/do';
import 'rxjs/add/observable/throw';

@Injectable()
export class TawkService {
  private _tawkUrl = './api/tawks/tawks.json';
  private _tawkUrl2 = './api/tawks/tawk.json';


  constructor(private _http: HttpClient) {
  }

  getTawks(): Observable<ITawk[]> {
    return this._http.get<ITawk[]>(this._tawkUrl)
      .do(data => console.log('All: ' + JSON.stringify(data)))
      .catch(this.handleError);
  }

  getTawk(id: number): Observable<ITawk> {
    return this._http.get<ITawk[]>(this._tawkUrl2)
      .do(data => console.log('All: ' + JSON.stringify(data)))
      .catch(this.handleError);
  }

  private handleError(err: HttpErrorResponse) {
    console.log(err.message);
    return Observable.throw(err.message);
  }
}
