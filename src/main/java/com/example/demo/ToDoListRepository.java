package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoListRepository extends JpaRepository<ToDoListEntity, Long> {
	
	ToDoListEntity findByListId(Long listId);
	
	List<ToDoListEntity> findByTask(String task);
	
	List<ToDoListEntity> findByIsTaskDone(Boolean isTaskDone);
	
	
	
	
	
	
	

}
