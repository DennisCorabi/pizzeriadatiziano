import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SidenavcartComponent } from './sidenavcart.component';

describe('SidenavcartComponent', () => {
  let component: SidenavcartComponent;
  let fixture: ComponentFixture<SidenavcartComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SidenavcartComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SidenavcartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
