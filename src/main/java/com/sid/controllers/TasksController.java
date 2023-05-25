package com.sid.controllers;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sid.payload.ApiResponse;
import com.sid.payload.TasksDto;
import com.sid.services.TaskService;



@RestController
@RequestMapping("/task")
public class TasksController {

	
	@Autowired
	private TaskService taskService;
	
	
	
	//CREATE TASKS 
	@PostMapping("/createTask")
	public ResponseEntity<TasksDto> createtask(@Valid @RequestBody TasksDto taskDto)
	{
		TasksDto createTaskDto = taskService.createTask(taskDto);
		return new ResponseEntity<>(createTaskDto,HttpStatus.OK);
		
	}
	
	
	//DELETE TASK BY ID
	@DeleteMapping("/delete/{taskId}")
	public ResponseEntity<ApiResponse> deletetasks(@PathVariable("taskId") Integer taskId)
	{
		taskService.deleteTasks(taskId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Task Deleted Succesfully",true),HttpStatus.OK);
	}
	
	
	//GET ALL TASKS
	@GetMapping("/fetch")
	public ResponseEntity<List<TasksDto>> getAllTask()
	{
		return ResponseEntity.ok(this.taskService.getAllTasks());
	}
	
	
	//UPDATE TASKS BY ID
	@PutMapping("/update/{taskId}")
	public ResponseEntity<TasksDto> updateUser(@RequestBody TasksDto taskDto,@PathVariable Integer taskId){
		TasksDto tasksUser = taskService.Updatetask(taskDto,taskId);
		return new ResponseEntity<TasksDto>(tasksUser,HttpStatus.OK);
	}
	
	
	//GET ALL TASKS
	@GetMapping("/task/{taskId}")
	public ResponseEntity<TasksDto> getSingleUsers(@PathVariable Integer userId)
	{
		TasksDto taskById = taskService.getTaskById(userId);
		return ResponseEntity.ok(taskById);
	}
	
	
}
