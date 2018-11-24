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
@ToString @EqualsAndHashCode
public class Game {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;


    @OneToMany(
            mappedBy = "game",
            orphanRemoval = true
    )
    private List<Task> tasks = new ArrayList<>();


    @ManyToOne
    @JoinColumn(name = "chapter_id")
    private Chapter chapter;





}
