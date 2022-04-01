import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WhatObjectiveComponent } from './what-objective.component';

describe('WhatObjectiveComponent', () => {
  let component: WhatObjectiveComponent;
  let fixture: ComponentFixture<WhatObjectiveComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WhatObjectiveComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(WhatObjectiveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
