package com.arlynston.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.arlynston.model.task;
import com.arlynston.repository.TaskRepository;

@Controller
public class TaskController {
	
	@Autowired
	TaskRepository taskRepository;
	
	@RequestMapping("/")
	public String home() {
	 
	    return "index";
	}
	
	@GetMapping("/task")
    public List<task> index(){
        return taskRepository.findAll();
    }
    
    
}
