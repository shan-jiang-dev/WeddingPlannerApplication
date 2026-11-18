package com.example.TODOApplication.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.TODOApplication.Entity.Todo;
import com.example.TODOApplication.Service.TODOService;

@Controller
public class TODOController {
	
	@Autowired
	TODOService todoService;
	
	// Model model: Java Object → HTML, pass data from Controller to HTML view
	@RequestMapping("/")
	public String getAllTodo(Model model) {
		List<Todo> listOfTodos = todoService.getAllTodos();
		model.addAttribute("listoftodos", listOfTodos);
		return "task";
	}
	
	
    // @ModelAttribute = Automatically binds the submitted form data to a Java object, modelAttributes contains all form data
    // @ResponseBody = Return data directly to the client. Without @ResponseBody => Return a view name for Spring to resolve.
	@RequestMapping(value="/addtodo", method=RequestMethod.POST)
	public String createTodo(@ModelAttribute Todo todo) {
		
		todoService.saveTodo(todo);
		return "redirect:/";
		
	}

	
	// @ModelAttribute HTML → Java Object， modelAttributes contains all form data
	@RequestMapping(value="/updatetodo/{id}")
	public String updateTodo(@PathVariable("id") Long id, @ModelAttribute Todo todo) {
		todoService.updateTodo(id, todo);
		return "redirect:/";
	}
	
	@RequestMapping("/deletetodo/{id}")
	public String deleteTodo(@PathVariable("id") Long id) { 
		todoService.deleteTodo(id);
		return "redirect:/";
	}
	
//	@RequestMapping
//	public String loadForm() {
//		return "task";
//	}

}
