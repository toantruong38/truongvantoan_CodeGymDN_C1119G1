import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TodoOnlineComponent } from './todo-online.component';

describe('TodoOnlineComponent', () => {
  let component: TodoOnlineComponent;
  let fixture: ComponentFixture<TodoOnlineComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TodoOnlineComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TodoOnlineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
