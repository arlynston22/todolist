package com.arlynston.todolist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arlynston.todolist.model.Task;
import com.arlynston.todolist.repository.TaskRepository;

@Service
public class TaskService {
@Autowired
	private TaskRepository rep;
	public List<Task> listAll(){
		return rep.findAll();
	}
    public void save(Task tdl) {
        rep.save(tdl);
    }
    public Task get(Integer id) {
    	return rep.findById(id).get();
    }
    public void delete(Integer id) {
    	rep.deleteById(id);
    }
}
