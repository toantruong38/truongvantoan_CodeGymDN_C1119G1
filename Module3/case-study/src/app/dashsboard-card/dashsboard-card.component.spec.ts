import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DashsboardCardComponent } from './dashsboard-card.component';

describe('DashsboardCardComponent', () => {
  let component: DashsboardCardComponent;
  let fixture: ComponentFixture<DashsboardCardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DashsboardCardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DashsboardCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
