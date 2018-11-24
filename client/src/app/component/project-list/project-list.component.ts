import { Component, OnInit } from '@angular/core';
import {ProjectService} from '../../service/project.service';
import {Project} from '../../domain/project';

@Component({
  selector: 'app-project-list',
  templateUrl: './project-list.component.html',
  styleUrls: ['./project-list.component.css']
})
export class ProjectListComponent implements OnInit {

  private projects: Project[];

  constructor(private projectService: ProjectService) { }

  ngOnInit() {
    this.projectService.getProjects().subscribe(
      data => {
        this.projects = data;
      }
    );
  }

}
