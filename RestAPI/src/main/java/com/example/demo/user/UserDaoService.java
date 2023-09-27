package com.example.demo.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.validation.Valid;

@Component
public class UserDaoService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	private static List<User> users= new ArrayList<User>();	
	private static int count=0;
	
	static {
		users.add(new User(++count,"ashraf",LocalDate.now().minusYears(23)));
		users.add(new User(++count,"saif",LocalDate.now().minusYears(17)));
		users.add(new User(++count,"banu",LocalDate.now().minusYears(34)));
	}
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findUserById(int id) {
//		Predicate<? super User> predicate=user->user.getId()==id;
//		return users.stream().filter(predicate).findFirst().orElse(null);	
		User user = userRepository.findById(id).orElse(null);
		return user;
	}

	public User saveUser(User user) {
//		user.setId(++count);
//		users.add(user);
//		return user;
		User save = userRepository.save(user);
		return save;
	}

	public void deleteUserById(int id) {
		Predicate<? super User> predicate=user->user.getId()==id;
		users.removeIf(predicate);		
	}

	public Posts savePost(Posts post) {
		return postRepository.save(post);
	}
}
