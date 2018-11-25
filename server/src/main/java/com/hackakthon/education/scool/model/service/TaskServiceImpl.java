package com.hackakthon.education.scool.model.service;

import com.hackakthon.education.scool.model.entity.Chapter;
import com.hackakthon.education.scool.model.entity.Game;
import com.hackakthon.education.scool.model.entity.Project;
import com.hackakthon.education.scool.model.entity.Task;
import com.hackakthon.education.scool.model.repository.ProjectRepository;
import com.hackakthon.education.scool.model.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaskServiceImpl {
    @Autowired
    private TaskRepository taskRepository;

    @Transactional
    public Task getTaskById(Long id) {
        System.err.println("LOOK FOR ID "+id);
        return taskRepository.getOne(id);
    }


    @Transactional
    public List<Task> getAllTasks() {
        System.err.println("GIVE ME ALL TASKS");
        return taskRepository.findAll();
    }

    @Transactional
    public Long saveTask(Task task) {
        System.err.println("save Task");
        Task t = taskRepository.save(task);
        System.err.println(t);
        return t.getId();


    }
    @Transactional
    public void updateTask(Task task) {
        taskRepository.save(task);
    }

    @Transactional
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);

    }

    @Transactional
    public void addPossibileAnswer(Long id, String possibleAnswer) {
        Task p = taskRepository.getOne(id);
        p.getPossibleAnswers().add(possibleAnswer);
        taskRepository.save(p);


    }

    @Transactional
    public void updateRightAnswer(Long id, String rightAnswer) {
        Task p = taskRepository.getOne(id);
        p.setRightAnswer(rightAnswer);
        taskRepository.save(p);


    }

}
