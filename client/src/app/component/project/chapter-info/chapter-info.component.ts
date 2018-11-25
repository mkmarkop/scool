import {Component, Input, OnInit} from '@angular/core';
import {Chapter} from '../../../domain/chapter';

@Component({
  selector: 'app-chapter-info',
  templateUrl: './chapter-info.component.html',
  styleUrls: ['./chapter-info.component.css']
})
export class ChapterInfoComponent implements OnInit {

  @Input() chapter: Chapter;
  @Input() number: number;

  constructor() { }

  ngOnInit() {
  }

}
