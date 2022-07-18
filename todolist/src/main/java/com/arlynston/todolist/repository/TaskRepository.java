package com.arlynston.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arlynston.todolist.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer>{

}
