package com.arlynston.todolist.controller;

import java.util.List;
import java.util.Map;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.arlynston.todolist.model.task;
import com.arlynston.todolist.repository.TaskRepository;
import com.arlynston.todolist.service.TaskService;

@Controller
public class TaskController {
	
	@Autowired
//	TaskRepository taskRepository;
	private TaskService tService;
	
	@GetMapping("/")
	public String home(Model model) {
		List<task> tasklist = tService.listAll();
		model.addAttribute("tasklist", tasklist);
		System.out.print("Get / ");
	    return "index";
	}

	
//	@GetMapping("/task")
//    public List<task> index(){
//        return taskRepository.findAll();
//    }
//    
//
//    @PostMapping("/task")
//    public task create(@RequestBody Map<Integer,String> body){
//        String id = body.get("id");
//    	String taskname = body.get("taskname");
//        return taskRepository.save(new task(Integer.parseInt(id), taskname));
//    }

    
    
}
