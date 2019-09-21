package com.cts.fse.project.manager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cts.fse.project.manager.common.TaskVO;
import com.cts.fse.project.manager.entity.ParentTask;
import com.cts.fse.project.manager.entity.Task;
import com.cts.fse.project.manager.repository.ParentTaskRepository;
import com.cts.fse.project.manager.repository.TaskRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TaskService {
	
	ParentTaskRepository parentTaskRepo;
	TaskRepository taskRepo;

	public Optional<ParentTask> getByParentId(int parentId) {
	
		return parentTaskRepo.findById(parentId);
	}

	public ParentTask insertParentTask(String parentTask) {
		
		ParentTask taskEntity = new ParentTask();
    	taskEntity.setParentTask(parentTask);
    	
		return parentTaskRepo.save(taskEntity);
	}

	public List<ParentTask> findAllParentTasks() {

		return parentTaskRepo.findAll();
	}
	
	public Task insertTask(TaskVO taskVO) {
		
		Task taskEntity = new Task();
		taskEntity.setParentId(taskVO.getParentId());
		taskEntity.setProjectId(taskVO.getProjectId());
		taskEntity.setTask(taskVO.getTaskName());
		taskEntity.setStartDate(taskVO.getStartDate());
		taskEntity.setEndDate(taskVO.getEndDate());
		taskEntity.setPriority(taskVO.getPriority());
		taskEntity.setStatus(" ");
		System.out.println(taskEntity);
		    	
		return taskRepo.save(taskEntity);
	}

	public Task updateTask(TaskVO taskVO, int taskId) {

		Task taskEntity = getTaskById(taskId);
		System.out.println(taskEntity);
		taskEntity.setParentId(taskVO.getParentId());
		taskEntity.setProjectId(taskVO.getProjectId());
		taskEntity.setTask(taskVO.getTaskName());
		taskEntity.setStartDate(taskVO.getStartDate());
		taskEntity.setEndDate(taskVO.getEndDate());
		taskEntity.setPriority(taskVO.getPriority());


		return taskRepo.save(taskEntity);
	}

	public List<Task> findAllTasks() {
		
		return taskRepo.findAll();
	}

	public List<Task> findTasksForProjectId(int projectId) {
		return taskRepo.findByProjectId(projectId);
	}

	public String getParentName(int parentId){
		return parentTaskRepo.findById(parentId).get().getParentTask();
	}

	public Task endTask(int taskId) {
		Task taskEntity = taskRepo.findById(taskId).orElseThrow();
		taskEntity.setStatus("Completed");
		return taskRepo.save(taskEntity);
	}

	public Task getTaskById(int taskId) {
		return taskRepo.findById(taskId).orElseThrow();
	}
}
