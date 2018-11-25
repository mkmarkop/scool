package com.hackakthon.education.scool.controller;

import com.hackakthon.education.scool.model.entity.Chapter;
import com.hackakthon.education.scool.model.entity.Student;
import com.hackakthon.education.scool.model.service.ChapterServiceImpl;
import com.hackakthon.education.scool.model.service.ProjectServiceImpl;
import com.hackakthon.education.scool.model.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class ChapterController {

    @Autowired
    ProjectServiceImpl projectService;

    @Autowired
    ChapterServiceImpl chapterService;

    @RequestMapping(value = "/deleteChapter", method = RequestMethod.POST)
    void deleteChapter(Long idProject, Long idChapter) {

        Chapter chapter = chapterService.getChapterById(idChapter);
        projectService.deleteChapter(idProject, chapter);
        chapterService.deleteChapter(chapter.getId());


    }



    @GetMapping("/chapters")
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<Chapter> getChapters() {
        return chapterService.getAllChapters();
    }

    @GetMapping("/chapters/{id}")
    public ResponseEntity getChapters(@PathVariable("id") Long id) {

        Chapter chapter = chapterService.getChapterById(id);
        if (chapter == null) {
            return new ResponseEntity("No chapter found for ID " + id, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(chapter, HttpStatus.OK);
    }

    @PostMapping(value = "/chapters")
    public ResponseEntity createChapter(@RequestBody Chapter chapter) {

        chapterService.saveChapter(chapter);

        return new ResponseEntity(chapter, HttpStatus.OK);
    }

    @DeleteMapping("/chapters/{id}")
    public ResponseEntity deleteChapter(@PathVariable Long id) {
        if (null == chapterService.getChapterById(id)) {
            return new ResponseEntity("No Chapter found for ID " + id, HttpStatus.NOT_FOUND);
        }

        chapterService.deleteChapter(id);
        return new ResponseEntity(id, HttpStatus.OK);

    }

    @PutMapping("/chapters/{id}")
    public ResponseEntity updateChapter(@PathVariable Long id, @RequestBody Chapter chapter) {

        if (null == chapterService.getChapterById(id)) {
            return new ResponseEntity("No chapter found for ID " + id, HttpStatus.NOT_FOUND);
        }

        chapterService.updateChaper(chapter);
        return new ResponseEntity(chapter, HttpStatus.OK);
    }
}
