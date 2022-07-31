package org.example.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "lessons")
@Getter
@Setter
@NoArgsConstructor
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "lesson_seq",sequenceName = "lesson_seq",allocationSize = 1)
    private Long id;
    @Column(length = 30)
    private String name;
    @Column(name = "video_link",length = 35)
    private String videoLink;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id",nullable = false)
    private Course course;
    @OneToMany(cascade = {CascadeType.DETACH,CascadeType.REMOVE,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},
            fetch = FetchType.EAGER,mappedBy = "lesson")
    private List<Task> task;

    public void addTask(Task newTask) {
        this.task.add(newTask);
    }

    public Lesson(String name, String videoLink) {
        this.name = name;
        this.videoLink = videoLink;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", videoLink='" + videoLink + '\'';
    }
}
