import { Component, OnInit } from '@angular/core';
import {Chapter} from "../../domain/chapter";

import {ProjectService} from '../../service/project.service';

@Component({
  selector: 'app-chapter-edition',
  templateUrl: './chapter-edition.component.html',
  styleUrls: ['./chapter-edition.component.css']
})
export class ChapterEditionComponent implements OnInit {

  chapter : Chapter;
  constructor(private projectService: ProjectService) { }

  ngOnInit() {
    this.projectService.getProject(1).subscribe(proj => this.chapter = proj.chapters[0]);
  }

}
