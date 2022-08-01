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

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class CourseDaoImpl implements CourseDao {

    @Override
    public void saveCourse(Course course) {
        EntityManager entityManager = Config.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(course);
        entityManager.getTransaction().commit();
        System.out.println("Course save successfully!");
        entityManager.close();
//       try {
//           Session session = Config.getSession().openSession();
//           session.beginTransaction();
//           session.save(course);
//           session.getTransaction().commit();
//           System.out.println("Course saved successfully!");
//           session.close();
//       } catch (HibernateException e) {
//           System.out.println(e.getMessage());
//       }

    }
    @Override
    public void updateCourse(Long id,Course course) {
        EntityManager entityManager = Config.getEntityManager();
        entityManager.getTransaction().begin();
        Course courses = entityManager.find(Course.class,id);
        courses.setName(course.getName());
        courses.setDescription(course.getDescription());
        courses.setImagineLink(course.getImagineLink());
        courses.setDuration(course.getDuration());
        courses.setCreateAt(course.getCreateAt());
        entityManager.getTransaction().commit();
        System.out.println("Course saved successfully!");
        entityManager.close();
//         try {
//             Session session = Config.getSession().openSession();
//             session.beginTransaction();
//             Course courses = session.find(Course.class,id);
//             courses.setName(course.getName());
//             courses.setDuration(course.getDuration());
//             courses.setCreateAt(course.getCreateAt());
//             courses.setDescription(course.getDescription());
//             courses.setImagineLink(course.getImagineLink());
//             session.getTransaction().commit();
//             System.out.println("Course updated successfully!");
//             session.close();
//         } catch (HibernateException e) {
//             System.out.println(e.getMessage());
//         }
    }
    @Override
    public Course getCourseById(Long id) {
        EntityManager entityManager = Config.getEntityManager();
        entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class,id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return course;
//        try {
//            Session session = Config.getSession().openSession();
//            session.beginTransaction();
//            Course course = session.get(Course.class,id);
//            session.getTransaction().commit();
//            session.close();
//             return course;
//        } catch (HibernateException e) {
//            System.out.println(e.getMessage());
//            return null;
//        }
    }
    @Override
    public List<Course> getAllCourse() {
        EntityManager entityManager = Config.getEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Course> query = entityManager.createQuery("SELECT c FROM Course c ORDER BY c.createAt DESC",Course.class);
        List<Course> courses = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return courses;
//        try {
//            Session session = Config.getSession().openSession();
//            session.beginTransaction();
//            Query<Course> query = session.createQuery("SELECT c FROM Course c ORDER BY c.createAt DESC",Course.class);
//            List<Course> courses = query.getResultList();
//            session.getTransaction().commit();
//            session.close();
//            return courses;
//        } catch (HibernateException e) {
//            System.out.println(e.getMessage());
//            return null;
//        }
    }
    @Override
    public void deleteCourseById(Long id) {
        EntityManager entityManager = Config.getEntityManager();
        entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class,id);
        for (Instructor instructor : course.getInstructors()) {
            instructor.setCourse(null);
        }
        entityManager.remove(course);
        entityManager.getTransaction().commit();
        System.out.println("Course removed by id successfully!");
        entityManager.close();
//        try {
//            Session session = Config.getSession().openSession();
//            session.beginTransaction();
//            Course course = session.find(Course.class,id);
//            for (Instructor i : course.getInstructors()) {i.setCourse(null);}
//            session.delete(course);
//            session.getTransaction().commit();
//            System.out.println("Remove course by id successfully!");
//            session.close();
//        } catch (HibernateException e) {
//            System.out.println(e.getMessage());
//        }
    }
    @Override
    public Course getCourseByName(String name) {
        EntityManager entityManager = Config.getEntityManager();
        entityManager.getTransaction().begin();
        Course course = entityManager.createQuery("SELECT c FROM Course c where c.name = : name",Course.class)
                .setParameter("name",name).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return course;
    }
//      try {
//          Session session = Config.getSession().openSession();
//          session.beginTransaction();
//          Course course = session.createQuery("select c from Course c where c.name = :name",Course.class)
//                  .setParameter("name",name)
//                  .getSingleResult();
//          session.getTransaction().commit();
//          session.close();
//          return course;
//      } catch (HibernateException e) {
//          System.out.println(e.getMessage());
//          return null;
//      }
//    }
}
