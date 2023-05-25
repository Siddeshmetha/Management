package com.sid.services;

import java.util.List;

import com.sid.payload.TasksDto;



public interface TaskService {

	TasksDto createTask(TasksDto taskDto);

	TasksDto Updatetask(TasksDto task, Integer taskId);

	TasksDto getTaskById(Integer taskId);

	List<TasksDto> getAllTasks(); 

	void deleteTasks(Integer taskId);



}
