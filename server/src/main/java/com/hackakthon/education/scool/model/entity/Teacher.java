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
public class Teacher {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    private String subject;

    @OneToMany(
            mappedBy = "teacher",
            orphanRemoval = true
    )
    private List<Project> projects = new ArrayList<>();
}
