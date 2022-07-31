package org.example.model;

import lombok.*;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
public class  Course {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "course_seq",sequenceName = "course_seq",allocationSize = 1)

    private Long id;
    @Column(length = 25)
    private String name;
    @Column(length = 30)
    private String duration;
    @Column(length = 50)
    private LocalDate createAt;
    @Column(name = "imagine_link",unique = true,length = 35)
    private String imagineLink;
    @Column(unique = true)
    private String description;

    @ManyToMany(mappedBy = "course",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private List<Instructor> instructors = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "course",fetch = FetchType.EAGER)
    private List<Lesson> lessons;

     public void addInstructors(Instructor instructor) {
        instructor.getCourse().add(this);
     }

    public Course(String name, String duration, LocalDate createAt, String imagineLink, String description) {
        this.name = name;
        this.duration = duration;
        this.createAt = createAt;
        this.imagineLink = imagineLink;
        this.description = description;
    }

    @Override
    public String toString() {
        return " name='" + name + '\'' +
                ", duration='" + duration + '\'' +
                ", createAt='" + createAt + '\'' +
                ", imagineLink='" + imagineLink + '\'' +
                ", description='" + description + '\'';
    }
}
