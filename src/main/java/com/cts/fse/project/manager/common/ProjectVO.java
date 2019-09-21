package com.cts.fse.project.manager.common;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ProjectVO {
	
	String projectName;
	String managerName;
	int priority;
	LocalDate startDate;
	LocalDate endDate;



}
