package com.esieeit.projetsi.repository;

import com.esieeit.projetsi.domain.model.Task;
import com.esieeit.projetsi.domain.enums.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByStatus(TaskStatus status);
    
}