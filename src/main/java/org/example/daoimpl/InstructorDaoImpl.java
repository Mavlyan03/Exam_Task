package org.example.daoimpl;

import org.example.config.Config;
import org.example.dao.InstructorDao;
import org.example.model.Course;
import org.example.model.Instructor;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;
import java.util.Scanner;

public class InstructorDaoImpl implements InstructorDao {

//    method saveInstructor working successful
    @Override
    public void saveInstructor(Instructor instructor) {
        try {
            Session session = Config.getSession().openSession();
            session.beginTransaction();
            session.save(instructor);
            session.getTransaction().commit();
            System.out.println("Instructor saved successfully!");
            session.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }


    }
//    method updateInstructor working successful
    @Override
    public void updateInstructor(Long id,Instructor instructor) {
        try {
             Session session = Config.getSession().openSession();
             session.beginTransaction();
             Instructor instructors = session.find(Instructor.class,id);
             instructors.setFirstName(instructor.getFirstName());
             instructors.setEmail(instructor.getEmail());
             instructors.setPhoneNumber(instructor.getPhoneNumber());
             session.getTransaction().commit();
            System.out.println("Instructor updated successfully!");
             session.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }

    }
//    method getInstructorById working successful
    @Override
    public Instructor getInstructorById(Long id) {
        try {
            Session session = Config.getSession().openSession();
            session.beginTransaction();
            Instructor instructor = session.get(Instructor.class,id);
            session.getTransaction().commit();
            session.close();
            return instructor;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
//    method getInstructorByCourseId working successful
    @Override
    public List<Instructor> getInstructorByCourseId(Long id) {
        try {
            Session  session = Config.getSession().openSession();
            session.beginTransaction();
            Course course = session.get(Course.class,id);
            List<Instructor> instructors = course.getInstructors();
            session.getTransaction().commit();
            session.close();
            return instructors;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
//    method deleteInstructorById working successful
    @Override
    public void deleteInstructorById(Long id) {
        try {
            Session session = Config.getSession().openSession();
            session.beginTransaction();
            Instructor instructor = session.find(Instructor.class,id);
            session.delete(instructor);
            session.getTransaction().commit();
            System.out.println("Remove instructor by id successfully!");
            session.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }

    }
//    method assignInstructorToCourse working successful
    @Override
    public void assignInstructorToCourse(Long course_id,Long instructor_id) {
        try {
            Session session = Config.getSession().openSession();
            session.beginTransaction();
            Instructor instructor = session.find(Instructor.class,instructor_id);
            Course course = session.find(Course.class,course_id);
            instructor.addCourse(course);
            course.addInstructors(instructor);
            session.persist(instructor);
          //  session.persist(course);
            session.getTransaction().commit();
            System.out.println("Assign Instructor to course successfully!");
            session.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }


}
