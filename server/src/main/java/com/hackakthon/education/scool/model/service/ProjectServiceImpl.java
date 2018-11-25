package com.hackakthon.education.scool.model.service;

import com.hackakthon.education.scool.model.entity.Chapter;
import com.hackakthon.education.scool.model.entity.Project;
import com.hackakthon.education.scool.model.entity.Student;
import com.hackakthon.education.scool.model.repository.ProjectRepository;
import com.hackakthon.education.scool.model.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProjectServiceImpl {

    @Autowired
    private ProjectRepository projectRepository;

    @Transactional
    public Project getProjectById(Long id) {
        System.err.println("LOOK FOR ID "+id);
        return projectRepository.getOne(id);
    }


    @Transactional
    public List<Project> getAllProjects() {
        System.err.println("GIVE ME ALL PROJECTS");
        return projectRepository.findAll();
    }

    @Transactional
    public Long saveProject(Project project) {

        System.err.println("save");
        Project s = projectRepository.save(project);
        System.err.println(s);
        return s.getId();


    }
    @Transactional
    public void updateProject(Project project) {
        projectRepository.save(project);

    }

    @Transactional
    public void addChapterToProject(Long id, Chapter chapter) {
        Project p = projectRepository.getOne(id);
        p.getChapters().add(chapter);
        projectRepository.save(p);


    }
    @Transactional
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);

    }

    @Transactional
    public void deleteChapter(Long idProject, Chapter chapter) {
        Project p = projectRepository.getOne(idProject);
        p.getChapters().remove(chapter);
        projectRepository.save(p);


    }
}
