package org.example.daoimpl;

import com.sun.istack.Nullable;
import lombok.NonNull;
import org.example.config.Config;
import org.example.dao.CourseDao;
import org.example.model.Course;
import org.example.model.Instructor;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class CourseDaoImpl implements CourseDao {

//   method saveCourse working successful
    @Override
    public void saveCourse(Course course) {
       try {
           Session session = Config.getSession().openSession();
           session.beginTransaction();
           session.save(course);
           session.getTransaction().commit();
           System.out.println("Course saved successfully!");
           session.close();
       } catch (HibernateException e) {
           System.out.println(e.getMessage());
       }

    }
//     method updateCourse working successful
    @Override
    public void updateCourse(Long id,Course course) {
         try {
             Session session = Config.getSession().openSession();
             session.beginTransaction();
             Course courses = session.find(Course.class,id);
             courses.setName(course.getName());
             courses.setDuration(course.getDuration());
             courses.setCreateAt(course.getCreateAt());
             courses.setDescription(course.getDescription());
             courses.setImagineLink(course.getImagineLink());
             session.getTransaction().commit();
             System.out.println("Course updated successfully!");
             session.close();
         } catch (HibernateException e) {
             System.out.println(e.getMessage());
         }
    }
//    method getCourseById working successful
    @Override
    public Course getCourseById(Long id) {
        try {
            Session session = Config.getSession().openSession();
            session.beginTransaction();
            Course course = session.get(Course.class,id);
            session.getTransaction().commit();
            session.close();
             return course;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

//    method getAllCourse working successful
    @Override
    public List<Course> getAllCourse() {
        try {
            Session session = Config.getSession().openSession();
            session.beginTransaction();
            Query<Course> query = session.createQuery("SELECT c FROM Course c ORDER BY c.createAt DESC",Course.class);
            List<Course> courses = query.getResultList();
            session.getTransaction().commit();
            session.close();
            return courses;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
//   method deleteCourseById working successful
    @Override
    public void deleteCourseById(Long id) {
        try {
            Session session = Config.getSession().openSession();
            session.beginTransaction();
            Course course = session.find(Course.class,id);
            for (Instructor i : course.getInstructors()) {i.setCourse(null);}
            session.delete(course);
            session.getTransaction().commit();
            System.out.println("Remove course by id successfully!");
            session.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }

//    method getCourseByName working successful
    @Override
    public Course getCourseByName(String name) {
      try {
          Session session = Config.getSession().openSession();
          session.beginTransaction();
          Course course = session.createQuery("select c from Course c where c.name = :name",Course.class)
                  .setParameter("name",name)
                  .getSingleResult();
          session.getTransaction().commit();
          session.close();
          return course;
      } catch (HibernateException e) {
          System.out.println(e.getMessage());
          return null;
      }
    }
}
