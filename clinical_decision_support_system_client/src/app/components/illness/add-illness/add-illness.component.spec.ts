import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddIllnessComponent } from './add-illness.component';

describe('AddIllnessComponent', () => {
  let component: AddIllnessComponent;
  let fixture: ComponentFixture<AddIllnessComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddIllnessComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddIllnessComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
