package com.ashraf.basicwebApp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

	private static List<Todo> todoList= new ArrayList<Todo>();
	
	private static  int toDoCount=0;
	
	private TodoRepository todoRepository;

	public TodoService(TodoRepository todoRepository) {
		super();
		this.todoRepository = todoRepository;
	}

	static {
		todoList.add(new Todo(++toDoCount,"ashraf","Learn Spring boot",LocalDate.now().plusYears(1),false));
		todoList.add(new Todo(++toDoCount,"saif","Learn Medicibe",LocalDate.now().plusYears(5),false));
	}

	public List<Todo> getTodoByUserName(String userName) {
//		Predicate<? super Todo> predicate= todo -> todo.getUserName().equalsIgnoreCase(userName);
//		List<Todo> list = todoList.stream().filter(predicate).toList();
//		return list;
		List<Todo> todos = todoRepository.findByUserName(userName);
		return todos;
	}
	
	public void addNewTodos(String userName,String description,LocalDate targetDate, boolean isDone) {
//		todoList.add(new Todo(++toDoCount,userName,description,targetDate,isDone));
		Todo todo = new Todo();
		todo.setUserName(userName);
		todo.setDescription(description);
		todo.setTargetDate(targetDate);
		todo.setDone(isDone);
		todoRepository.save(todo);
	}
	
	public void deleteTodoListById(int id) {
//		Predicate<? super Todo> predicate= todo -> todo.getId()==id;
//		todoList.removeIf(predicate);
		todoRepository.deleteById(id);
	}

	public Todo findById(int id) {
//		Predicate<? super Todo> predicate= todo -> todo.getId()==id;
//		Todo todo = todoList.stream().filter(predicate).findFirst().get();
//		return todo;
		return todoRepository.findById(id).get();
	}

	public void updateToDo(Todo updatedTodo) {
//		Todo toDoData = findById(updatedTodo.getId());
//		int index = todoList.indexOf(toDoData);
//		toDoData.setDescription(updatedTodo.getDescription());
//		toDoData.setTargetDate(updatedTodo.getTargetDate());
//		todoList.set(index, toDoData);	
		todoRepository.save(updatedTodo);
	}
}
