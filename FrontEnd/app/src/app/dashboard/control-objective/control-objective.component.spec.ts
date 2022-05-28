import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ControlObjectiveComponent } from './control-objective.component';

describe('ControlObjectiveComponent', () => {
  let component: ControlObjectiveComponent;
  let fixture: ComponentFixture<ControlObjectiveComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ControlObjectiveComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ControlObjectiveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
