package com.example.demo;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class ToDoListEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long listId;
	public Boolean isTaskDone;
	public String task;

}
