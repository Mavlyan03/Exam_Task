package org.example.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "task_seq",sequenceName = "task_seq",allocationSize = 1)
    private Long id;
    @Column(length = 35)
    private String name;
    @Column(name = "dead_line")
    private LocalDate deadline;
    @Column
    private String task;

    @ManyToOne(cascade =
            {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH},
            fetch = FetchType.EAGER)
    private Lesson lesson;

    public Task(String name, LocalDate deadline, String task) {
        this.name = name;
        this.deadline = deadline;
        this.task = task;
    }

    @Override
    public String toString() {
        return " name='" + name + '\'' +
                ", deadline='" + deadline + '\'';
    }
}
