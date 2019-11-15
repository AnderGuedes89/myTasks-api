package com.tasks.myTasks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tasks.myTasks.models.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{
	
	Task findById(long id);
	
}
