package org.example;

import org.example.config.Config;
import org.example.model.Course;
import org.example.model.Instructor;
import org.example.model.Lesson;
import org.example.model.Task;
import org.example.service.ServiceImpl;

import java.time.LocalDate;
import java.time.Month;


public class App {

    public static void main(String[] args) {
//        Config.getSession();
        ServiceImpl service = new ServiceImpl();
//        service.saveInstructor(new Instructor("Zamir","Sabyrzhanov","z@mail.com","251910"));
//        service.saveCourse(new Course("JavaScript","10 months",(LocalDate.of(2022,7,22)), "j.com","jaga"));
//        service.assignInstructorToCourse(1L,3L);
//        service.assignInstructorToCourse(1L,4L);
//        service.updateCourse(1L,new Course("C++","6 months",(LocalDate.of(2022,8,10)),
//                "python.https.com","C++ program language"));
//        service.updateInstructor(3L,new Instructor("Muhammed","Allanov ","m@gmail.com",
//                "997-473-646-534"));
//        service.getAllCourse().forEach(System.out::println);
//        System.out.println(service.getCourseByName("Java"));
//        service.getInstructorByCourseId(1L).forEach(System.out::println);
//        System.out.println(service.getCourseById(2L));
//        System.out.println(service.getInstructorById(3L));
//        service.deleteCourseById(7L);
//        service.deleteInstructorById(3L);

//        service.saveTask(10L,new Task("Hibernate-Relationship",(LocalDate.of(2022,7,19)),"Relation"));
//        service.saveLesson(1L,new Lesson("JDBC","Lesson7:CRUD method"));
        service.deleteTaskById(13L);
//        service.updateLesson(5L,new Lesson("PostgresSQL Join","Lesson5:Join"));
//        System.out.println(service.getLessonById(5L));
//        service.getAllTaskByLessonId(5L).forEach(System.out::println);
//        System.out.println(service.getLessonById(5L));
//        System.out.println(service.getLessonsByCourseId(1L));
//        service.updateTask(13L,new Task("hibernate-relationship",(LocalDate.of(2022,7,21)),
//                "make crud operations with many to many"));
//        service.deleteTaskById();





    }
}
