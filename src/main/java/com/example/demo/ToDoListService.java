package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoListService {
	
	@Autowired
	private ToDoListRepository toDoListRepository;
	
	public String createTask(ToDoListEntity task) {
		List<ToDoListEntity> isTaskExists = toDoListRepository.findByTask(task.getTask());
		if(null!=isTaskExists && isTaskExists.size()>0) {
			return "Task is already Present";
		}else {
			toDoListRepository.save(task);
			return "Task is added";
		}
	}	
	public List<ToDoListEntity> getAllTask() { 
        return toDoListRepository.findAll(); 
    } 
	
	  public ToDoListEntity findTaskById(Long id) { 
	        return toDoListRepository.findByListId(id); 
	    }
	      
	    public List<ToDoListEntity> findAllByTaskStatus(Boolean isTaskDone) { 
	        return toDoListRepository.findByIsTaskDone(isTaskDone); 
	    }
	      
	    public String deleteTask(ToDoListEntity task) { 
	    	toDoListRepository.delete(task);
			return "Task "+task.getListId()+" is deleted."; 
	    } 
	      
	    public String updateTask(ToDoListEntity task) { 
	        toDoListRepository.save(task);
			return "Task "+task.getListId()+" is updated."; 
	    } 
	
	

}
