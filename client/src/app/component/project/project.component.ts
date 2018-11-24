import { Component, OnInit } from '@angular/core';
import {Location} from '@angular/common';
import {Project} from '../../domain/project';
import {ActivatedRoute} from '@angular/router';
import {ProjectService} from '../../service/project.service';

@Component({
  selector: 'app-project',
  templateUrl: './project.component.html',
  styleUrls: ['./project.component.css']
})
export class ProjectComponent implements OnInit {

  private project: Project;

  constructor(
    private route: ActivatedRoute,
    private projectService: ProjectService,
    private location: Location
  ) { }

  ngOnInit() {
    const id = +this.route.snapshot.paramMap.get('id');
    this.projectService.getProject(id).subscribe(
      project => {
        this.project = project;
      }
    );
  }

}
