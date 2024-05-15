package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ToDoList")
public class ToDoListController {
	
	@Autowired
	ToDoListService toDoListService;
	
	 @GetMapping("/getById") 
	    public ResponseEntity<List<ToDoListEntity>> getAllTasks() { 
	        return ResponseEntity.ok(toDoListService.getAllTask()); 
	    }
	    @GetMapping("/getByTaskStatus") 
	    public ResponseEntity<List<ToDoListEntity>> getAllByTaskStatus(Boolean isTaskDone) { 
	        return ResponseEntity.ok(toDoListService.findAllByTaskStatus(isTaskDone)); 
	    } 
	    @PostMapping("/createTask") 
	    public ResponseEntity<String> createTask(@RequestBody ToDoListEntity toDoList) { 
	        return ResponseEntity.ok(toDoListService.createTask(toDoList)); 
	    } 
	    @PutMapping("/{id}") 
	    public ResponseEntity<String> updateTask(@PathVariable Long id, @RequestBody ToDoListEntity toDoList) { 
	    	toDoList.setListId(id); 
	        return ResponseEntity.ok(toDoListService.updateTask(toDoList)); 
	    } 
	    @DeleteMapping("/{id}") 
	    public ResponseEntity<String> deleteTask(@PathVariable("id") Long id){
        	ToDoListEntity existingTask = toDoListService.findTaskById(id);
        	if(null!=existingTask){
            return ResponseEntity.ok(toDoListService.deleteTask(existingTask));
        	}
	        return ResponseEntity.ok("Error in Deleting the record"); 
	    } 

}
