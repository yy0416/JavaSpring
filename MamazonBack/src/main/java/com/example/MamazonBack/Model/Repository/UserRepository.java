package com.example.MamazonBack.Model.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MamazonBack.Model.Entity.User;
@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
