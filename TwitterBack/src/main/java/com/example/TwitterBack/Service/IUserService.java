package com.example.TwitterBack.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TwitterBack.Model.Entity.IUser;
import com.example.TwitterBack.Model.Repository.IUserRepository;

@Service
public class IUserService {
	@Autowired
	private IUserRepository iuserRp;
	
	//create user
	public IUser addUtilisateur(IUser iuser) {
		return this.iuserRp.save(iuser);
		
	}
	//recuperer tous les utilisateurs
	public List<IUser> getAllUser(){
		return this.iuserRp.findAll();
	}
	//recuperer information par id
	public IUser getInfoById(Long id) {
		return this.iuserRp.findById(id).get();
	}
	
	
	
	//recuperer information par nom
	public IUser getInfoByName(String username) {
        Optional<IUser> user = iuserRp.findByUsername(username);
        return user.orElse(null);
    }
	
	//mettre à jour information d'un utilisateur
	public IUser updateUser(String username, IUser iuser) {
		Optional<IUser> user = iuserRp.findByUsername(username);
		if(user.isPresent()) {
			IUser iuser2 = user.get();
			iuser2.setUsername(iuser.getUsername());
			iuser2.setPassword(iuser.getPassword());
			return iuserRp.save(iuser2);
			
		}else {
			return null;
		}
		
		
	
	}
	
	//supprimer utilisateur
	public void deleteUserByName(String username) {
		IUser iuser = this.getInfoByName(username);
		if(iuser!= null) {
			this.iuserRp.delete(iuser);
		}

	}
	
	//Authentification de prof
	public Boolean loginUser(String username,String password) {
		List<IUser> users =(List<IUser>) this.getAllUser();
		return users.stream().anyMatch(user->
			(user.getUsername().equals(username)&&user.getPassword().equals(password))
		);  
		
	}
	
	//Authentification de moi 
	public IUser authentificationUser(String username,String password) {
		IUser iuser = getInfoByName(username);
		if (iuser!= null && iuser.getPassword().equals(password)) {
			return iuser;
		}else {
			return null;
		}
	}
	

}
