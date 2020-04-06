import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NewServiceFormComponent } from './new-service-form.component';

describe('NewServiceFormComponent', () => {
  let component: NewServiceFormComponent;
  let fixture: ComponentFixture<NewServiceFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NewServiceFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewServiceFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
