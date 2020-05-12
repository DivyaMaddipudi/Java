package com.maven.todo;


import java.util.ArrayList;
import java.util.List;

public class TodoService {

	private static List<Todo> todos = new ArrayList<Todo>();
	static {
		todos.add(new Todo("Learn Web Application Development"));
		todos.add(new Todo("Learn Maven"));
		todos.add(new Todo("Learn Spring"));
	}
	
	public List<Todo> retriveTodos() {
		return todos;
	}
}
