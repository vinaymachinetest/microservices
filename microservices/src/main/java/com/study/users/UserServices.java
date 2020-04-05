package com.study.users;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.study.exceptions.UserNotFoundException;

@RestController
public class UserServices {
	@Autowired
	private UserDao userdao;
	
	//Retrieve all users
	@GetMapping("/users")
	public List<User> findAll(){
		return userdao.getAll();
	}
	
	//Retrieve specific user
	@GetMapping("/users/{id}")
	public User find(@PathVariable int id){
		User user = userdao.getUser(id);
		//implementing exception handling
		if(user == null) {
			throw new UserNotFoundException("ID "+id);			
		}
		return userdao.getUser(id);
	}
	
	//add users
	@PostMapping("/users")
	public ResponseEntity<Object> create(@RequestBody User user){
		
		User addUser = userdao.addUser(user);
		//Returning the URI in header for the newly created user or location of resource created
		URI location =  ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(addUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	//delete specific user
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id){
		User user = userdao.deleteById(id);
		//implementing exception handling
		if(user == null) {
			throw new UserNotFoundException("ID "+id);			
		}
		
	}
}
