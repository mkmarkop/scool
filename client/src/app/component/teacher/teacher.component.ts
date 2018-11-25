import { Component, OnInit } from '@angular/core';
import {ProjectService} from '../../service/project.service';
import {Project} from "../../domain/project";
import {Chapter} from "../../domain/chapter";

@Component({
  selector: 'app-teacher',
  templateUrl: './teacher.component.html',
  styleUrls: ['./teacher.component.css']
})
export class TeacherComponent implements OnInit {

  private projects: Project[];

  constructor(private projectService: ProjectService) { }

  ngOnInit() {
    this.projectService.getProjects().subscribe(
      data => {
        this.projects = data;
      }
    );
  }

  selectedProject: Project;
  onSelect(project: Project): void {
    this.selectedProject = project;
  }
  delete(chapter: Chapter): void {
    this.selectedProject.chapters = this.selectedProject.chapters.filter(h => h !== chapter);
  }
}
