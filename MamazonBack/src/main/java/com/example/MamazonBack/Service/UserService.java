package com.example.MamazonBack.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MamazonBack.Model.DTO.UserDTO;
import com.example.MamazonBack.Model.Entity.User;
import com.example.MamazonBack.Model.Repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private PanierService panierService;
private UserRepository userRp;

//add user //register
public User createUser(User user){
	return this.userRp.save(user);
}
//find by id
public User findUserById(Long id) {
	return this.userRp.findById(id).get();
}

//get all users
public List<User> findAllUsers(){
	return this.userRp.findAll();
}

//update users
public User updateUser(Long id, User user) {
	User us = this.userRp.findById(id).get();
	us.setAge(user.getAge());
	us.setEmail(user.getEmail());
	us.setName(user.getName());
	us.setPanier(user.getPanier());
	us.setPassword(user.getPassword());
	return this.userRp.save(us);
	
	
}



//delete
public void deleteUserById(Long id) {
	this.userRp.deleteById(id);
}

//findByName
public Optional<User> findByUserName(String username){
	return this.findByUserName(username);
}

//login
public boolean loginUser(String username, String password) {
List<User> users = this.findAllUsers();
return users.stream().anyMatch(user->(user.getName().equals(username)&&user.getPassword().equals(password)));

}

public UserDTO convertToUserDTO(User user) {
	UserDTO userdto = new UserDTO();
	userdto.setAge(user.getAge());
	userdto.setEmail(user.getEmail());
	userdto.setName(user.getName());
	userdto.setPanierId(user.getPanier().getId());
	userdto.setPassword(user.getPassword());
	userdto.setId(user.getId());
	return userdto;
	
	
}

public User convertToUser(UserDTO userdto) {
	User user = new User();
	user.setAge(userdto.getAge());
	user.setEmail(userdto.getEmail());
	user.setId(userdto.getId());
	user.setPassword(userdto.getPassword());
	user.setName(userdto.getName());
	user.setPanier(panierService.getPanierById(userdto.getPanierId()));
	return user;
}







}
