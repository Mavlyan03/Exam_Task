package org.example.daoimpl;

import org.example.config.Config;
import org.example.dao.LessonDao;
import org.example.model.Course;
import org.example.model.Lesson;
import org.example.model.Task;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import java.util.List;

public class LessonDaoImpl implements LessonDao {
    @Override
    public void saveLesson(Long id,Lesson lesson) {
        EntityManager entityManager = Config.getEntityManager();
        entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class,id);
        lesson.setCourse(course);
        entityManager.persist(lesson);
        entityManager.getTransaction().commit();
        System.out.println("Lesson saved successfully!");
        entityManager.close();
//        try {
//            Session session = Config.getSession().openSession();
//            session.beginTransaction();
//            Course course = session.find(Course.class,id);
//            lesson.setCourse(course);
//            session.persist(lesson);
//            session.getTransaction().commit();
//            System.out.println("Lesson save successfully!");
//            session.close();
//        } catch (HibernateException e) {
//            System.out.println(e.getMessage());
//        }
    }
    @Override
    public void updateLesson(Long id,Lesson lesson) {
        EntityManager entityManager = Config.getEntityManager();
        entityManager.getTransaction().begin();
        Lesson lessons = entityManager.find(Lesson.class,id);
        lessons.setName(lesson.getName());
        lessons.setVideoLink(lesson.getVideoLink());
        entityManager.getTransaction().commit();
        System.out.println("Lesson updated successfully!");
        entityManager.close();
//        try {
//            Session session = Config.getSession().openSession();
//            session.beginTransaction();
//            Lesson lessons = session.find(Lesson.class,id);
//            lessons.setName(lesson.getName());
//            lessons.setVideoLink(lesson.getVideoLink());
//            session.getTransaction().commit();
//            System.out.println("Lesson updated successfully!");
//            session.close();
//        } catch (HibernateException e) {
//            System.out.println(e.getMessage());
//        }
    }
    @Override
    public Lesson getLessonById(Long id) {
        EntityManager entityManager = Config.getEntityManager();
        entityManager.getTransaction().begin();
        Lesson lesson = entityManager.find(Lesson.class,id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return lesson;
//        try {
//            Session session = Config.getSession().openSession();
//            session.beginTransaction();
//            Lesson lesson = session.get(Lesson.class,id);
//            session.getTransaction().commit();
//            session.close();
//            return lesson;
//        } catch (HibernateException e) {
//            System.out.println(e.getMessage());
//            return null;
//        }
    }
    @Override
    public List<Lesson> getLessonsByCourseId(Long id) {
        EntityManager entityManager = Config.getEntityManager();
        entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class,id);
        List<Lesson> lessons = course.getLessons();
        entityManager.getTransaction().commit();
        entityManager.close();
        return lessons;
//        try {
//            Session session = Config.getSession().openSession();
//            session.beginTransaction();
//            Course course = session.find(Course.class,id);
//            List<Lesson> lessons = course.getLessons();
//            session.getTransaction().commit();
//            session.close();
//            return  lessons;
//        } catch (HibernateException e) {
//            System.out.println(e.getMessage());
//            return null;
//        }
    }
}
