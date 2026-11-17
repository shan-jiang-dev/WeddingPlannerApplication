package com.example.TODOApplication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.TODOApplication.Entity.Todo;
import com.example.TODOApplication.Service.TODOService;

@Controller
public class TODOController {
	
	@Autowired
	TODOService todoService;
	
    // @ModelAttribute = Automatically binds form data to a Java object
    // @ResponseBody = Return data directly to the client. Without @ResponseBody => Return a view name for Spring to resolve.
	@RequestMapping(value="/addtodo", method=RequestMethod.POST)
	@ResponseBody
	public String createTodo(@ModelAttribute Todo todo) {
		
		todoService.saveTodo(todo);
		return "success";
		
	}
	
	@RequestMapping
	public String loadForm() {
		return "task";
	}
	
	public String updateTodo() {
		return null;
	}
	
	public String deleteTodo() {
		return null;
	}
	
	public String getAllTodo() {
		return null;
	}
}
