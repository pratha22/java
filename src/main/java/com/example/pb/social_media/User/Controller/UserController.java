package com.example.pb.social_media.User.Controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import com.example.pb.social_media.User.User;
import com.example.pb.social_media.User.UserDaoService;
import com.example.pb.social_media.User.UserPosts;
import com.example.pb.social_media.User.repository.UserPostsRepository;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;


@RestController
public class UserController {
	
	public UserDaoService userDoaService;
	
	@Autowired
	public UserController(UserDaoService userDaoService) {
		this.userDoaService = userDaoService;
	}
	
	
	@GetMapping("/getAllUsers")
	public List<User> getAllUsers() {
		return  userDoaService.findAll();
		
	}
	
	/*@GetMapping("/user/{userId}")
	public User getUser(@PathVariable int userId) {
		User foundUser =  userDoaService.getUser(userId);
		
		if (foundUser == null) {
			throw new UserNotFoundException("User not found ... Pratha ");
		}
		
		return foundUser;
		
	} */
	

	//http://localhost:8080/users
	//EntityModel
	//WebMvcLinkBuilder
		
	@GetMapping("/users/{userId}")
	public EntityModel<User> getUser(@PathVariable int userId) {
		User foundUser = userDoaService.getUser(userId);
		
		if(foundUser==null)
			throw new UserNotFoundException("User not found ... Pratha ");
		
		EntityModel<User> entityModel = EntityModel.of(foundUser);
		
		WebMvcLinkBuilder link =  linkTo(methodOn(this.getClass()).getAllUsers());
		entityModel.add(link.withRel("all-users"));
		
		return entityModel;
	}
	
	
	
	/*@PostMapping("/saveUser")
	public void saveUser (@RequestBody User user) {
		userDoaService.save(user);
	}*/
	
	@PostMapping("/user")
	public ResponseEntity<User> saveUser (@Validated @RequestBody User user) {
		User savedUser = userDoaService.save(user);
		
		URI locationURI = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		return  ResponseEntity.created(locationURI ).build();
		
		//return  ResponseEntity.created(null ).build();
		//return ResponseEntity.status(201).build();
	}
	
	
	@DeleteMapping("/user/{userId}")
	public void deleteUser(@PathVariable int userId) {
		User foundUser =  userDoaService.getUser(userId);

		userDoaService.deleteUser(foundUser);
	}
	
	
	@PostMapping ("/saveposts/{userId}")
	public UserPosts saveUserPosts(@RequestBody UserPosts posts, @PathVariable String userId) {
		// int user_id = posts.getUser().getId();
		User user =  this.getUser(Integer.parseInt(userId)).getContent();

		 System.out.println("pratha ========== "+ user.getId());
		 
		 posts.setUser(user);
		
		 UserPosts savedPosts = userDoaService.saveUserPosts(posts);
		 return savedPosts;
		
		
	}
	

}
