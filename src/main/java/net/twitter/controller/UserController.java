package net.twitter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.twitter.entity.User;
import net.twitter.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping
	public List<User> getAllUser() {
		return userService.getAllUser();
	}
	
	@PostMapping
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}
	
	@GetMapping("/{id}")
	public User findById(@PathVariable Long id) {
		return userService.findById(id).orElse(null);
	}
	
	@PutMapping("/{id}")
	public User updateById(@RequestBody User userDetail,@PathVariable Long id){
		User user = userService.findById(id).orElse(null);
		if(user != null) {
			user.setUsername(userDetail.getUsername() != null && !userDetail.getUsername().equals("") ? userDetail.getUsername() : user.getUsername());
			user.setEmail(userDetail.getEmail() != null && !userDetail.getEmail().equals("") ? userDetail.getEmail() : user.getEmail());
			user.setPassword(userDetail.getPassword() != null && !userDetail.getPassword().equals("")? userDetail.getPassword() : user.getPassword());
		}
		userService.createUser(user);
		return user;
	}
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable long id) {
		userService.deleteUser(id);
	}
}
