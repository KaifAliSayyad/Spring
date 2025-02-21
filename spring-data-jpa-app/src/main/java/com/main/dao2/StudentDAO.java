package com.main.dao2;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.entities.Student;

public interface StudentDAO extends JpaRepository<Student, Integer> {

}
