package com.example.MamazonBack.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MamazonBack.Model.Entity.User;
import com.example.MamazonBack.Service.UserService;

@CrossOrigin("*")
@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
private UserService userService;

	@GetMapping()
public List<User> getUsers() {
	return this.userService.findAllUsers();
}
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable Long id){
		return this.userService.findUserById(id);
	}
	
	
	@PutMapping("/{id}")
	public User updateUser(@PathVariable Long id, @RequestBody User user) {
	return this.userService.updateUser(id, user);
	
		
	}
	@PostMapping
	public User cresteUser(@RequestBody User user) {
		return this.userService.createUser(user);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable Long id) {
		this.userService.deleteUserById(id);
	}
	
	@PostMapping("/login")
	public String login(@RequestBody User user) {
		boolean res = this.userService.loginUser(user.getName(), user.getPassword());
		if(res) {
			return "reussir";
		}else {
			return "Erreur";
		}
	}
	@PostMapping("/register")
	public User register(User user) {
		return this.userService.createUser(user);
	}
	
	

}
