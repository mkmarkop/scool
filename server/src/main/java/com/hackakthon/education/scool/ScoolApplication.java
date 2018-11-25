package com.hackakthon.education.scool;

import com.hackakthon.education.scool.model.entity.Chapter;
import com.hackakthon.education.scool.model.entity.Game;
import com.hackakthon.education.scool.model.entity.Project;
import com.hackakthon.education.scool.model.entity.Task;
import com.hackakthon.education.scool.model.repository.ChapterRepository;
import com.hackakthon.education.scool.model.repository.TaskRepository;
import com.hackakthon.education.scool.model.service.*;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class ScoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScoolApplication.class, args);
	}

    @Bean
    ApplicationRunner init(ProjectServiceImpl projectService, ChapterServiceImpl chapterService, GameServiceImpl gameService, TaskServiceImpl taskService) {
        return args -> {
            Project p = Project.builder().tag("history").description("Long description").title("Rinascimento in english").build();

            //System.err.println(p);
            Long p_id= projectService.saveProject(p);

            Chapter c = Chapter.builder().project(projectService.getProjectById(p_id)).reading(Arrays.asList()).games(Arrays.asList()).build();

            Long c_id = chapterService.saveChapter(c);

            projectService.addChapterToProject(p_id, c);


            Game g = Game.builder().chapter(c).build();

            Long game_id = gameService.saveGame(g);

            Task t = Task.builder().answer("cucu").title("aa").image("aa").game(gameService.getGameById(game_id)).build();

            Task t1 = Task.builder().answer("bubusettete").title("aabb").game(gameService.getGameById(game_id)).image("aabb").build();

            Long taskID = taskService.saveTask(t);
            Long task1ID = taskService.saveTask(t1);




            chapterService.addGameToChapter(c_id,gameService.getGameById(game_id));






            gameService.addTaskToGame(game_id, taskService.getTaskById(taskID));
            gameService.addTaskToGame(game_id, taskService.getTaskById(task1ID));


            gameService.getAllGames().forEach(System.err::println);


            chapterService.getAllChapters().forEach(System.err::println);

            //projectService.deleteChapter(p_id, chapterService.getChapterById(c_id));

            //chapterService.deleteChapter(c_id);

            System.err.println("after");
            chapterService.getAllChapters().forEach(System.err::println);

            projectService.getAllProjects().forEach(System.err::println);

            taskService.getAllTasks().forEach(System.err::println);









            //repository.getAllProjects().forEach(System.err::println);

        };
    }
}
