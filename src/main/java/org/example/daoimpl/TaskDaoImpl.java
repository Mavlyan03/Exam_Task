package org.example.daoimpl;

import org.example.config.Config;
import org.example.dao.TaskDao;
import org.example.model.Lesson;
import org.example.model.Task;

import javax.persistence.EntityManager;
import java.util.List;

public class TaskDaoImpl implements TaskDao {

    @Override
    public void saveTask(Long id,Task task) {
        EntityManager entityManager = Config.getEntityManager();
        entityManager.getTransaction().begin();
        Lesson lesson = entityManager.find(Lesson.class,id);
        lesson.addTask(task);
        task.setLesson(lesson);
        entityManager.getTransaction().commit();
        System.out.println("Task saved successfully!");
        entityManager.close();
//        try {
//            Session session = Config.getSession().openSession();
//            session.beginTransaction();
//            Lesson lesson = session.find(Lesson.class,id);
//            lesson.addTask(task);
//            task.setLesson(lesson);
//            session.save(task);
//            session.getTransaction().commit();
//            System.out.println("Task saved successfully!");
//            session.close();
//        } catch (HibernateException e) {
//            System.out.println(e.getMessage());
//        }
    }
    @Override
    public void updateTask(Long id,Task task) {
        EntityManager entityManager = Config.getEntityManager();
        entityManager.getTransaction().begin();
        Task tasks = entityManager.find(Task.class,id);
        tasks.setName(task.getName());
        tasks.setDeadline(task.getDeadline());
        entityManager.getTransaction().commit();
        System.out.println("Task updated successfully!");
        entityManager.close();
//        try {
//            Session session = Config.getSession().openSession();
//            session.beginTransaction();
//            Task tasks = session.find(Task.class,id);
//            tasks.setName(task.getName());
//            tasks.setDeadline(task.getDeadline());
//            tasks.setTask(task.getTask());
//            session.getTransaction().commit();
//            System.out.println("Task updated successfully!");
//            session.close();
//        } catch (HibernateException e) {
//            System.out.println(e.getMessage());
//        }
    }

    @Override
    public List<Task> getAllTaskByLessonId(Long id) {
        EntityManager entityManager = Config.getEntityManager();
        entityManager.getTransaction().begin();
        Lesson lesson = entityManager.find(Lesson.class,id);
        List<Task> tasks = lesson.getTask();
        entityManager.getTransaction().commit();
        entityManager.close();
        return tasks;
//        try {
//            Session session = Config.getSession().openSession();
//            session.beginTransaction();
//            Lesson lesson = session.get(Lesson.class,id);
//            List<Task> taskList = lesson.getTask();
//            session.getTransaction().commit();
//            session.close();
//            return taskList;
//        } catch (HibernateException e) {
//            System.out.println(e.getMessage());
//            return null;
//        }
    }
    @Override
    public void deleteTaskById(Long id) {
        EntityManager entityManager = Config.getEntityManager();
        entityManager.getTransaction().begin();
        Task task = entityManager.find(Task.class,id);
        task.setLesson(null);
        entityManager.remove(task);
        entityManager.getTransaction().commit();
        System.out.println("Task removed by id successfully!");
        entityManager.close();
//        try {
//            Session session = Config.getSession().openSession();
//            session.beginTransaction();
//            Task task = session.find(Task.class,id);
//            task.setLesson(null);
//            session.save(task);
//            session.remove(task);
//            System.out.println("Task with id deleted successfully!");
//            session.getTransaction().commit();
//            session.close();
//        } catch (HibernateException e) {
//            System.out.println(e.getMessage());
//        }
    }
}
