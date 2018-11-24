package com.hackakthon.education.scool.model.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class Student {

    @Id @GeneratedValue
    private Long id;

    @NonNull
    private String firstName;
}
