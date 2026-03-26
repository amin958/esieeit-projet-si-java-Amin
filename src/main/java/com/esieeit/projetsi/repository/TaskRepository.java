package com.esieeit.projetsi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.esieeit.projetsi.domain.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}