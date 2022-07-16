package com.arlynston.todolist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arlynston.todolist.model.task;
import com.arlynston.todolist.repository.TaskRepository;

@Service
public class TaskService {
@Autowired
	private TaskRepository rep;
	public List<task> listAll(){
		return rep.findAll();
	}
	
}
