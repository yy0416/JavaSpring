package com.example.TwitterBack.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.TwitterBack.Model.DTO.IMessageDTO;

import com.example.TwitterBack.Service.IMessageService;

@RestController
@RequestMapping("/message")
public class IMessageController {
    @Autowired
    private IMessageService msgS;
    
    @PostMapping
    public IMessageDTO addMessage(@RequestBody IMessageDTO imsgdto){
    	return this.msgS.addMessage(imsgdto);
    }
    
  //  @GetMapping(name="/{username}")
  //  public IMessageDTO getMessageByUsername(@PathVariable String username) {
   // 	return this.msgS.findMessageByName(username);
   // }
    
    @GetMapping(name="/{id}")
    public IMessageDTO getMessageById(@PathVariable Long id){
    	return this.msgS.findMessageById(id);
    }
    
    @PutMapping(name="/{id}")
    public IMessageDTO updateMessageById(@RequestBody IMessageDTO contenu,@PathVariable Long id) {
    	return this.msgS.updateMessage(contenu, id);
    }
    
    @DeleteMapping(name="/{id}")
    public void deleteMessageById(@PathVariable Long id) {
    	this.msgS.deleteMessageById(id);
    }

   
}
