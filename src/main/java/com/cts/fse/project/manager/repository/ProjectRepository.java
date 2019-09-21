package com.cts.fse.project.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.fse.project.manager.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

}
