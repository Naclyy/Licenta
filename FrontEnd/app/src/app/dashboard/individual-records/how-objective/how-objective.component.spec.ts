import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HowObjectiveComponent } from './how-objective.component';

describe('HowObjectiveComponent', () => {
  let component: HowObjectiveComponent;
  let fixture: ComponentFixture<HowObjectiveComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HowObjectiveComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HowObjectiveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
