package com.example.TwitterBack.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.TwitterBack.Model.Entity.IUser;
import com.example.TwitterBack.Service.IUserService;

@RestController
public class IUserController {
@Autowired
	private IUserService iuserS;
@PostMapping("/user")
public IUser add(@RequestBody IUser iuser) {
	return this.iuserS.addUtilisateur(iuser);
}

@GetMapping("/user")
public List<IUser> getUser(){
	return this.iuserS.getAllUser();
}

@GetMapping("/user/{username}")
public IUser getByName(@PathVariable String username) {
	return this.iuserS.getInfoByName(username);
}

@PutMapping("/user/{username}")
public IUser updateByName(@PathVariable String username,@RequestBody IUser iuser){
	return this.iuserS.updateUser(username, iuser);
} 

@DeleteMapping("/user/{username}")
public void deleteByName(@PathVariable String username) {
	this.iuserS.deleteUserByName(username);
}

@CrossOrigin
@PostMapping("/user/login")
public ResponseEntity<String> login(@RequestBody IUser iuser){
	Boolean isAuthenticated = iuserS.loginUser(iuser.getUsername(), iuser.getPassword());
	if(isAuthenticated) {
		return ResponseEntity.ok("réussi");
	}else {
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Vous avez trompé");
	}
	
}



}
