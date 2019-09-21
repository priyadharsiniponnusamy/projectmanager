package com.cts.fse.project.manager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.fse.project.manager.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {

    List<Task> findByProjectId(int projectId);

}
