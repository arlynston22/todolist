package com.arlynston.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arlynston.model.task;

@Repository
public interface TaskRepository extends JpaRepository<task, Integer>{

}
