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

    //for now lets say that the image is a url
    @NonNull
    private String image;

    @NonNull
    private String answer;


    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", game=" + game.getId() +
                ", image='" + image + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
