package com.hackakthon.education.scool.model.service;

import com.hackakthon.education.scool.model.entity.Chapter;
import com.hackakthon.education.scool.model.entity.Game;
import com.hackakthon.education.scool.model.entity.Project;
import com.hackakthon.education.scool.model.entity.Teacher;
import com.hackakthon.education.scool.model.repository.ChapterRepository;
import com.hackakthon.education.scool.model.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TeacherServiceImpl {
    @Autowired
    private TeacherRepository teacherRepository;

    @Transactional
    public Teacher getTeacherById(Long id) {
        System.err.println("LOOK FOR ID "+id);
        return teacherRepository.getOne(id);
    }


    @Transactional
    public List<Teacher> getAllTeacher() {
        System.err.println("GIVE ME ALL teacher");
        return teacherRepository.findAll();
    }

    @Transactional
    public Long saveTeacher(Teacher teacher) {
        System.err.println("save teacher");
        Teacher c = teacherRepository.save(teacher);
        System.err.println(c);
        return c.getId();


    }
    @Transactional
    public void updateTeacher(Teacher teacher)
    {
        teacherRepository.save(teacher);
    }

    @Transactional
    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);

    }

    @Transactional
    public void addProjectToTeacher(Long id, Project project) {
        Teacher p = teacherRepository.getOne(id);
        p.getProjects().add(project);
        teacherRepository.save(p);


    }
}
