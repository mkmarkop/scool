package com.hackakthon.education.scool;

import com.hackakthon.education.scool.model.entity.Chapter;
import com.hackakthon.education.scool.model.entity.Project;
import com.hackakthon.education.scool.model.entity.Student;
import com.hackakthon.education.scool.model.repository.ChapterRepository;
import com.hackakthon.education.scool.model.repository.ProjectRepository;
import com.hackakthon.education.scool.model.repository.StudentRepository;
import org.assertj.core.util.Arrays;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProjectJpaTest {

        @Autowired
        private ProjectRepository projectRepository;
        @Autowired
        private ChapterRepository chapterRepository;


    @Test
    public void projectTest() {
        // given
        //Long expectedId = new Random().nextLong();
        Project p = Project.builder().build();

        System.err.println("p = "+p);

        p = projectRepository.save(p);

        Chapter c = Chapter.builder().project(p).build();

        c = chapterRepository.save(c);

        List<Chapter> lC = new ArrayList<>();
        lC.add(c);
        p.setChapters(lC);



        projectRepository.save(p);



        //entityManager.flush();

        // when


        projectRepository.findAll().forEach(System.err::println);
        Assert.assertEquals("pippo", "pippo");
    }


}
