import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BugPanelComponent } from './bug-panel.component';

describe('BugPanelComponent', () => {
  let component: BugPanelComponent;
  let fixture: ComponentFixture<BugPanelComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BugPanelComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BugPanelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
