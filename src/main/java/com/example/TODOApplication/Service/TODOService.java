package com.example.TODOApplication.Service;

import java.util.List;
import java.util.Optional;
//import org.hibernate.internal.util.Optional;
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
	


	public List<Todo> getAllTodos() {
		return todoRepository.findAll();
		
	}
	
	public void updateTodo(Long id, Todo newTodo) {
		
		Optional<Todo> todoOldBox = todoRepository.findTODOById(id); // old todo with the specific id
		if(todoOldBox.isPresent()) {
			Todo oldTodo = todoOldBox.get();
			oldTodo.setTaskContent(newTodo.getTaskContent());
			oldTodo.setCompletionStatus(newTodo.getCompletionStatus());
			todoRepository.updateTodo(oldTodo);
		}
	}
	
	public void deleteTodo(Long id) {
		todoRepository.deleteTODOById(id);
	}

}
