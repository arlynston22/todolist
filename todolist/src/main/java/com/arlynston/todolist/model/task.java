package com.arlynston.todolist.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class task {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String taskname;
	public task() {
		super();
		// TODO Auto-generated constructor stub
	}
	public task(int id, String taskname) {
		super();
		this.id = id;
		this.taskname = taskname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTaskname() {
		return taskname;
	}
	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}
	
}