package com.esieeit.projetsi.service;

import com.esieeit.projetsi.domain.model.Task;
import com.esieeit.projetsi.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(Long id, Task taskDetails) {
        return taskRepository.findById(id)
                .map(task -> {
                    if (taskDetails.getTitle() != null) {
                        task.setTitle(taskDetails.getTitle());
                    }
                    if (taskDetails.getDescription() != null) {
                        task.setDescription(taskDetails.getDescription());
                    }
                    if (taskDetails.getStatus() != null) {
                        task.setStatus(taskDetails.getStatus());
                    }
                    if (taskDetails.getPriority() != null) {
                        task.setPriority(taskDetails.getPriority());
                    }
                    return taskRepository.save(task);
                })
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
