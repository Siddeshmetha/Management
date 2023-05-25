package com.sid.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tasks {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer taskId;
    
	
	private String taskName;
	
	
	private LocalDateTime assignDate;


	public Integer getTaskId() {
		return taskId;
	}


	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}


	public String getTaskName() {
		return taskName;
	}


	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}


	public LocalDateTime getAssignDate() {
		return assignDate;
	}


	public void setAssignDate(LocalDateTime assignDate) {
		this.assignDate = assignDate;
	}
	
	

}