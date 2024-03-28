import { TestBed } from '@angular/core/testing';

import { HttpClassInterceptor } from './http-class.interceptor';

describe('HttpClassInterceptor', () => {
  beforeEach(() => TestBed.configureTestingModule({
    providers: [
      HttpClassInterceptor
      ]
  }));

  it('should be created', () => {
    const interceptor: HttpClassInterceptor = TestBed.inject(HttpClassInterceptor);
    expect(interceptor).toBeTruthy();
  });
});
