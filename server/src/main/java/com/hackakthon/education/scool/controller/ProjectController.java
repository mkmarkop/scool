package com.hackakthon.education.scool.controller;

import com.hackakthon.education.scool.model.entity.Chapter;
import com.hackakthon.education.scool.model.entity.Project;
import com.hackakthon.education.scool.model.service.ChapterServiceImpl;
import com.hackakthon.education.scool.model.service.ProjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
public class ProjectController {
    @Autowired
    ProjectServiceImpl projectService;

    @Autowired
    ChapterServiceImpl chapterService;



    @GetMapping("/projects")
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<Project> getProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("/projects/{id}")
    public ResponseEntity getProject(@PathVariable("id") Long id) {

        Project project = projectService.getProjectById(id);
        if (project == null) {
            return new ResponseEntity("No Project found for ID " + id, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(project, HttpStatus.OK);
    }

    @PostMapping(value = "/projects")
    public ResponseEntity createProject(@RequestBody Project project) {

        projectService.saveProject(project);

        return new ResponseEntity(project, HttpStatus.OK);
    }

    @DeleteMapping("/projects/{id}")
    public ResponseEntity deleteProject(@PathVariable Long id) {
        if (null == projectService.getProjectById(id)) {
            return new ResponseEntity("No Project found for ID " + id, HttpStatus.NOT_FOUND);
        }

        projectService.deleteProject(id);
        return new ResponseEntity(id, HttpStatus.OK);

    }

    @PutMapping("/projects/{id}")
    public ResponseEntity updateProject(@PathVariable Long id, @RequestBody Project project) {

        if (null == projectService.getProjectById(id)) {
            return new ResponseEntity("No Project found for ID " + id, HttpStatus.NOT_FOUND);
        }

        projectService.updateProject(project);
        return new ResponseEntity(project, HttpStatus.OK);
    }



    @RequestMapping(value = "/addChapterToProject", method = RequestMethod.POST)
    void addChapterToProject(Long idChapter, Long idProject) {
        Chapter chapterById = chapterService.getChapterById(idChapter);
        projectService.addChapterToProject(idProject, chapterById);

    }
}
