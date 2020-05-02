package com.study.jpa;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
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
public class JpaServices {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserPostRepository userPostRepository;

	// Retrieve all users
	@GetMapping("/jpa/users")
	public List<JpaUser> retrieveAll() {
		return userRepository.findAll();
	}

	// Retrieve specific user
	@GetMapping("/jpa/users/{id}")
	public EntityModel<JpaUser> find(@PathVariable int id) {
		Optional<JpaUser> user = userRepository.findById(id);
		// implementing exception handling
		if (!user.isPresent()) {
			throw new UserNotFoundException("ID " + id);
		}
		// implementing hateoas
		EntityModel<JpaUser> model = new EntityModel<JpaUser>(user.get());
		WebMvcLinkBuilder linkTo = WebMvcLinkBuilder
				.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).retrieveAll());
		model.add(linkTo.withRel("all-users"));
		return model;
	}

	// delete specific user
	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable int id) {
		userRepository.deleteById(id);
		;
	}

	// add users
	@PostMapping("/jpa/users")
	public ResponseEntity<Object> create(@Valid @RequestBody JpaUser user) {

		JpaUser addUser = userRepository.save(user);
		// Returning the URI in header for the newly created user or location of
		// resource created
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(addUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	// Retrieve all posts for specific user
	@GetMapping("/jpa/user/{id}/posts")
	public List<UserPost> retrieveAllPosts(@PathVariable int id) {

		Optional<JpaUser> jpaUser = userRepository.findById(id);

		if (!jpaUser.isPresent()) {
			throw new UserNotFoundException("ID " + id);
		}
		return jpaUser.get().getPosts();

	}

	// add posts for specific user
	@PostMapping("/jpa/user/{id}/posts")
	public ResponseEntity<Object> createPost(@PathVariable int id, @RequestBody UserPost post) {

		Optional<JpaUser> jpa = userRepository.findById(id);

		if (!jpa.isPresent()) {
			throw new UserNotFoundException("ID " + id);
		}
		
		JpaUser user =  jpa.get();
		post.setUser(user);
		
		 userPostRepository.save(post);
		// Returning the URI in header for the newly created user or location of
		// resource created
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

}
