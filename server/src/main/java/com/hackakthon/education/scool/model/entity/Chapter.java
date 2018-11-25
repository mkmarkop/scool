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
//@ToString
@EqualsAndHashCode
public class Chapter {

    @Id
    @GeneratedValue
    private Long id;

    @ElementCollection(targetClass=String.class)
    private List<String> reading;

    @OneToMany(
            mappedBy = "chapter",
            orphanRemoval = true
    )
    private List<Game> games = new ArrayList<>();


    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @Override
    public String toString() {
        return "Chapter{" +
                "id=" + id +
                ", reading=" + reading +
                ", games=" + games +
                ", project=" + project.getId() +
                '}';
    }
}
