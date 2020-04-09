import { TestBed } from '@angular/core/testing';

import { TodoOnlineService } from './todo-online.service';

describe('TodoOnlineService', () => {
  let service: TodoOnlineService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TodoOnlineService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
