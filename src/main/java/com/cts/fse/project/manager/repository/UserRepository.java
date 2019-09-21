package com.cts.fse.project.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.fse.project.manager.entity.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByFirstNameAndLastNameAndEmployeeId(String firstName,
                                                          String lastName, int employeeId);

}
