package com.hackakthon.education.scool.controller;

import com.hackakthon.education.scool.model.entity.Project;
import com.hackakthon.education.scool.model.entity.Teacher;
import com.hackakthon.education.scool.model.service.ProjectServiceImpl;
import com.hackakthon.education.scool.model.service.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class TeacherController {
    @Autowired
    TeacherServiceImpl teacherService;

    @Autowired
    ProjectServiceImpl projectService;



    @GetMapping("/teachers")
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<Teacher> getTeachers() {
        return teacherService.getAllTeacher();
    }

    @GetMapping("/teachers/{id}")
    public ResponseEntity getTeacher(@PathVariable("id") Long id) {

        Teacher teacher = teacherService.getTeacherById(id);
        if (teacher == null) {
            return new ResponseEntity("No teacher found for ID " + id, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(teacher, HttpStatus.OK);
    }

    @PostMapping(value = "/teacher")
    public ResponseEntity createTeacher(@RequestBody Teacher teacher) {

        teacherService.saveTeacher(teacher);

        return new ResponseEntity(teacher, HttpStatus.OK);
    }

    @DeleteMapping("/teachers/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Long id) {
        if (null == teacherService.getTeacherById(id)) {
            return new ResponseEntity("No teacher found for ID " + id, HttpStatus.NOT_FOUND);
        }

        teacherService.deleteTeacher(id);
        return new ResponseEntity(id, HttpStatus.OK);

    }

    @PutMapping("/teachers/{id}")
    public ResponseEntity updateTeacher(@PathVariable Long id, @RequestBody Teacher teacher) {

        if (null == teacherService.getTeacherById(id)) {
            return new ResponseEntity("No teacher found for ID " + id, HttpStatus.NOT_FOUND);
        }

        teacherService.updateTeacher(teacher);
        return new ResponseEntity(teacher, HttpStatus.OK);
    }



    @RequestMapping(value = "/addProjectToTeacher", method = RequestMethod.POST)
    void addProjectToTeacher(Long idProject, Long idTeacher) {
        Project projectById = projectService.getProjectById(idProject);
        teacherService.addProjectToTeacher(idTeacher, projectById);

    }
}