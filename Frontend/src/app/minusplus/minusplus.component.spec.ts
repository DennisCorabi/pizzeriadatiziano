import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MinusplusComponent } from './minusplus.component';

describe('MinusplusComponent', () => {
  let component: MinusplusComponent;
  let fixture: ComponentFixture<MinusplusComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MinusplusComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MinusplusComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
