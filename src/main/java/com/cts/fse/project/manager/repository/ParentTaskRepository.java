package com.cts.fse.project.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.fse.project.manager.entity.ParentTask;

public interface ParentTaskRepository extends JpaRepository<ParentTask, Integer> {
	
	

}
