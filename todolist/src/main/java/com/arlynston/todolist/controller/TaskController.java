package com.arlynston.todolist.controller;

import java.util.List;
import java.util.Map;

import org.apache.tomcat.jni.Stdlib;
import org.aspectj.weaver.NewConstructorTypeMunger;
import org.hibernate.annotations.Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.arlynston.todolist.model.Task;
import com.arlynston.todolist.repository.TaskRepository;
import com.arlynston.todolist.service.TaskService;

@Controller
public class TaskController {
	
	@Autowired
//	TaskRepository taskRepository;
	private TaskService tService;
	
	@GetMapping("/")
	public String home(Model model) {
		List<Task> tasklist = tService.listAll();
		model.addAttribute("tasklist", tasklist);
		model.addAttribute("task", new Task());
		System.out.println("---masuk index---");
	    return "index";
	}
 
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveTask(@ModelAttribute("task") Task std) {
    	System.out.println("check 1: " + std.getStatus());
    	if (std.getStatus() == null) {
    		std.setStatus("Not Completed");
		}
        tService.save(std);
        return "redirect:/";
    }
    
    @RequestMapping("/updatestatus/{id}")
    public String showUpdateStatusPage(@PathVariable(name = "id") int id) {
        Task tdl = tService.get(id);
        String temp = tdl.getStatus();
        System.out.println("Check 2: " + temp);
        if (temp.equals("Not Completed")) {
			tdl.setStatus("Completed");
		}
        tService.save(tdl);
        return "redirect:/";
    }
	
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditTaskPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit");
        Task tdl = tService.get(id);
        mav.addObject("task", tdl);
        return mav;
    }
    
    @RequestMapping("/delete/{id}")
    public String deleteTask(@PathVariable(name = "id") int id) {
        tService.delete(id);
        return "redirect:/";
    }
}
