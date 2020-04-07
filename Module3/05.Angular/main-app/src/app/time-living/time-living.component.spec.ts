import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TimeLivingComponent } from './time-living.component';

describe('TimeLivingComponent', () => {
  let component: TimeLivingComponent;
  let fixture: ComponentFixture<TimeLivingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TimeLivingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TimeLivingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
