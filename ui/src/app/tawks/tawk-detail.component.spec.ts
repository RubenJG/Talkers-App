import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {TawkDetailComponent} from './tawk-detail.component';

describe('ProductDetailComponent', () => {
  let component: TawkDetailComponent;
  let fixture: ComponentFixture<TawkDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [TawkDetailComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TawkDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
