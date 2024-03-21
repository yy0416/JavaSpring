package com.example.TwitterBack.Model.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TwitterBack.Model.Entity.IMessage;


public interface IMessageRepository extends JpaRepository<IMessage,Long>{
 Optional<IMessage> findMessageByUsername(String username);
}
