package org.example.daoimpl;

import org.example.config.Config;
import org.example.dao.LessonDao;
import org.example.model.Course;
import org.example.model.Lesson;
import org.example.model.Task;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

public class LessonDaoImpl implements LessonDao {
//    method saveLesson working successful
    @Override
    public void saveLesson(Long id,Lesson lesson) {
        try {
            Session session = Config.getSession().openSession();
            session.beginTransaction();
            Course course = session.find(Course.class,id);
            lesson.setCourse(course);
            session.persist(lesson);
            session.getTransaction().commit();
            System.out.println("Lesson save successfully!");
            session.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }
//    method updateLesson working successful
    @Override
    public void updateLesson(Long id,Lesson lesson) {
        try {
            Session session = Config.getSession().openSession();
            session.beginTransaction();
            Lesson lessons = session.find(Lesson.class,id);
            lessons.setName(lesson.getName());
            lessons.setVideoLink(lesson.getVideoLink());
            session.getTransaction().commit();
            System.out.println("Lesson updated successfully!");
            session.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }

    }
// method getLessonById
    @Override
    public Lesson getLessonById(Long id) {
        try {
            Session session = Config.getSession().openSession();
            session.beginTransaction();
            Lesson lesson = session.get(Lesson.class,id);
            session.getTransaction().commit();
            session.close();
            return lesson;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
//   method getLessonsByCourseId
    @Override
    public List<Lesson> getLessonsByCourseId(Long id) {
        try {
            Session session = Config.getSession().openSession();
            session.beginTransaction();
            Course course = session.find(Course.class,id);
            List<Lesson> lessons = course.getLessons();
            session.getTransaction().commit();
            session.close();
            return  lessons;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
