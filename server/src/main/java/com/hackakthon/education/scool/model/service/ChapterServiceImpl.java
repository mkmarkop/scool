package com.hackakthon.education.scool.model.service;

import com.hackakthon.education.scool.model.entity.Chapter;
import com.hackakthon.education.scool.model.entity.Game;
import com.hackakthon.education.scool.model.entity.Task;
import com.hackakthon.education.scool.model.repository.ChapterRepository;
import com.hackakthon.education.scool.model.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ChapterServiceImpl {

    @Autowired
    private ChapterRepository chapterRepository;

    @Transactional
    public Chapter getChapterById(Long id) {
        System.err.println("LOOK FOR ID "+id);
        return chapterRepository.getOne(id);
    }


    @Transactional
    public List<Chapter> getAllChapters() {
        System.err.println("GIVE ME ALL chapters");
        return chapterRepository.findAll();
    }

    @Transactional
    public Long saveChapter(Chapter chapter) {
        System.err.println("save chapter");
        Chapter c = chapterRepository.save(chapter);
        System.err.println(c);
        return c.getId();


    }
    @Transactional
    public void updateChaper(Chapter chapter) {
        chapterRepository.save(chapter);
    }

    @Transactional
    public void deleteChapter(Long id) {
        chapterRepository.deleteById(id);

    }

    @Transactional
    public void addGameToChapter(Long id, Game game) {
        Chapter p = chapterRepository.getOne(id);
        p.getGames().add(game);
        chapterRepository.save(p);


    }

}
