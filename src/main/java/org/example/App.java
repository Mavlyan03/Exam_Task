package org.example;

import org.example.config.Config;
import org.example.daoimpl.CourseDaoImpl;
import org.example.model.Course;
import org.example.model.Instructor;
import org.example.model.Lesson;
import org.example.model.Task;
import org.example.service.ServiceImpl;

import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;


public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ServiceImpl service = new ServiceImpl();
        System.out.println("Write 1 to save course \nWrite 2 to update course" +
                "\nWrite 3 to get all courses \nWrite 4 to delete course by id" +
                "\n Write 5 to get course by id \nWrite 6 to get course by name");
        System.out.println("Write 7 to save instructor \nWrite 8 to update instructor" +
                "\nWrite 9 to delete instructor by id \nWrite 10 to get course by id" +
                "\nWrite 11 to delete");

        int number = scanner.nextInt();

        switch(number) {
            case 1:
                service.saveCourse(new Course("JavaScript","10 months", (
                        LocalDate.of(2022,7,22)), "j.com","jaga"));
                break;
            case 2:
                service.updateCourse(1L,new Course("C++","6 months",(LocalDate.of(2022,8,10)),
                        "python.https.com","C++ program language"));
                break;
            case 3:
                service.getAllCourse().forEach(System.out::println);
                break;
            case 4:
                 service.deleteCourseById(2L);
                 break;
            case 5:
                System.out.println(service.getCourseById(1L));
                break;
            case 6:
                 System.out.println(service.getCourseByName("Java"));
                 break;
            case 7:
                 service.saveInstructor(new Instructor("Muhammed","Allanov",
                         "m@mail.com","541564453"));
                 break;
            case 8:
                service.updateInstructor(3L,new Instructor("Aijamal","Asangazieva ",
                        "a@gmail.com", "997-473-646-534"));
                break;
            case 9:
                service.deleteInstructorById(5L);
                break;
            case 10:
                service.getInstructorByCourseId(1L).forEach(System.out::println);
                break;
            case 11:
                System.out.println(service.getInstructorById(4L));
                break;
            case 12:
                service.assignInstructorToCourse(4L,2L);
                break;
            case 13:
                service.saveLesson(1L,new Lesson("JDBC","Lesson7:CRUD method"));
                break;
            case 14:
                service.updateLesson(5L,new Lesson("PostgresSQL Join","Lesson5:Join"));
                break;
            case 15:
                System.out.println(service.getLessonById(5L));
                break;
            case 16:
                System.out.println(service.getLessonsByCourseId(1L));
                break;
            case 17:
                service.saveTask(10L,new Task("Hibernate-Relationship",
                        (LocalDate.of(2022,7,19)),"Relation"));
                break;
            case 18:
                service.updateTask(13L,new Task("hibernate-relationship",
                        (LocalDate.of(2022,7,21)), "make crud operations with many to many"));
                break;
            case 19:
                System.out.println(service.getAllTaskByLessonId(8L));
                break;
            case 20:
                service.deleteTaskById(11L);
                break;
            default:
                System.err.println("You enter wrong number!");
        }

        CourseDaoImpl dao = new CourseDaoImpl();
        dao.deleteCourseById(1L);
    }
}
