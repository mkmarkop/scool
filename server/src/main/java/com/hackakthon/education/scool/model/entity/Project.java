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
@ToString
@EqualsAndHashCode
public class Project {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String tag;
    private String description;

    @OneToMany(
            mappedBy = "project",
            orphanRemoval = true
    )
    private List<Chapter> chapters = new ArrayList<>();


    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;


}
