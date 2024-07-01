import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TerminOverviewComponent } from './termin-overview.component';

describe('TerminOverviewComponent', () => {
  let component: TerminOverviewComponent;
  let fixture: ComponentFixture<TerminOverviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TerminOverviewComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TerminOverviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
