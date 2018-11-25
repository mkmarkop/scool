package com.hackakthon.education.scool.model.service;

import com.hackakthon.education.scool.model.entity.Game;
import com.hackakthon.education.scool.model.entity.Project;
import com.hackakthon.education.scool.model.entity.Task;
import com.hackakthon.education.scool.model.repository.GameRepository;
import com.hackakthon.education.scool.model.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameServiceImpl {
    @Autowired
    private GameRepository repository;

    @Transactional
    public Game getGameById(Long id) {
        System.err.println("LOOK FOR ID "+id);
        return repository.getOne(id);
    }


    @Transactional
    public List<Game> getAllGames() {
        System.err.println("GIVE ME ALL Games");
        return repository.findAll();
    }

    @Transactional
    public Long saveGame(Game game) {
        System.err.println("save Game");
        Game g = repository.save(game);
        System.err.println(g);
        return g.getId();


    }
    @Transactional
    public void updateGame(Game game) {
        repository.save(game);
    }

    @Transactional
    public void deleteGame(Long id) {
        repository.deleteById(id);

    }
    @Transactional
    public void addTaskToGame(Long id, Task task) {
        Game p = repository.getOne(id);
        System.err.println("I'm adding "+task +" to "+ p);
        p.getTasks().add(task);
        p= repository.save(p);

        System.err.println("AND NOW WE HAVE "+this.getAllGames());


    }

}
