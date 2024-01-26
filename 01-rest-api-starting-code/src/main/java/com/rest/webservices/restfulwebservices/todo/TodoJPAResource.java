package com.rest.webservices.restfulwebservices.todo;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class TodoJPAResource {

		private TodoService todoService;
		private TodoJPARepository todoJpaRepository;

		public TodoJPAResource(TodoService todoService ,TodoJPARepository todoJpaRepository) {
			this.todoService = todoService;
			this.todoJpaRepository=todoJpaRepository;
		}
		
		@GetMapping("/user/{username}/todos")
		public ResponseEntity<List<Todo>> getUserTodos(@PathVariable String username) {
//			List<Todo> todoList = this.todoService.findByUsername(username);
			List<Todo> todoList = this.todoJpaRepository.findByUsername(username);
			return ResponseEntity.ok(todoList);
		}
		
		@GetMapping("/user/{username}/todos/{id}")
		public ResponseEntity<Todo> getATodoOfUser(@PathVariable String username, @PathVariable int id){
//			Todo todo = todoService.findById(id);	
			Todo todo = null;
			Optional<Todo> findById = todoJpaRepository.findById(id);
			if(findById.isPresent()) {
				todo=findById.get();
			}
			return ResponseEntity.ok(todo);
		}
		
		@DeleteMapping("/delete/todo/{id}")
		public ResponseEntity<Void> DeleteATodo(@PathVariable int id) {
//			todoService.deleteById(id);
			todoJpaRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		
		@PutMapping("/user/{username}/todos/{id}")
		public Todo updateTodo(@PathVariable String username, @PathVariable Integer id, @RequestBody Todo todo) {
//			todoService.updateTodo(todo);
			todoJpaRepository.save(todo);
			return todo;
		}
		
		@SuppressWarnings("unchecked")
		@PostMapping("/user/{username}/todos")
		public ResponseEntity<Todo> createNewTodo(@PathVariable String username,@RequestBody Todo todo){
//			Todo createdTodo = todoService.addTodo(username, todo.getDescription(), todo.getTargetDate(), todo.isDone());
			todo.setUsername(username);
			todo.setId(null);
			todoJpaRepository.save(todo);
			
			URI location= ServletUriComponentsBuilder.fromCurrentRequest()
							.path("{username}").buildAndExpand(username)
							.toUri();
			return ResponseEntity.created(location).build();
		}
}