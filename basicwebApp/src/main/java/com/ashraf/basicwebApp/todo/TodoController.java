package com.ashraf.basicwebApp.todo;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoController {

	@Autowired
	private TodoService todoService;

	@RequestMapping(value = "list-todos", method = RequestMethod.GET)
	public String getTodoList(ModelMap model) {
		model.addAttribute("todos", todoService.getTodoByUserName(getLoggedInUserName()));
		return "to-dos";
	}

	@RequestMapping(value = "add-todos", method = RequestMethod.GET)
	public String showNewTodo(ModelMap model) {
		model.put("todo", new Todo(0, getLoggedInUserName(), "", LocalDate.now().plusYears(1), false));
		return "new-todo";
	}

	@RequestMapping(value = "add-todos", method = RequestMethod.POST)
	public String addNewTodo(ModelMap map, @Valid Todo todo, BindingResult result) {
		if (result.hasErrors()) {
			return "new-todo";
		}
		todoService.addNewTodos(getLoggedInUserName(), todo.getDescription(), todo.getTargetDate(), false);
		return "redirect:list-todos";
	}

	@RequestMapping(value = "delete-todos")
	public String deleteNewTodo(@RequestParam int id) {
		todoService.deleteTodoListById(id);
		return "redirect:list-todos";
	}

	@RequestMapping(value = "update-todos", method = RequestMethod.GET)
	public String showUpdateTodo(@RequestParam int id, ModelMap map) {
		Todo todo = todoService.findById(id);
		map.addAttribute("todo", todo);
		return "new-todo";
	}

	@RequestMapping(value = "update-todos", method = RequestMethod.POST)
	public String updateToDo(ModelMap map, @Valid Todo todo, BindingResult result) {

		Todo updatedTodo = new Todo(todo.getId(),getLoggedInUserName(), todo.getDescription(), todo.getTargetDate(), false);
		if (result.hasErrors()) {
			return "new-todo";
		}
		todoService.updateToDo(updatedTodo);
		return "redirect:list-todos";
	}

	private String getLoggedInUserName() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
}
