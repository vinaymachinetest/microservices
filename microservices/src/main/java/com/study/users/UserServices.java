package com.study.users;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserServices {
	@Autowired
	private UserDao userdao;
	
	//Retrieve all users
	@GetMapping("/userslist")
	public List<User> findAll(){
		return userdao.getAll();
	}
	
	//Retrieve specific user
	@GetMapping("/user/{id}")
	public User find(@PathVariable int id){
		return userdao.getUser(id);
	}
	
	//add users
	@PostMapping("/user")
	public ResponseEntity<Object> create(@RequestBody User user){
		
		User addUser = userdao.addUser(user);
		//Returning the URI in header for the newly created user
		URI location =  ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(addUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
}
