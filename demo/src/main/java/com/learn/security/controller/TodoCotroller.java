package com.learn.security.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoCotroller {
	
	private Logger LOGGER= LoggerFactory.getLogger(this.getClass());
	private static final List<Todos> Todo_List = List.of(new Todos("ashraf", "Learn Spring Security"), 
					new Todos("saif","Learn Medicine"));

	@GetMapping("/todos")
	public List<Todos> retrieveAllToDos(){
		return Todo_List;
	}
	
	@GetMapping("/users/{username}/todos")
	@PreAuthorize("hasAuthority('ROLE_USER') and #username=authentication.name")
	public List<Todos> retrieveTodosForSpecificUser(@PathVariable String username){
		return Todo_List.stream().filter(el->el.username().equalsIgnoreCase(username)).collect(Collectors.toList());
	}
	
	@PostMapping("/users/{username}/todos")
	public void saveTodosForUser(@PathVariable String username, @RequestBody Todos todo) {
		LOGGER.info("Creating {} for user {}",username,todo);
	}
}

record Todos(String username, String description) {};