package test.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import test.example.exception.ResourceNotFoundException;
import test.example.model.User;
import test.example.service.UserService;

@RestController
@RequestMapping("/hotel")
public class UserController {
	@Autowired
	UserService userService;
	
	@GetMapping("/user")
	public List<User> getAllUser(){
		return userService.getAllUser();
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteUserById(@PathVariable long id){
		userService.deleteUserById(id);
	}
	
	@PostMapping("/user")
	public User create(@RequestBody User user){
		
		System.out.println(user);
		return userService.save(user);
	}
	
	@GetMapping("/user/{id}")
	public User findById(@PathVariable long id){
		return userService.findUserById(id)
				.orElseThrow(()-> new ResourceNotFoundException("User", "id", id));
	}
	
	
}
