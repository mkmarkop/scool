import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ChapterEditionComponent } from './chapter-edition.component';

describe('ChapterEditionComponent', () => {
  let component: ChapterEditionComponent;
  let fixture: ComponentFixture<ChapterEditionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ChapterEditionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ChapterEditionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
