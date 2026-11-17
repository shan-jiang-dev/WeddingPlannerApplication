package com.example.TODOApplication.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TODOApplication.Entity.Todo;
import com.example.TODOApplication.Repository.TODORepository;

@Service
public class TODOService {
	
	@Autowired
	TODORepository todoRepository;
	
	public void saveTodo(Todo todo) {
		
		todoRepository.save(todo);
		
	}

}
