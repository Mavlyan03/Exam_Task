package org.example.daoimpl;


import org.example.config.Config;
import org.example.dao.TaskDao;
import org.example.model.Lesson;
import org.example.model.Task;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.Iterator;
import java.util.List;

public class TaskDaoImpl implements TaskDao {
//    method saveTask working successful
    @Override
    public void saveTask(Long id,Task task) {
        try {
            Session session = Config.getSession().openSession();
            session.beginTransaction();
            Lesson lesson = session.find(Lesson.class,id);
            lesson.addTask(task);
            task.setLesson(lesson);
            session.save(task);
            session.getTransaction().commit();
            System.out.println("Task saved successfully!");
            session.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }

    }
//   method updateTask working successful
    @Override
    public void updateTask(Long id,Task task) {
        try {
            Session session = Config.getSession().openSession();
            session.beginTransaction();
            Task tasks = session.find(Task.class,id);
            tasks.setName(task.getName());
            tasks.setDeadline(task.getDeadline());
            tasks.setTask(task.getTask());
            session.getTransaction().commit();
            System.out.println("Task updated successfully!");
            session.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public List<Task> getAllTaskByLessonId(Long id) {
        try {
            Session session = Config.getSession().openSession();
            session.beginTransaction();
            Lesson lesson = session.get(Lesson.class,id);
            List<Task> taskList = lesson.getTask();
            session.getTransaction().commit();
            session.close();
            return taskList;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            return null;
        }

    }
// method deleteTaskById working successful
    @Override
    public void deleteTaskById(Long id) {
        try {
            Session session = Config.getSession().openSession();
            session.beginTransaction();
            Task task = session.find(Task.class,id);
            task.setLesson(null);
            session.save(task);
            session.remove(task);
            System.out.println("Task with id deleted successfully!");
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }


    }
}
