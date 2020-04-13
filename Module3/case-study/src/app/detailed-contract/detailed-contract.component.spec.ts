import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailedContractComponent } from './detailed-contract.component';

describe('DetailedContractComponent', () => {
  let component: DetailedContractComponent;
  let fixture: ComponentFixture<DetailedContractComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetailedContractComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailedContractComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
