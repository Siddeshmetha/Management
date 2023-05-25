package com.sid.servicesimpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sid.Exception.ResourceNotFoundException;
import com.sid.models.Tasks;
import com.sid.payload.TasksDto;
import com.sid.repositories.TaskRepository;
import com.sid.services.TaskService;

@Service
public class TaskServiceImpl  implements TaskService{


	@Autowired
	private TaskRepository taskRepository;


	@Autowired
	private ModelMapper modelMapper;


	@Override
	public TasksDto createTask(TasksDto taskDto) {
		Tasks task = modelMapper.map(taskDto,Tasks.class);
		task.setAssignDate(LocalDateTime.now());
		Tasks newPost = this.taskRepository.save(task);
		Tasks saveTasks =taskRepository.save(task);
		return modelMapper.map(saveTasks, TasksDto.class); 
	}

	@Override
	public TasksDto Updatetask(TasksDto taskDto, Integer taskId) {
		Tasks task = taskRepository.findById(taskId).orElseThrow(()-> new ResourceNotFoundException("Task", "Id", taskId));
		task.setTaskName(taskDto.getTaskName());
		task.setAssignDate(LocalDateTime.now());
		Tasks newPost = this.taskRepository.save(task);
		TasksDto  taskdto= modelMapper.map(task, TasksDto.class);
		return taskdto;
	}

	@Override
	public TasksDto getTaskById(Integer taskId) {
		Tasks tasks=taskRepository.findById(taskId)
				.orElseThrow(()-> new ResourceNotFoundException("Task","Id",taskId));

		TasksDto tasksdto = modelMapper.map(tasks, TasksDto.class);
		return tasksdto;
	}

	@Override
	public List<TasksDto> getAllTasks() {
		List<Tasks> findAll = taskRepository.findAll();
		List<TasksDto> collect = findAll.stream().map(task->modelMapper.map(task, TasksDto.class)).collect(Collectors.toList());
		return collect;
	}

	@Override
	public void deleteTasks(Integer taskId) {
		Tasks task = taskRepository.findById(taskId).orElseThrow(()-> new ResourceNotFoundException("Task", "Id", taskId));
		taskRepository.delete(task);

	}

}
