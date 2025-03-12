package com.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.models.Emp;

public interface EmpRepository extends JpaRepository<Emp, Integer>{

}
