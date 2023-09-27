package com.example.demo.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import jakarta.validation.Valid;

@RestController
public class UserController {
	
	private UserDaoService userDaoService;

	public UserController(UserDaoService userDaoService) {
		super();
		this.userDaoService = userDaoService;
	}
	
	@GetMapping(path = "users")
	public MappingJacksonValue getAllUsers() {
		List<User> userList = userDaoService.findAll();
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(userList);
		SimpleBeanPropertyFilter addFilter = SimpleBeanPropertyFilter.filterOutAllExcept("name", "birthDate");
		FilterProvider filter = new SimpleFilterProvider().addFilter("BeanFilter", addFilter);
		mappingJacksonValue.setFilters(filter);
		return mappingJacksonValue;
	}
	
	@GetMapping(path="test")
	public String getTheString() {
		return "Hello";
	}
	
	@GetMapping(path = "users/{id}")
	public EntityModel<User> getAUser(@PathVariable int id){
		User findUserById = userDaoService.findUserById(id);
		if(User.isEmpty(findUserById)) {
			throw new UserNotFoundException("User not found for id :"+id);
		}
		
		EntityModel<User> entityModel = EntityModel.of(findUserById);
		WebMvcLinkBuilder link=linkTo(methodOn(this.getClass()).getAllUsers());
		entityModel.add(link.withRel("all-users"));
		return entityModel;
	}
	
	
	@PostMapping(path = "users")
	public ResponseEntity<User> saveUser(@Valid @RequestBody User user) {
		User savedUser= this.userDaoService.saveUser(user);
		
		URI location=ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(savedUser.getId())
					.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping(path="users/{id}")
	public void deleteUser(@PathVariable int  id) {
		userDaoService.deleteUserById(id);
	}
	
	@GetMapping(path="users/{id}/posts")
	public List<Posts> getUserPosts(@PathVariable int  id) {
		User userData = userDaoService.findUserById(id);
		if(User.isEmpty(userData)) {
			throw new UserNotFoundException("User not found for id :"+id);
		}
		
		List<Posts> posts = userData.getPosts();
		return posts;
	}
	
	
	@PostMapping(path="users/{id}/posts")
	public ResponseEntity<Posts> saveUserPosts(@PathVariable int  id,@Valid @RequestBody Posts post) {
		User userData = userDaoService.findUserById(id);
		if(User.isEmpty(userData)) {
			throw new UserNotFoundException("User not found for id :"+id);
		}
		
		post.setUser(userData);
		Posts savePost = userDaoService.savePost(post);
		
		URI uri=ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savePost.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
		
	}
}
