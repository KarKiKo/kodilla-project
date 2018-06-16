package com.crud.tasks.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tasks")
@EqualsAndHashCode
@ToString
public class Task {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "name")
    private String title;
    @Column(name = "description")
    private String content;
}
