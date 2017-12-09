import {inject, TestBed} from '@angular/core/testing';

import {TawkGuardService} from './tawk-guard.service';

describe('TawkGuardService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [TawkGuardService]
    });
  });

  it('should be created', inject([TawkGuardService], (service: TawkGuardService) => {
    expect(service).toBeTruthy();
  }));
});
