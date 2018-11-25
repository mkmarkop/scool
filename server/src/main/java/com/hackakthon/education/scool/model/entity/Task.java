package com.hackakthon.education.scool.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Task {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String title;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "game_id")
    private Game game;

    @ElementCollection(targetClass=String.class)
    private List<String> possibleAnswers = new ArrayList<>();

    //for now lets say that the image is a url
    @NonNull
    private String image;

    @NonNull
    private String rightAnswer;


    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", game=" + game.getId() +
                ", possibleAnswers=" + possibleAnswers +
                ", image='" + image + '\'' +
                ", rightAnswer='" + rightAnswer + '\'' +
                '}';
    }
}
