package org.example.service;

import org.example.model.Course;
import org.example.model.Instructor;
import org.example.model.Lesson;
import org.example.model.Task;

import java.time.LocalDate;
import java.util.List;

public interface Service {

    void saveCourse(Course course);

    void updateCourse(Long id,Course course);


    Course getCourseById(Long id);

    List<Course> getAllCourse();

    void deleteCourseById(Long id);

    Course getCourseByName(String name);

    void saveInstructor(Instructor instructor);

    void updateInstructor(Long id,Instructor instructor);

    Instructor getInstructorById(Long id);

    List<Instructor> getInstructorByCourseId(Long id);

    void deleteInstructorById(Long id);

    void assignInstructorToCourse(Long course_id,Long instructor_id);

    void saveLesson(Long id, Lesson lesson);

    void updateLesson(Long id,Lesson lesson);

    Lesson getLessonById(Long id);

    List<Lesson> getLessonsByCourseId(Long id);

    void saveTask(Long id,Task task);

    void updateTask(Long id,Task task);

    List<Task> getAllTaskByLessonId(Long id);

    void deleteTaskById(Long id);


}
