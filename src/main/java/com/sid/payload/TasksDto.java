package com.sid.payload;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class TasksDto {

	
	
	private Integer taskId;

	@NotBlank(message = "TaskName field is required")
	@Size(min = 2,max = 20,message = "min 2 and max 20 character are allowed")
	private String taskName;


	private LocalDateTime assignDate;


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



