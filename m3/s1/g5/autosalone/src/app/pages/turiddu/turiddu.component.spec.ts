import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TuridduComponent } from './turiddu.component';

describe('TuridduComponent', () => {
  let component: TuridduComponent;
  let fixture: ComponentFixture<TuridduComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [TuridduComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(TuridduComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
