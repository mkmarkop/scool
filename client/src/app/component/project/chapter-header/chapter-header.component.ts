import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-chapter-header',
  templateUrl: './chapter-header.component.html',
  styleUrls: ['./chapter-header.component.css']
})
export class ChapterHeaderComponent implements OnInit {

  @Input() title: string;
  @Input() number: number;

  constructor() {}

  ngOnInit() {
  }

}
