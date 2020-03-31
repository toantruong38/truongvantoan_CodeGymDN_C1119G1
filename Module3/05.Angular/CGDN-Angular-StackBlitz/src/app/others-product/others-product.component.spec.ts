import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OthersProductComponent } from './others-product.component';

describe('OthersProductComponent', () => {
  let component: OthersProductComponent;
  let fixture: ComponentFixture<OthersProductComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OthersProductComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OthersProductComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
