package com.study.users;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.study.exceptions.UserNotFoundException;

@SuppressWarnings("deprecation")
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
	public EntityModel<User> find(@PathVariable int id){
		User user = userdao.getUser(id);
		//implementing exception handling
		if(user == null) {
			throw new UserNotFoundException("ID "+id);			
		}
		
		//implementing hateoas
		EntityModel<User> model = new EntityModel<>(user);
		WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).findAll());
		model.add(linkTo.withRel("all-users"));
		return model;
		
		//old version
		/*Resource<User> resource = new Resource<User>(user);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		resource.add(linkTo.withRel("all-users"));
		return resource;*/
	}
	
	//add users
	@PostMapping("/users")
	public ResponseEntity<Object> create(@Valid @RequestBody User user){
			
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
