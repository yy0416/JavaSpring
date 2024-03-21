package com.example.TwitterBack.Model.Repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.TwitterBack.Model.Entity.IUser;

@Repository
public interface IUserRepository extends JpaRepository<IUser,Long> {
	Optional<IUser> findByUsername(String username);
}

