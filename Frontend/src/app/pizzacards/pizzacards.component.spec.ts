import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PizzacardsComponent } from './pizzacards.component';

describe('PizzacardsComponent', () => {
  let component: PizzacardsComponent;
  let fixture: ComponentFixture<PizzacardsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PizzacardsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PizzacardsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
