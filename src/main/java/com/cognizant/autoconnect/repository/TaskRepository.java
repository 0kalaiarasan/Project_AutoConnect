package com.cognizant.autoconnect.repository;

import com.cognizant.autoconnect.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByAssignedToFk(Long assignedTo);
    List<Task> findByStatus(String status);
}
