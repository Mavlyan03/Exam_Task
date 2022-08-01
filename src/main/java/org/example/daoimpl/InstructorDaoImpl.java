package org.example.daoimpl;

import org.example.config.Config;
import org.example.dao.InstructorDao;
import org.example.model.Course;
import org.example.model.Instructor;

import javax.persistence.EntityManager;
import java.util.List;

public class InstructorDaoImpl implements InstructorDao {
    @Override
    public void saveInstructor(Instructor instructor) {
        EntityManager entityManager = Config.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(instructor);
        entityManager.getTransaction().commit();
        System.out.println("Instructor saved successfully!");
        entityManager.close();
//        try {
//            Session session = Config.getSession().openSession();
//            session.beginTransaction();
//            session.save(instructor);
//            session.getTransaction().commit();
//            System.out.println("Instructor saved successfully!");
//            session.close();
//        } catch (HibernateException e) {
//            System.out.println(e.getMessage());
//        }
    }
    @Override
    public void updateInstructor(Long id,Instructor instructor) {
        EntityManager entityManager = Config.getEntityManager();
        entityManager.getTransaction().begin();
        Instructor instructors = entityManager.find(Instructor.class,id);
        instructors.setFirstName(instructor.getFirstName());
        instructors.setLastName(instructor.getLastName());
        instructors.setEmail(instructor.getEmail());
        instructors.setPhoneNumber(instructor.getPhoneNumber());
        entityManager.getTransaction().commit();
        System.out.println("Instructor updated successfully!");
        entityManager.close();
//        try {
//             Session session = Config.getSession().openSession();
//             session.beginTransaction();
//             Instructor instructors = session.find(Instructor.class,id);
//             instructors.setFirstName(instructor.getFirstName());
//             instructors.setEmail(instructor.getEmail());
//             instructors.setPhoneNumber(instructor.getPhoneNumber());
//             session.getTransaction().commit();
//            System.out.println("Instructor updated successfully!");
//             session.close();
//        } catch (HibernateException e) {
//            System.out.println(e.getMessage());
//        }
    }

    @Override
    public Instructor getInstructorById(Long id) {
        EntityManager entityManager = Config.getEntityManager();
        entityManager.getTransaction().begin();
        Instructor instructor = entityManager.find(Instructor.class,id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return instructor;
//        try {
//            Session session = Config.getSession().openSession();
//            session.beginTransaction();
//            Instructor instructor = session.get(Instructor.class,id);
//            session.getTransaction().commit();
//            session.close();
//            return instructor;
//        } catch (HibernateException e) {
//            System.out.println(e.getMessage());
//            return null;
//        }
    }
    @Override
    public List<Instructor> getInstructorByCourseId(Long id) {
        EntityManager entityManager = Config.getEntityManager();
        entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class,id);
        List<Instructor> instructors = course.getInstructors();
        entityManager.getTransaction().commit();
        entityManager.close();
        return instructors;
//        try {
//            Session  session = Config.getSession().openSession();
//            session.beginTransaction();
//            Course course = session.get(Course.class,id);
//            List<Instructor> instructors = course.getInstructors();
//            session.getTransaction().commit();
//            session.close();
//            return instructors;
//        } catch (HibernateException e) {
//            System.out.println(e.getMessage());
//            return null;
//        }
    }
    @Override
    public void deleteInstructorById(Long id) {
        EntityManager entityManager = Config.getEntityManager();
        entityManager.getTransaction().begin();
        Instructor instructor = entityManager.find(Instructor.class,id);
        entityManager.remove(instructor);
        entityManager.getTransaction().commit();
        System.out.println("Instructor removed by id successfully!");
        entityManager.close();
//        try {
//            Session session = Config.getSession().openSession();
//            session.beginTransaction();
//            Instructor instructor = session.find(Instructor.class,id);
//            session.delete(instructor);
//            session.getTransaction().commit();
//            System.out.println("Remove instructor by id successfully!");
//            session.close();
//        } catch (HibernateException e) {
//            System.out.println(e.getMessage());
//        }
    }
    @Override
    public void assignInstructorToCourse(Long course_id,Long instructor_id) {
        EntityManager entityManager = Config.getEntityManager();
        entityManager.getTransaction().begin();
        Instructor instructor = entityManager.find(Instructor.class,instructor_id);
        Course course = entityManager.find(Course.class,course_id);
        instructor.addCourse(course);
        course.addInstructors(instructor);
        entityManager.persist(instructor);
//        entityManager.persist(course);
        entityManager.getTransaction().commit();
        System.out.println("Assign Instructor to Course successfully!");
        entityManager.close();
//        try {
//            Session session = Config.getSession().openSession();
//            session.beginTransaction();
//            Instructor instructor = session.find(Instructor.class,instructor_id);
//            Course course = session.find(Course.class,course_id);
//            instructor.addCourse(course);
//            course.addInstructors(instructor);
//            session.persist(instructor);
//          //  session.persist(course);
//            session.getTransaction().commit();
//            System.out.println("Assign Instructor to course successfully!");
//            session.close();
//        } catch (HibernateException e) {
//            System.out.println(e.getMessage());
//        }
    }
}
