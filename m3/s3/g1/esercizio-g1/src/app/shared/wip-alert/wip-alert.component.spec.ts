import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WipAlertComponent } from './wip-alert.component';

describe('WipAlertComponent', () => {
  let component: WipAlertComponent;
  let fixture: ComponentFixture<WipAlertComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [WipAlertComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(WipAlertComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
