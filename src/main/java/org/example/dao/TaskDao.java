package org.example.dao;

import org.example.model.Task;

import java.time.LocalDate;
import java.util.List;

public interface TaskDao {

    void saveTask(Long id,Task task);

    void updateTask(Long id,Task task);
    List<Task> getAllTaskByLessonId(Long id);

    void deleteTaskById(Long id);

}
